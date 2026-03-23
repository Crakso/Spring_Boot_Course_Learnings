package com.neerajbisht.Module3.advice;

import com.neerajbisht.Module3.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<?>> resourceNotFoundExceptionHandling(ResourceNotFoundException exception){
        ApiError apiError = ApiError.builder()
                .message(exception.getMessage())
                .status(HttpStatus.NOT_FOUND)
                .build();
        return buildingApiResponseForException(apiError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<?>> handleValidationException(MethodArgumentNotValidException exception){
        List<String> errors = exception
                .getBindingResult()
                .getAllErrors()
                .stream()
                .map(error-> error.getDefaultMessage())
                .collect(Collectors.toList());
                        ApiError apiError = ApiError
                                .builder()
                                .message("Input Validation Failed!")
                                .status(HttpStatus.BAD_REQUEST)
                                .subErrors(errors)
                                .build();
                        return buildingApiResponseForException(apiError);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<?>> handleInternalServerException(Exception exception) {
        ApiError apiError = ApiError
                .builder()
                .message(exception.getMessage())
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .build();
        return buildingApiResponseForException(apiError);
    }

    private ResponseEntity<ApiResponse<?>> buildingApiResponseForException(ApiError apiError) {
    return new ResponseEntity<>(
            new ApiResponse<>(apiError),
            apiError.getStatus()
    );
    }
}
