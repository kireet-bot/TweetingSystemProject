package com.example.tweetingsystem.Controllers;

import com.example.tweetingsystem.DTOs.CreateTweetRequest;
import com.example.tweetingsystem.DTOs.UpdateTweetRequest;
import com.example.tweetingsystem.Models.Tweet;
import com.example.tweetingsystem.Services.TweetServices;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TweetController {

    @Autowired
    TweetServices tweetServices;

    @PostMapping("/writeTweet")
    public ResponseEntity<String> createTweet(@RequestBody CreateTweetRequest createTweetRequest) {
        Tweet createdTweet = tweetServices.writeTweet(createTweetRequest);

        return ResponseEntity.ok("Your Tweet was created successfully.");
    }

    @GetMapping("/users/{userId}/tweets")
    public ResponseEntity<List<Tweet>> getTweetsByUserId(@PathVariable("userId") Long userId) {
        List<Tweet> tweets = tweetServices.getTweetsByUserId(userId);
        return ResponseEntity.ok(tweets);
    }

    @GetMapping("/tweets/{tweetId}")
    public ResponseEntity<Tweet> getTweetById(@PathVariable Long tweetId) {
        try {
            Tweet tweet = tweetServices.getTweetById(tweetId);
            return ResponseEntity.ok(tweet);
        } catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/tweets/{tweetId}")
    public ResponseEntity<Tweet> updateTweetContent(@PathVariable Long tweetId, @RequestBody UpdateTweetRequest updateTweetRequest) {
        Tweet updatedTweet = tweetServices.updateTweetContent(tweetId, updateTweetRequest.getNewContent());
        return ResponseEntity.ok(updatedTweet);
    }

    @DeleteMapping("/tweets/{tweetId}")
    public ResponseEntity<Void> deleteTweetById(@PathVariable Long tweetId) {
        tweetServices.deleteTweetById(tweetId);
        return ResponseEntity.noContent().build();
    }
}