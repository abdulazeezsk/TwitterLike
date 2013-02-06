package com.twitterlike.server.persistence.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.twitterlike.server.domain.Tweet;
import com.twitterlike.server.persistence.TweetsData;

public class TweetsDAOImpl implements TweetsDAO {

	@Autowired TweetsData tweetsDB;
	
	@Override
	public boolean addTweet(String username, String newTweet, StringBuffer error) {
		tweetsDB.addNewTweet(username, newTweet);
		return false;
	}

	@Override
	public List<Tweet> getAllTweets(String username, StringBuffer error) {
		
		return null;
	}

	@Override
	public List<Tweet> getUnreadTweets(String username, StringBuffer error) {
		// TODO Auto-generated method stub
		return null;
	}

}
