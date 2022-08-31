package com.example.mirrors.controller

import com.example.mirrors.service.DownloadService
import com.example.mirrors.service.UploadService
import com.google.gson.JsonObject
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
    private lateinit var mirrors: JsonObject

    @PostMapping("/")
    fun postMirror(mirror: String) {
        if (mirror.isNotEmpty()) {
            synchronized(this) {
                val json = JsonObject()
                json.addProperty("K", "${Date()}")
                json.addProperty("V", mirror)
                val index = "" + mirrors.size()
                mirrors.add(index, json)
            }
        }
    }

    @GetMapping("/api")
    fun getCount(): Int {
        return mirrors.size()
    }

    @GetMapping("/api/mirror")
    fun getMirror(index: Int?): String? {
        return try {
            val json = when {
                index == null -> {
                    mirrors["" + (mirrors.size() - 1)].asJsonObject
                }
                index < mirrors.size() -> {
                    mirrors["" + index].asJsonObject
                }
                else -> {
                    mirrors["" + (mirrors.size() - 1)].asJsonObject
                }
            }
            json.addProperty("K", mirrors.size())
            json.toString()
        } catch (e: Exception) {
            e.printStackTrace()
            null
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
            response.writer.println(download.filesInfo())
            response.flushBuffer()
        } else {
            download.download(file, response)
        }
    }

}