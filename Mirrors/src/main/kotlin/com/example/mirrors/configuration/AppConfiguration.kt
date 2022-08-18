package com.example.mirrors.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.*

@Configuration
class AppConfiguration {

    @Bean(name = ["data"])
    fun getData(): LinkedList<String?>? {
        return object : LinkedList<String?>() {
            init {
                add("Unit")
            }
        }
    }

}