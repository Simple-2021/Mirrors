package com.example.mirrors.configuration

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import org.springframework.web.servlet.view.InternalResourceViewResolver

@Configuration
class AppSupportConfiguration : WebMvcConfigurer {

    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/**")
            .allowCredentials(true)
            .allowedOriginPatterns("*")
            .allowedMethods("GET", "PUT", "POST", "DELETE")
            .allowedHeaders("*")
            .exposedHeaders("*")
            .maxAge(3600)
        super.addCorsMappings(registry)
    }

    override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/")
        super.addResourceHandlers(registry)
    }

    override fun configureViewResolvers(registry: ViewResolverRegistry) {
        val inter = InternalResourceViewResolver()
        inter.setPrefix("/")
        inter.setSuffix(".html")
        registry.viewResolver(inter)
        super.configureViewResolvers(registry)
    }

}
