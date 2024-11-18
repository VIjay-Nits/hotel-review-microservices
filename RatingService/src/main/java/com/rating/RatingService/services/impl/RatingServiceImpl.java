package com.rating.RatingService.services.impl;

import com.rating.RatingService.entities.Rating;
import com.rating.RatingService.repositories.RatingRepostory;
import com.rating.RatingService.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepostory ratingRepostory;


    @Override
    public Rating addRating(Rating rating) {
        return ratingRepostory.save(rating);
    }

    @Override
    public List<Rating> getAllRating() {
        return ratingRepostory.findAll();
    }

    @Override
    public List<Rating> getRatingListByUser(String userId) {
        return ratingRepostory.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingListByHotel(String hotelId) {
        return ratingRepostory.findByHotelId(hotelId);
    }
}
