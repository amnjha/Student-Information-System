package com.example.sis.controller;

import com.example.sis.data.RestResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public abstract class MVCController {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public RestResponse handleException(Exception e){
        RestResponse restResponse = RestResponse.buildRestResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), null, e.getMessage());
        return  restResponse;
    }
}
