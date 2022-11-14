package com.example.ordermodule.dto;

public class ResponseDto {
    private String message;
    private Object data;
    public ResponseDto(String message,Object data){
        this.message=message;
        this.data=data;
    }
}
