package com.example.tweetingsystem.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@Entity
public class Tweet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column(nullable = false)
    private String content;

    private Date timeStamp;

    @ManyToOne
    @JoinColumn(name = "userID" ,nullable = false)
    @JsonIgnore
    private User user;
}
