package com.rating.HotelService.controllers;

import com.rating.HotelService.entities.Hotel;
import com.rating.HotelService.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    HotelService hotelService;


    //create
    @PostMapping
    public ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel){
        Hotel hotel1 = hotelService.addHotel(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(hotel1);
    }
    //get all
    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels(){
        List<Hotel> hotelList = hotelService.getHotelList();
        return  ResponseEntity.status(HttpStatus.OK).body(hotelList);
    }
    //get by ID

    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable("hotelId") String id){
        Hotel hotel = hotelService.getHotelById(id);
        return ResponseEntity.status(HttpStatus.OK).body(hotel);
    }


}
