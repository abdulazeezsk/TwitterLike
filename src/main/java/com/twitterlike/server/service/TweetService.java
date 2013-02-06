package com.twitterlike.server.service;

import java.util.List;

import com.twitterlike.server.domain.Tweet;

public interface TweetService {

	public boolean addTweet(String username, String tweet, StringBuffer error);
	public List<Tweet> getTweets(String username, boolean unread, StringBuffer error);
	
}
