package com.example.tweetingsystem.Services;

import com.example.tweetingsystem.Models.User;
import com.example.tweetingsystem.DTOs.CreateUserRequest;
import com.example.tweetingsystem.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

public User createUser(CreateUserRequest createUserRequest){
    User user = new User();
    user.setName(createUserRequest.getUserName());
    user.setEmail(createUserRequest.getEmail());

    return userRepository.save(user);
}

}
