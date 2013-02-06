package com.twitterlike.server.persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.twitterlike.server.domain.Tweet;

public class TweetsData {

	private static TweetsData persistentData = null;
	private Map<String, LinkedList<Tweet>> allTweets = new LinkedHashMap<String, LinkedList<Tweet>>();
	private Map<String, Set<String>> relationships = new HashMap<String, Set<String>>();
	
	protected TweetsData() {
		
	}
	
	public static TweetsData getInstance() {
		if(null ==  persistentData) {
			persistentData = new TweetsData();
			LinkedList<Tweet> tweets = new LinkedList<Tweet>();
			persistentData.allTweets.put("user1", tweets);
			persistentData.allTweets.put("user2", tweets);
			persistentData.allTweets.put("user3", tweets);
			persistentData.allTweets.put("user4", tweets);
			
			Set<String> aFollows = new HashSet<String>();
			aFollows.add("user4");
			aFollows.add("user2");
			persistentData.relationships.put("user1", aFollows);
			
			Set<String> bFollows = new HashSet<String>();
			aFollows.add("user1");
			aFollows.add("user3");
			persistentData.relationships.put("user2", bFollows);
			
		}
		return persistentData;
	}

	public Map<String, LinkedList<Tweet>> getAllTweets() {
		return allTweets;
	}
	
	public List<Tweet> getAllTweets(String myUsername) {
		
		Set<String> usernames = getRelationships(myUsername);
		List<Tweet> resultTweets = new ArrayList<Tweet>();
		for(String username: usernames) {
			resultTweets.addAll(allTweets.get(username));
		}
		return resultTweets;
	}
	
	public List<Tweet> getUnreadTweets(String myUsername) {
		
		Set<String> usernames = getRelationships(myUsername);
		List<Tweet> resultTweets = new ArrayList<Tweet>();
		for(String username: usernames) {
			List<Tweet> userTweets = allTweets.get(username);
			int tweetsLength = userTweets.size();
			for(int index =0; index < tweetsLength; index++) {
				Tweet tweet = userTweets.get(index);
				Boolean unreadStatus = tweet.getUnreadStatus().get(myUsername); 
				if(false == unreadStatus.booleanValue()) {
					break;
				}
				unreadStatus = false;
				resultTweets.add(tweet);
			}
		}
		return resultTweets;
	}

	public void setAllTweets(Map<String, LinkedList<Tweet>> allTweets) {
		this.allTweets = allTweets;
	}
	
	public void addNewTweet(String username, String newTweetMsg) {
		
		Tweet newTweet = new Tweet(newTweetMsg);
		LinkedList<Tweet> tweets = allTweets.get(newTweet);
		if(null != tweets)
			tweets.addFirst(newTweet);
	}

	public Map<String, Set<String>> getRelationships() {
		return relationships;
	}
	
	public Set<String> getRelationships(String username) {
		return relationships.get(username);
	}

	public void setRelationships(Map<String, Set<String>> relationships) {
		this.relationships = relationships;
	}
}
