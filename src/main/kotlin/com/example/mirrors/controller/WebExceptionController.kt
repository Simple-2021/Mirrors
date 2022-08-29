package com.example.mirrors.controller

import org.apache.commons.logging.LogFactory
import org.springframework.boot.autoconfigure.web.ErrorProperties
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController
import org.springframework.boot.web.servlet.error.ErrorAttributes
import org.springframework.http.MediaType
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Controller
@RequestMapping("\${server.error.path:\${error.path:/error}}")
class WebExceptionController(errorAttributes: ErrorAttributes, errorProperties: ErrorProperties) :
    BasicErrorController(errorAttributes, errorProperties) {

    override fun errorHtml(request: HttpServletRequest, response: HttpServletResponse): ModelAndView {
        val info = LogFactory.getLog("Application.Exception.Servlet")
        val error = getErrorAttributes(request, getErrorAttributeOptions(request, MediaType.TEXT_HTML))
        when {
            response.status >= 500 -> {
                info.warn(error)
            }
            response.status >= 400 -> {
                info.info(error)
            }
            else -> {
                info.info(error)
            }
        }
        response.status = 200
        return ModelAndView("application")
    }

}