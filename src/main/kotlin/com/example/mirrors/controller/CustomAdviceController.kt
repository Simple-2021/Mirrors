package com.example.mirrors.controller

import com.google.gson.GsonBuilder
import org.apache.commons.logging.LogFactory
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.ModelAndView
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@ControllerAdvice
class CustomAdviceController {

    @ExceptionHandler(value = [Exception::class])
    fun anyException(e: Exception, request: HttpServletRequest, response: HttpServletResponse): ModelAndView {
        val info = LogFactory.getLog(javaClass.simpleName)
        val except = GsonBuilder().disableHtmlEscaping().create().toJson(object : HashMap<String, String?>() {
            init {
                put(request.requestURI, e.message)
            }
        })
        request.session.setAttribute("except", except)
        if (response.status == 200) {
            info.info(response.status)
            info.info(except)
        } else {
            info.warn(response.status)
            info.warn(except)
        }
        response.status = 200
        return ModelAndView("application")
    }

}