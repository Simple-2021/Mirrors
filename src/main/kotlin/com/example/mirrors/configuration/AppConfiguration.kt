package com.example.mirrors.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource
import java.util.*

@Configuration
class AppConfiguration {

    @Bean(name = ["mirrors"])
    fun getMirrors(): LinkedList<String> {
        return object : LinkedList<String>() {
            init {
                add("Unit")
            }
        }
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