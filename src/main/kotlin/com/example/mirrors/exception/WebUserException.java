package com.example.mirrors.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Array;
import java.lang.reflect.Method;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WebUserException extends WebAppException {
    private Method method;
    private Array params;


}
