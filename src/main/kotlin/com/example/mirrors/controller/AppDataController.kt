package com.example.mirrors.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*
import javax.annotation.Resource
import javax.servlet.http.HttpServletResponse


@RestController
class AppDataController {

    @Resource(name = "mirrors")
    private lateinit var mirrors: LinkedList<String>

    @PostMapping("/")
    fun getCount(): Long {
        return mirrors.size.toLong()
    }

    @GetMapping("/api")
    fun getMirror(): HashMap<String, String> {
        return object : HashMap<String, String>() {
            init {
                put("mirror", mirrors.last)
            }
        }
    }

    @PostMapping("/api")
    fun postMirror(mirror: String, response: HttpServletResponse) {
        synchronized(this) {
            if (mirror.isNotEmpty()) mirrors.add(mirror.trim())
        }
    }

}