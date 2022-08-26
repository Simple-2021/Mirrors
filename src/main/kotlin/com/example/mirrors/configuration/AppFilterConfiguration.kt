package com.example.mirrors.configuration

import org.springframework.context.annotation.Configuration
import javax.servlet.Filter
import javax.servlet.FilterChain
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse

@Configuration
class AppFilterConfiguration : Filter {

    override fun doFilter(p0: ServletRequest, p1: ServletResponse, p2: FilterChain) {
        p2.doFilter(p0, p1)
    }

}