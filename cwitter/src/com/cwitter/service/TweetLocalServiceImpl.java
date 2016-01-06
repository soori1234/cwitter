package com.cwitter.service;

import java.util.List;

import com.cwitter.dao.TweetDao;
import com.cwitter.dao.TweetDaoImpl;
import com.cwitter.dto.Tweet;
import com.cwitter.dto.User;

public class TweetLocalServiceImpl implements TweetLocalService {

	@Override
	public Tweet saveTweet(Tweet tweet) {
		TweetDao tweetDao = new TweetDaoImpl();

		return tweetDao.saveTweet(tweet);

	}

	@Override
	public Tweet getTweet(Tweet tweet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tweet updateTweet(Tweet tweet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteTweet(Tweet tweet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tweet> getAllTweets() {
		TweetDao tweetDao = new TweetDaoImpl();

		return tweetDao.getAllTweets();
	}

	@Override
	public List<Tweet> getAllTweetsByUserID(Long userId) {
		TweetDao tweetDao = new TweetDaoImpl();

		return tweetDao.getAllTweetsByUserId(userId);

	}

}
