package com.example.mirrors.controller

import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.ModelAndView
import java.util.*
import javax.annotation.Resource

@ControllerAdvice
class WebAdviceController {

    @Resource(name = "mirrors")
    private lateinit var mirrors: LinkedList<String>

    @ExceptionHandler(value = [Exception::class])
    fun anyException(e: Exception): ModelAndView {
        if (e.javaClass == OutOfMemoryError().javaClass) {
            mirrors = object : LinkedList<String>() {
                init {
                    add(mirrors.last)
                    println(mirrors.size)
                }
            }
        }
        return ModelAndView("application")
    }
}