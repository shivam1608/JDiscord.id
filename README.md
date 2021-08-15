# JDiscord.id
JDiscordID is the User Information Grabber Asynchronous Libarary for Discord Only by Using UserID. Easy To Use also can get Public Data of Any Discord User by its UserID.

# Why?
I got some free time so i made this and maybe i use this in future because most of the Discord API Wrappers don't provide global user data and only shows details about user in a Guild. (if they do so idk i just made this)

### Version : 0.1

## Add to your projects
Easy to add in your projects using gradle, maven or jar

### Gradle
- Add it in your root build.gradle at the end of repositories:
```gradle
allprojects {
		repositories {
			maven { url 'https://jitpack.io' }
		}
	}
```
- Add the dependency (replace version with the version on top)
```gradle
dependencies {
	        implementation 'com.github.shivam1608:JDiscord.id:0.1'
	}
```

### Maven
- Add the repository in pom.xml file
```maven
	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>

```
- Add the dependency (replace version with the version on top)
```maven 
<dependency>
	    <groupId>com.github.shivam1608</groupId>
	    <artifactId>JDiscord.id</artifactId>
	    <version>0.1</version>
	</dependency>

```

### Jar 
Download the jar from this repo or release page
```
out/artifact/JReplDB_Jar
```

### How to Get Token
- Go to https://discord.com/developers
- Create a Application
- Click on New Bot
- There you can find Bot Token

## DOCS
Here's the Docs to Use Lib
### First Create an Instance 
```java
JDiscordID id = new JDiscordID("TOKEN_HERE");
```
- Then Implement the EventAdapter
```java
public class xyz implements EventAdapter{}
```
- The Register the Implemented Class
```java
id.registerEventAdapter(new xyz());
```
And Now Its all setup and ready to go

### Search() Method
It is the only method to search for user by their IDs
```java
id.search("USER_ID_HERE");
```

### How to read the response?
It is very easy to read response as we have already implemented the EventAdapter
```java
@Override
    public void onUserFound(User user) {
        //....
    }

    @Override
    public void onUserNotFound(Response response) {
       //......
    }

    @Override
    public void onError(Response response) {
    //....
    }
```
Different Methods are called according to sitution

### Quick Start
```java
import me.shivzee.JDiscordID;
import me.shivzee.io.EventAdapter;
import me.shivzee.utils.Response;
import me.shivzee.utils.User;

public class Main implements EventAdapter {

    public static void main(String[] args) {
        JDiscordID id = new JDiscordID("TOKEN_HERE");
        id.registerEventAdapter(new Main());
        id.search("USERID_HERE");
    }

    @Override
    public void onUserFound(User user) {
       //.....
    }

    @Override
    public void onUserNotFound(Response response) {
        //.....
    }

    @Override
    public void onError(Response response) {
        //.......
    }
}

```

## The User.class
### Methods
```java
        System.out.println("UserID : "+user.getUserID());
        System.out.println("Username : "+user.getName());
        System.out.println("Discriminator : "+user.getDiscriminator());
        System.out.println("AvatarUrl : "+user.getAvatarUrl());
        System.out.println("Time Created : "+user.getTimeCreated());
        System.out.println("Flags : "+user.getPublicFlags());
        System.out.println("isBot? : "+user.isBot());
        System.out.println("Raw JSON Response : "+user.getJsonRaw());
```

## The Response.class
### Methods
```java
        System.out.println("Status : "+response.getStatus());
        System.out.println("Error/Response : "+response.getResponse());
        System.out.println("ResponseCode : "+ response.getResponseCode());
```

## Credits
- shivzee/shivam1608 made the whole lib alone
- IDE used [IntelliJ](https://www.jetbrains.com/idea/)
- Used [JSON Simple](https://github.com/fangyidong/json-simple)
