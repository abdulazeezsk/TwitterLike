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
			LinkedList<Tweet> tweets1 = new LinkedList<Tweet>();
			LinkedList<Tweet> tweets2 = new LinkedList<Tweet>();
			LinkedList<Tweet> tweets3 = new LinkedList<Tweet>();
			LinkedList<Tweet> tweets4 = new LinkedList<Tweet>();
			
			persistentData.allTweets.put("user1", tweets1);
			persistentData.allTweets.put("user2", tweets2);
			persistentData.allTweets.put("user3", tweets3);
			persistentData.allTweets.put("user4", tweets4);
			
			Set<String> aFollows = new HashSet<String>();
			aFollows.add("user4");
			aFollows.add("user2");
			persistentData.relationships.put("user1", aFollows);
			
			Set<String> bFollows = new HashSet<String>();
			bFollows.add("user1");
			bFollows.add("user3");
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
		if(null == usernames) {
			System.out.println("No Relationships for this user\n");
			return resultTweets;
		}
		
		System.out.println("User follows " + usernames.size() + " other users\n");
		for(String username: usernames) {
			List<Tweet> userTweets = allTweets.get(username);
			int tweetsLength = userTweets.size();
			System.out.println("Length of " + username + " Tweets:" + tweetsLength);
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
		LinkedList<Tweet> tweets = allTweets.get(username);
		if(null != tweets) {
			tweets.addFirst(newTweet);
			System.out.println(username + ":" + newTweetMsg);
		} else {
			System.out.println("Error in reading tweets of user " + username);
		}
		
		//LinkedList<Tweet> alltweets = allTweets.
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
