Please run following commands to run this server,

mvn clean install
java -jar target/dependency/webapp-runner.jar target/server-1.0.0-BUILD-SNAPSHOT.war

Currently, we support four usernames
user1
user2
user3
user4

Send following GET request to read all tweets

http://localhost:8000/gettweets/{username}?unread=false

Send following GET request to read only new tweets

http://localhost:8000/gettweets/{username}?unread=true

Send following POST request to add new tweet,


http://localhost:8000/newtweet

Send Request Params in the following format,

{
"username" : "user1",
"tweet"	   : "This is my first tweet"
}


