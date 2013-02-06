package com.twitterlike.server.service;

import java.util.List;

import com.twitterlike.server.domain.Tweet;
import com.twitterlike.server.persistence.TweetsData;

public class TweetServiceImpl implements TweetService {

	//@Autowired TweetsData tweetDB;
	
	@Override
	public boolean addTweet(String username, String tweet, StringBuffer error) {
		TweetsData.getInstance().addNewTweet(username, tweet);
		return true;
	}

	@Override
	public List<Tweet> getTweets(String username, boolean unread,
			StringBuffer error) {
		TweetsData tweetsDB = TweetsData.getInstance();
		
		if(unread) {
			return tweetsDB.getUnreadTweets(username); 
		} else {
			return tweetsDB.getAllTweets(username);
		}
	}
}

