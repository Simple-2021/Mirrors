package com.example.mirrors.controller

import com.example.mirrors.service.DownloadService
import com.example.mirrors.service.UploadService
import com.example.mirrors.util.CustomModel
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import java.util.*
import javax.annotation.Resource
import javax.servlet.http.HttpServletResponse


@RestController
class AppDataController {

    @Resource(name = "mirrors")
    private lateinit var mirrors: TreeMap<Date, String>

    @PostMapping("/")
    fun postMirror(mirror: String) {
        if (mirror.isNotEmpty()) synchronized(this) { mirrors.put(Date(), mirror) }
    }

    @GetMapping("/api")
    fun getCount(): Int {
        return mirrors.size
    }

    @GetMapping("/api/mirror")
    fun getMirror(): HashMap<String, Any> {
        return object : HashMap<String, Any>() {
            init {
                put("mirror", mirrors.lastEntry().value)
                put("count", mirrors.size)
            }
        }
    }

    @Resource(name = "uploadService")
    private lateinit var upload: UploadService

    @PostMapping("/api/upload")
    fun uploads(file: Array<MultipartFile>) {
        upload.upload(file)
    }

    @Resource(name = "downloadService")
    private lateinit var download: DownloadService

    @GetMapping("/api/download")
    fun download(file: String?, response: HttpServletResponse) {
        if (file.isNullOrEmpty()) {
            val m = CustomModel()
            m.setLanguage("zh-CN")
            m.setCharset("UTF-8")
            m.insertWithEntries(mirrors.entries)
            response.contentType = "application/octet-stream"
            response.setHeader("Content-Disposition", "attachment;filename=" + "Mirrors.html")
            response.outputStream.write(m.getHtml().toByteArray(Charsets.UTF_8))
            response.flushBuffer()
        } else {
            download.download(file, response)
        }
    }

}