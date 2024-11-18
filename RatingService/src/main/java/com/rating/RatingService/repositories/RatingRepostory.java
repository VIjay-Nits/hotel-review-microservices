package com.rating.RatingService.repositories;

import com.rating.RatingService.entities.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RatingRepostory extends MongoRepository<Rating,String> {

    //custom finder methods
    // 1st write return type
    // 2nd write findBy
    // concat column name in camel case

    List<Rating> findByUserId(String userId);
    List<Rating> findByHotelId(String hotelId);


}
