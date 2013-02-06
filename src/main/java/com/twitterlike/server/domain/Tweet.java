package com.twitterlike.server.domain;

import java.util.HashMap;
import java.util.Map;

public class Tweet {

	String tweet;
	
	String username;
	
	Map<String, Boolean> unreadStatus = new HashMap<String, Boolean>();
	
	public Tweet(String tweet) {
		this.tweet = tweet;
		unreadStatus.put("user1", new Boolean(true));
		unreadStatus.put("user2", new Boolean(true));
		unreadStatus.put("user3", new Boolean(true));
		unreadStatus.put("user4", new Boolean(true));
	}

	public String getTweet() {
		return tweet;
	}

	public void setTweet(String tweet) {
		this.tweet = tweet;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Map<String, Boolean> getUnreadStatus() {
		return unreadStatus;
	}

	public void setUnreadStatus(Map<String, Boolean> unreadStatus) {
		this.unreadStatus = unreadStatus;
	}

}
