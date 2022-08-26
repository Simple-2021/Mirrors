package com.example.mirrors.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import javax.annotation.Resource
import javax.servlet.http.HttpServletResponse

@Controller
class AppController {

    @Resource(name = "favicon")
    private lateinit var favicon: ByteArray

    @Resource(name = "darkicon")
    private lateinit var darkicon: ByteArray

    @GetMapping("/")
    fun index(): String {
        return "application"
    }

    @ResponseBody
    @RequestMapping("/favicon.ico")
    fun icon(dark: Boolean, response: HttpServletResponse) {
        response.contentType = "image/svg+xml"
        if (dark) {
            response.outputStream.write(darkicon)
        } else {
            response.outputStream.write(favicon)
        }
    }

}