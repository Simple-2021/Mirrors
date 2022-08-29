package com.example.mirrors.controller

import org.apache.commons.logging.LogFactory
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.ModelAndView
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@ControllerAdvice
class WebAdviceController {

    @ExceptionHandler(value = [Exception::class])
    fun anyException(e: Exception, request: HttpServletRequest, response: HttpServletResponse): ModelAndView {
        val info = LogFactory.getLog("Application.Exception.Logic")
        val except = request.requestURI + "\t" + response.status + "\n" + e
        request.session.setAttribute("except", except)
        if (response.status == 200) {
            info.info(except)
        } else {
            info.warn(except)
        }
        return ModelAndView("application")
    }

}