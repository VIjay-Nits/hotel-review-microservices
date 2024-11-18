package com.rating.userservice.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import com.rating.userservice.entities.User;

public interface UserRepository  extends JpaRepository<User,String> {

}
