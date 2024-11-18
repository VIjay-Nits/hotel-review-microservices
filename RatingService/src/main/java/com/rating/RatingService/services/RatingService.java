package com.rating.RatingService.services;

import com.rating.RatingService.entities.Rating;

import java.util.List;

public interface RatingService {

    //create

    Rating addRating(Rating rating);

    //get all rating
    List<Rating> getAllRating();
    //get rating by user
    List<Rating> getRatingListByUser(String userId);

    //get rating by hotel
    List<Rating> getRatingListByHotel(String hotelId);
}
