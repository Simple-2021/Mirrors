package com.example.mirrors.configuration

import org.springframework.boot.autoconfigure.web.ErrorProperties
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes
import org.springframework.boot.web.servlet.error.ErrorAttributes
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class WebExceptionConfiguration {

    @Bean
    fun errorAttributes(): ErrorAttributes {
        return DefaultErrorAttributes()
    }

    @Bean
    fun errorProperties(): ErrorProperties {
        return ErrorProperties()
    }

}