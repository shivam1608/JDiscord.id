package me.shivzee.utils;

import java.util.Date;

public class User {

    private String userID;
    private String avatarUrl;
    private int discriminator;
    private String name;
    private Date timeCreated;
    private String publicFlags;
    private String jsonRaw;
    private boolean isBot;



    public User(String userID, String avatarUrl, int discriminator, String name, Date timeCreated , String publicFlags , String jsonRaw , boolean isBot) {
        this.userID = userID;
        this.avatarUrl = avatarUrl;
        this.discriminator = discriminator;
        this.name = name;
        this.timeCreated = timeCreated;
        this.publicFlags = publicFlags;
        this.jsonRaw = jsonRaw;
        this.isBot = isBot;
    }

    /**
     * Get the UserID of User
     * @return userID of the user
     * */
    public String getUserID() {
        return userID;
    }

    /**
     * Get the AvatarUrl of User
     * @return AvatarUrl of the user
     * */
    public String getAvatarUrl() {
        return avatarUrl;
    }

    /**
     * Get the Discriminator of User
     * @return Discriminator of the user
     * */
    public int getDiscriminator() {
        return discriminator;
    }
    /**
     * Get the Username of User
     * @return Username of the user
     * */
    public String getName() {
        return name;
    }

    /**
     * Get the PublicFlags of User
     * @return PublicFlags of the user
     * */
    public String getPublicFlags(){
        return publicFlags;
    }

    /**
     * Get the Time of ID Creation of User
     * @return Time of ID Creation of the user
     * */
    public Date getTimeCreated() {
        return timeCreated;
    }

    /**
     * Get the Raw JSON Response of User Form Discord
     * @return Raw JSON Response of User Form Discord
     * */
    public String getJsonRaw(){
        return jsonRaw;
    }

    /**
     * Gets a boolean weather user is a bot or not
     * @return a boolean weather user is a bot or not
     * */
    public boolean isBot(){
        return this.isBot;
    }
}
