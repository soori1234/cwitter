package com.cwitter.dao;

import java.util.List;

import com.cwitter.dto.Tweet;
import com.cwitter.dto.User;

public interface TweetDao {
	public Tweet saveTweet(Tweet tweet);
	public Tweet getTweet(Tweet tweet);
	public Tweet updateTweet(Tweet tweet);
	public Boolean deleteTweet(Tweet tweet);
	public List<Tweet> getAllTweets();
	
	public List<Tweet> getAllTweetsByUserId(Long userId);
}
