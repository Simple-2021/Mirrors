package com.example.mirrors.service

import com.example.mirrors.util.CustomModel
import com.example.mirrors.util.ErrorModel
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
        val temp = File("$uploads/$file")
        if (temp.exists() && temp.isFile) {
            response.contentType = "application/octet-stream"
            response.setHeader(
                "Content-Disposition",
                "attachment;filename=" + URLEncoder.encode(file, "utf-8").replace("+", "%20")
            )
            response.outputStream.write(temp.readBytes())
            response.flushBuffer()
        } else {
            response.writer.println(ErrorModel(404, temp).toHTML())
        }
    }

    fun filesInfo(): String {
        val root = File(uploads)
        val map = HashMap<Any, Any>()
        for (i in root.listFiles()!!) {
            if (i.isFile) {
                map[i.name] = "<a href=\"/api/download?file=${i.name}\">Download</a>"
            }
        }
        val m = CustomModel()
        m.insertWithEntries(map.entries)
        return m.getHTML()
    }


}