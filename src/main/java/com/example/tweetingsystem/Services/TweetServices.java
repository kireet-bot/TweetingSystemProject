package com.example.tweetingsystem.Services;

import com.example.tweetingsystem.DTOs.CreateTweetRequest;
import com.example.tweetingsystem.Models.Tweet;
import com.example.tweetingsystem.Models.User;
import com.example.tweetingsystem.Repository.TweetRepository;
import com.example.tweetingsystem.Repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TweetServices {

    @Autowired
    TweetRepository tweetRepository;
    @Autowired
    UserRepository userRepository;

    public Tweet writeTweet(CreateTweetRequest createTweetRequest){
        User user = userRepository.findById(createTweetRequest.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Tweet tweet = new Tweet();
        tweet.setContent(createTweetRequest.getContent());
        tweet.setUser(user);
        tweet.setTimeStamp(new Date());

        return tweetRepository.save(tweet);
    }

    public List<Tweet> getTweetsByUserId(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return user.getTweets();
    }

    public Tweet getTweetById(Long tweetId) {
        return tweetRepository.findById(tweetId)
                .orElseThrow(() -> new RuntimeException("Tweet not found"));
    }

    public Tweet updateTweetContent(Long tweetId, String newContent) {
        Tweet tweet = tweetRepository.findById(tweetId)
                .orElseThrow(() -> new EntityNotFoundException("Tweet not found"));
        tweet.setContent(newContent);
        return tweetRepository.save(tweet);
    }

    public void deleteTweetById(Long tweetId) {
        Tweet tweet = tweetRepository.findById(tweetId)
                .orElseThrow(() -> new EntityNotFoundException("Tweet not found"));

        tweetRepository.delete(tweet);
    }

}
