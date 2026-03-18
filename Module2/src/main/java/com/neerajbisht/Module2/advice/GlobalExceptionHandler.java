package com.neerajbisht.Module2.advice;

import com.neerajbisht.Module2.exception.ResourceAlreadyExist;
import com.neerajbisht.Module2.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<?>> ResourceNotFoundException(ResourceNotFoundException exception){
        ApiError apiError = ApiError.builder()
                        .message(exception.getMessage())
                        .status(HttpStatus.NOT_FOUND)
                        .build();
        return buildExceptionHandler(apiError);
    }

    @ExceptionHandler(ResourceAlreadyExist.class)
    public ResponseEntity<ApiResponse<?>> ResourceIsAlreadyExistException(ResourceAlreadyExist exception){
        ApiError apiError = ApiError.builder()
                .message(exception.getMessage())
                .status(HttpStatus.CONFLICT)
                .build();
        return buildExceptionHandler(apiError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<?>> MethodArgumentNotValidException(MethodArgumentNotValidException exception){
        List<String> subError = exception.getBindingResult()
                .getAllErrors()
                .stream()
                .map(error -> error.getDefaultMessage())
                .toList();
        ApiError apiError = ApiError.builder()
                .message("Input Validation Failed!")
                .status(HttpStatus.BAD_REQUEST)
                .subErrors(subError)
                .build();
        return buildExceptionHandler(apiError);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<?>> ServerNotFoundException(Exception exception){
        ApiError apiError = ApiError.builder()
                .message(exception.getMessage())
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .build();
        return buildExceptionHandler(apiError);
    }

    private ResponseEntity<ApiResponse<?>> buildExceptionHandler(ApiError apiError) {
        return new ResponseEntity<>(
                new ApiResponse<>(apiError),
                apiError.getStatus());
    }
}
