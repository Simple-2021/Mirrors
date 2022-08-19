package com.example.mirrors.exception

open class WebHostException(status: Int, url: String) : WebAppException(400, "MvcException")