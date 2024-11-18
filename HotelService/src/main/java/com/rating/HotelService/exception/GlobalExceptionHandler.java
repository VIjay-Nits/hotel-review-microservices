package com.rating.HotelService.exception;

import com.rating.HotelService.payload.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponse> resourceNotFoundHandler(ResourceNotFoundException message){
        ExceptionResponse response = ExceptionResponse.builder()
                .message(message.getMessage())
                .status(HttpStatus.NOT_FOUND)
                .mydef("custom exception caught")
                .success(false).build();
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }
}
