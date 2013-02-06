package com.twitterlike.server.requestresponse;

import java.util.List;

import com.twitterlike.server.domain.Tweet;

public class TweetsResponse extends JsonResponse{
	List<Tweet> tweets;

	public List<Tweet> getTweets() {
		return tweets;
	}

	public void setTweets(List<Tweet> tweets) {
		this.tweets = tweets;
	}

}
