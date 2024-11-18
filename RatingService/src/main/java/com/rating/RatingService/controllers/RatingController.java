package com.rating.RatingService.controllers;

import com.rating.RatingService.entities.Rating;
import com.rating.RatingService.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    RatingService ratingService;

    @PostMapping
    public ResponseEntity<Rating> addRating(@RequestBody Rating rating){
        Rating rating1 = ratingService.addRating(rating);
        return ResponseEntity.status(HttpStatus.CREATED).body(rating1);
    }

    @GetMapping
    public ResponseEntity<List<Rating>> getAllRating(){
        return  ResponseEntity.status(HttpStatus.OK)
                .body(ratingService.getAllRating());
    }

    @GetMapping("/users/{userId}")
    public  ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId){
        return  ResponseEntity.status(HttpStatus.OK)
                .body(ratingService.getRatingListByUser(userId));
    }

    @GetMapping("/hotels/{hotelId}")
    public  ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId){
        return  ResponseEntity.status(HttpStatus.OK)
                .body(ratingService.getRatingListByHotel(hotelId));
    }

}
