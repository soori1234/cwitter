package com.cwitter.service;

import java.util.List;

import com.cwitter.dto.Tweet;
import com.cwitter.dto.User;

public interface TweetLocalService {
	public Tweet saveTweet(Tweet tweet);
	public Tweet getTweet(Tweet tweet);
	public Tweet updateTweet(Tweet tweet);
	public Boolean deleteTweet(Tweet tweet);
	public List<Tweet> getAllTweets();

	public List<Tweet> getAllTweetsByUserID(Long userId);

}
