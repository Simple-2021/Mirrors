package com.example.mirrors.configuration

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport
import org.springframework.web.servlet.view.InternalResourceViewResolver

@Configuration
class AppSupportConfiguration : WebMvcConfigurationSupport() {

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
