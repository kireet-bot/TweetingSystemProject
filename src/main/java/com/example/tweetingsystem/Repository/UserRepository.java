package com.example.tweetingsystem.Repository;

import com.example.tweetingsystem.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
