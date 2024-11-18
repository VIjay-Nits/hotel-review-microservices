package com.rating.userservice.exceptions;


import com.rating.userservice.payload.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handlerResourceNotFoundException(ResourceNotFoundException resourceNotFoundException){

        String message= resourceNotFoundException.getMessage();

        ExceptionResponse exceptionResponse = ExceptionResponse.builder()
                .message(message)
                .mydef("handling global custom exception")
                .status(HttpStatus.NOT_FOUND)
                .success(false)
                .build();

        return new ResponseEntity<>(exceptionResponse,HttpStatus.NOT_FOUND);

    }
}
