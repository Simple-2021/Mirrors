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
    fun getMirror(): String {
        return mirrors.last
    }

    @PostMapping("/api")
    fun postMirror(content: String, response: HttpServletResponse) {
        if (content.isNotEmpty()) mirrors.add(content) else response.status = 400
    }

}