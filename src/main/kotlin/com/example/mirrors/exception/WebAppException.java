package com.example.mirrors.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WebAppException extends Exception {
    protected int code;
    protected String exception;


}