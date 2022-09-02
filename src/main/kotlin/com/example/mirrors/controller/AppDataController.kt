package com.example.mirrors.controller

import com.example.mirrors.service.DownloadService
import com.example.mirrors.service.MirrorService
import com.example.mirrors.service.UploadService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import java.io.IOException
import javax.annotation.Resource
import javax.servlet.http.HttpServletResponse


@RestController
class AppDataController {

    @Autowired
    private lateinit var mirrors: MirrorService

    @PostMapping("/")
    fun postMirror(mirror: String): String {
        return try {
            mirrors.append(mirror)
        } catch (e: IOException) {
            false
        }.toString()
    }

    @GetMapping("/api")
    fun getCount(): Int {
        return mirrors.getCount()
    }

    @GetMapping("/api/mirror")
    fun getMirror(i: Int?): String {
        return try {
            mirrors.get(i)
        } catch (e: Exception) {
            try {
                mirrors.getLast()
            } catch (e: Exception) {
                false
            }
        }.toString()
    }

    @Resource(name = "uploadService")
    private lateinit var upload: UploadService

    @PostMapping("/api/upload")
    fun uploads(file: Array<MultipartFile>): String {
        return try {
            upload.upload(file)
        } catch (e: Exception) {
            false
        }.toString()
    }

    @Resource(name = "downloadService")
    private lateinit var download: DownloadService

    @GetMapping("/api/download")
    fun download(file: String?, response: HttpServletResponse): String {
        return try {
            if (file.isNullOrEmpty()) {
                response.writer.println(download.filesInfo())
                response.flushBuffer()
            } else {
                download.download(file, response)
            }
        } catch (e: Exception) {
            false
        }.toString()
    }

}