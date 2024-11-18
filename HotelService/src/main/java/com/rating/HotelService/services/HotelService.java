package com.rating.HotelService.services;

import com.rating.HotelService.entities.Hotel;

import java.util.List;

public interface HotelService {
    //add new Hotel
    public Hotel addHotel(Hotel hotel);

    //get list of all hotels
    public List<Hotel> getHotelList();

    //get hotel by Id
    public  Hotel getHotelById(String id);

}
