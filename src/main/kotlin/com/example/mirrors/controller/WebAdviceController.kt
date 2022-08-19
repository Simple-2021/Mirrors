package com.example.mirrors.controller

import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.ModelAndView
import java.util.*
import javax.annotation.Resource

@ControllerAdvice
class WebAdviceController {

    @ExceptionHandler(value = [Exception::class])
    fun anyException(e: Exception): ModelAndView {
        return ModelAndView("application")
    }

}