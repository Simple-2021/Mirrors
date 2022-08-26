package com.example.mirrors.controller

import org.springframework.web.bind.annotation.DeleteMapping
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
    fun getCount(): Int {
        return mirrors.size
    }

    @DeleteMapping("/")
    fun removeAll() {
        for (i in 1 until mirrors.size) mirrors.removeLast()
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
    fun postMirror(mirror: String) {
        if (mirror.isNotEmpty()) synchronized(this) { mirrors.add(mirror) }
    }


}