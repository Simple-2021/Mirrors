package com.example.mirrors.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource
import java.util.*

@Configuration
class AppConfiguration {

    @Bean(name = ["mirrors"])
    fun getMirrors(): TreeMap<Date, String> {
        return object : TreeMap<Date, String>() {
            init {
                put(Date(), "Unit")
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