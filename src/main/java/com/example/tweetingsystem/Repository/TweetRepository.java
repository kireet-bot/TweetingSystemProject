package com.example.tweetingsystem.Repository;

import com.example.tweetingsystem.Models.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TweetRepository extends JpaRepository<Tweet, Long> {
}
