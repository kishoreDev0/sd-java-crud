package com.ta.crud.Utilities.Generic;

import org.springframework.stereotype.Component;

@Component
public class GenericResponseBuilder {

    public  <T> GenericResponse<T> success(int statusCode,Boolean status , T data, String message) {
        return new GenericResponse<>(statusCode, status, message, data);
    }

    public  <T> GenericResponse<T> noContent(int statusCode, T data, String message) {
        return new GenericResponse<>(statusCode, true, message, data);
    }

    public  <T> GenericResponse<T> error(int statusCode,String message) {
        return new GenericResponse<>(statusCode, false, message, null);
    }

     public  <T> GenericResponse<T> info(int statusCode,String message) {
        return new GenericResponse<>(statusCode, false, message, null);
    }
}