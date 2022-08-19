package com.example.mirrors.exception

import java.lang.reflect.Array
import java.lang.reflect.Method

open class WebMethodException(var method: Method, var params: Array?) : WebAppException(500, "ApiException")