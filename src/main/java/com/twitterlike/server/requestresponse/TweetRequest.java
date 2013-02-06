package com.twitterlike.server.requestresponse;

public class TweetRequest {
	String username;
	String tweet;
	
	public TweetRequest() {
	}
	public TweetRequest(String username, String tweet) {
		this.username = username;
		this.tweet = tweet;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTweet() {
		return tweet;
	}
	public void setTweet(String tweet) {
		this.tweet = tweet;
	}
	
}
