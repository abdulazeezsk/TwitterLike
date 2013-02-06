package com.twitterlike.server.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.twitterlike.server.commons.Errors;
import com.twitterlike.server.domain.Tweet;
import com.twitterlike.server.requestresponse.JsonResponse;
import com.twitterlike.server.requestresponse.TweetRequest;
import com.twitterlike.server.requestresponse.TweetsResponse;
import com.twitterlike.server.service.TweetService;

@Controller
public class TweetsController {

	@Autowired TweetService tweetService;
	
	@RequestMapping(value={"/gettweets/{username}"}, method=RequestMethod.GET)
	public @ResponseBody TweetsResponse getTweets( @ModelAttribute("username") String username,
												@RequestParam("unread") boolean isUnread) {
												
		TweetsResponse responseTweets = new TweetsResponse();
		
		StringBuffer error = new StringBuffer();
		List<Tweet> allTweets = tweetService.getTweets(username, isUnread, error);
		
		
		if(null != allTweets) {
			responseTweets.setStatus(true);
			responseTweets.setTweets(allTweets);
		} else {
			responseTweets.setError(Errors.GET_TWEETS_ERROR.getErrorDesc());
		}
		
		responseTweets.setTweets(allTweets);
		return responseTweets;
		
	}
	
	@RequestMapping(value={"/newtweet"}, method=RequestMethod.POST)
	public @ResponseBody JsonResponse newTweet(@RequestBody TweetRequest newTweet) {
		
		JsonResponse simpleResponse =  new JsonResponse();
		
		StringBuffer error = new StringBuffer();
		if(tweetService.addTweet(newTweet.getUsername(), newTweet.getTweet(), error)) {
			simpleResponse.setStatus(true);
		} else {
			simpleResponse.setError(Errors.NEW_TWEET_ERROR.getErrorDesc());
		}
		
		return simpleResponse;
		
	}
}
