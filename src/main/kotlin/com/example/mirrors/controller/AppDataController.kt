package com.example.mirrors.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
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

    @GetMapping("/api/download")
    fun download(@RequestParam(defaultValue = "mirrors.txt") file: String?, response: HttpServletResponse) {
        response.contentType = "application/octet-stream"
        response.setHeader("Content-Disposition", "attachment;filename=$file")
        var body = String()
        for (i in mirrors) {
            body += i.toString() + "\n"
        }
        response.outputStream.write(body.encodeToByteArray())
    }


}