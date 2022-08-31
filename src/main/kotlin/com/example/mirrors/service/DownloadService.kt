package com.example.mirrors.service

import org.springframework.stereotype.Service
import java.io.File
import java.net.URLEncoder
import javax.annotation.Resource
import javax.servlet.http.HttpServletResponse

@Service
class DownloadService {

    @Resource(name = "upload")
    private lateinit var uploads: String

    fun download(file: String, response: HttpServletResponse) {
        response.contentType = "application/octet-stream"
        response.setHeader(
            "Content-Disposition",
            "attachment;filename=" + URLEncoder.encode(file, "utf-8").replace("+", "%20")
        )
        response.outputStream.write(getByteArray(file))
        response.flushBuffer()
    }

    fun getByteArray(file: String): ByteArray {
        val temp = File("$uploads/$file")
        if (temp.exists() && temp.isFile) {
            return temp.readBytes()
        } else {
            throw NullPointerException()
        }
    }

}