
## Twitter like application

This document has all the information to run the server and also info on GET and POST calls to server to add/get tweets

### Server configuration

Server has been configured with four users with following usernames,

* user1 (user1 follows user2 and user4)
* user2 (user2 follows user1 and user3)
* user3 ()
* user4 ()


### Steps to run the application

1. Download the code from github from the following link <https://github.com/abdulazeezsk/TwitterLike>
2. Make sure you have maven and java installed on your pc and run following commands

    ```
    mvn clean install
    java -jar target/dependency/webapp-runner.jar target/server-1.0.0-BUILD-SNAPSHOT.war
    ```
3. Run <http://localhost:8080/> in your browser. It should display current time if server is started successfully

### Twitter APIs to get/add tweets


#### POST call to add new tweet

Following POST call adds new tweet of the user (username and tweet should be passed as query parameters)

```
POST http://localhost:8080/newtweet

{
	"tweet": "example tweet",
	"username" : "example username"
}

```

#### GET call to read unread tweets

Following GET call returns unread tweets of the user(It returns tweets of this particular user is following on this application ),

```
GET http://locahost:8080/gettweets?unread=true
```


#### GET call to read all tweets

Following GET call returns all tweets of the user(It returns tweets of this particular user is following on this application ),

```
GET http://locahost:8080/gettweets?unread=false
```