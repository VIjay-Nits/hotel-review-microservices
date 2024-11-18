package com.rating.userservice.controllers;

import com.rating.userservice.entities.Hotel;
import com.rating.userservice.entities.Rating;
import com.rating.userservice.entities.User;
import com.rating.userservice.external.HotelService;
import com.rating.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    //create user
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User user1 = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }


    //get all user
    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        List<User> userList = userService.getAllUser();
        // ratings implement krni h

        return  ResponseEntity.status(HttpStatus.OK).body(userList);
    }

    // get user by id
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable("userId") String id) {
        User user = userService.getUserById(id);

        //extracting rating list for this user id
        //http://localhost:8083/ratings/users/f3f7f340-f18a-43f5-bb30-1b58627fb169
        //Using Rest Template
//        Rating[] ratings = restTemplate.getForObject("http://RATINGSERVICE/ratings/users/"+user.getUserId(), Rating[].class);
//        List<Rating> ratingList = Arrays.stream(ratings).toList();
//        user.setRatingList(ratingList);
//
//        ratingList.stream().map(
//                rating -> {
//                   ResponseEntity<Hotel> hotel = restTemplate.getForEntity("http://HOTELSERVICE/hotels/"+rating.getHotelId(), Hotel.class);
//                   rating.setHotel(hotel.getBody());
//                return rating;
//                }
//        ).collect(Collectors.toList());
//
        // Using Feign Client

        Rating[] ratings = restTemplate.getForObject("http://RATINGSERVICE/ratings/users/"+user.getUserId(), Rating[].class);
        List<Rating> ratingList = Arrays.stream(ratings).toList();
        user.setRatingList(ratingList);

        ratingList.stream().map(
                rating -> {
                    Hotel hotel = hotelService.getHotel(rating.getHotelId());
                    rating.setHotel(hotel);
                    return rating;
                }
        ).collect(Collectors.toList());




        return ResponseEntity.status(HttpStatus.OK).body(user);
    }




}
