package com.example.mirrors.exception

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import java.lang.reflect.Array
import java.lang.reflect.Method

@Data
@NoArgsConstructor
@AllArgsConstructor
class WebUserException(var method: Method, var params: Array?) : WebAppException(500,"UserException")