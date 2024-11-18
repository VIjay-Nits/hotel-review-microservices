package com.rating.HotelService.payload;


import jakarta.websocket.server.ServerEndpoint;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExceptionResponse {
    private String message;
    private boolean success;
    private HttpStatus status;
    private  String mydef;
}
