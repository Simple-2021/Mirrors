package com.example.mirrors.configuration

import com.google.gson.JsonObject
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource
import java.io.File
import java.util.*

@Configuration
class AppConfiguration {

    @Bean(name = ["mirrors"])
    fun getMirrors(): JsonObject{
        return JsonObject()
    }

    @Bean(name = ["upload"])
    fun upload(): String {
        val target = File("target")
        if (!target.exists()) {
            target.mkdir()
        }
        return "target"
    }

    @Bean(name = ["favicon"])
    fun favicon(): ByteArray {
        return ClassPathResource("application/default").inputStream.readBytes()
    }

    @Bean(name = ["darkicon"])
    fun darkicon(): ByteArray {
        return ClassPathResource("application/dark").inputStream.readBytes()
    }

}