package com.example.mirrors.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*
import javax.annotation.Resource
import javax.servlet.http.HttpServletResponse

@RestController
class AppDataController {


    @Resource(name = "data")
    private lateinit var array: LinkedList<String>

    @PostMapping("/")
    fun getIndex(): Long {
        return array.size.toLong()
    }

    @GetMapping("/api")
    fun get(): String {
        return array.last
    }

    @PostMapping("/api")
    fun post(content: String, response: HttpServletResponse) {
        if (content.isNotEmpty()) {
            array.add(content)
            response.status = 200
        } else {
            response.status = 400
        }
    }

}