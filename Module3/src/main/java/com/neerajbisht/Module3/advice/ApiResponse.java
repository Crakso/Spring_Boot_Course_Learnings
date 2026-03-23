package com.neerajbisht.Module3.advice;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApiResponse<T>{

    private LocalDateTime timestamp;
    private T body;
    private ApiError apiError;

    public ApiResponse(){
        this.timestamp=LocalDateTime.now();
    }

    public ApiResponse(T body){
        this();
        this.body = body;
    }

    public ApiResponse(ApiError apiError){
        this();
        this.apiError = apiError;
    }

}
