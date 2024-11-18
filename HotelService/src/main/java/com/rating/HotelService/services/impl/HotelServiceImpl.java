package com.rating.HotelService.services.impl;

import com.rating.HotelService.entities.Hotel;
import com.rating.HotelService.exception.ResourceNotFoundException;
import com.rating.HotelService.repositories.HotelRepository;
import com.rating.HotelService.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    HotelRepository hotelRepository;

    @Override
    public Hotel addHotel(Hotel hotel) {
        String random = UUID.randomUUID().toString();
        hotel.setId(random);
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getHotelList() {

        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotelById(String id) {
        return hotelRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Hotel is not present with given id"+ id));
    }
}
