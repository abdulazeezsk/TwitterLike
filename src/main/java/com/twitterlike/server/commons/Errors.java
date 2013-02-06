package com.twitterlike.server.commons;

public enum Errors {

	NEW_TWEET_ERROR("There is an error while adding new tweet"),
	GET_TWEETS_ERROR("There is an error while reading tweets");
	
	private String errorDesc;
	
	Errors(String tempErrorDesc) {
		errorDesc = tempErrorDesc;
	}
	
	public String getErrorDesc() {
		return errorDesc;
	}
}
