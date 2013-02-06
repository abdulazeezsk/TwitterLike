package com.twitterlike.server.persistence.dao;

import java.util.List;

import com.twitterlike.server.domain.Tweet;

public interface TweetsDAO {

	public boolean addTweet(String username, String newTweet, StringBuffer error);
	public List<Tweet> getAllTweets(String username,StringBuffer error);
	public List<Tweet> getUnreadTweets(String username,StringBuffer error);

}
