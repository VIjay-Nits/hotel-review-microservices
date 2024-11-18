package com.rating.HotelService.repositories;

import com.rating.HotelService.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel,String> {

}
