package com.example.tweetingsystem.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CreateTweetRequest {
    private String content;
    private long userId;
}
