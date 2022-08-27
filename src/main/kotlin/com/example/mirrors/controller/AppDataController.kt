package com.example.mirrors.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*
import javax.annotation.Resource


@RestController
class AppDataController {

    @Resource(name = "mirrors")
    private lateinit var mirrors: LinkedList<String>

    @PostMapping("/")
    fun postMirror(mirror: String) {
        if (mirror.isNotEmpty()) synchronized(this) { mirrors.add(mirror) }
    }

    @GetMapping("/api")
    fun getCount(): Int {
        return mirrors.size
    }

    @GetMapping("/api/mirror")
    fun getMirror(): HashMap<String, Any> {
        return object : HashMap<String, Any>() {
            init {
                put("mirror", mirrors.last)
                put("count", mirrors.size)
            }
        }
    }

    @PostMapping("/api")
    fun download() {
        synchronized(this) {
            for (i in mirrors) {
                println(i)
            }
        }
    }


}