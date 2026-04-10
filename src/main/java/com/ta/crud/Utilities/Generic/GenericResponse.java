package com.ta.crud.Utilities.Generic;

public class GenericResponse<T> {
    
    private int statusCode;
    private boolean status;
    private String message;
    private T data;

    // Constructor
    GenericResponse(){}

    // Args
    public GenericResponse(int statusCode, boolean status , String message, T data){
        this.statusCode = statusCode;
        this.status = status;
        this.message = message;
        this.data = data;
    }

    
    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage(){
        return message;
    }

    public void setMessage(String message){
        this.message = message; 
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


}
