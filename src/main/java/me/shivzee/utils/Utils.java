package me.shivzee.utils;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Utils {

    public static boolean isValidUrl(String urlString){
        try{
            URL url = new URL(urlString);
        } catch (MalformedURLException e) {
            return false;
        }
        return true;
    }

    public static boolean isValidToken(String token){
        try{
            URL url = new URL("https://discord.com/api/v8/users/000000000000000");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("user-agent" , "i-am-a-robot");
            connection.setRequestProperty("Authorization" , "Bot "+token);
            connection.connect();
            return connection.getResponseCode() != 401;
        }catch (Exception e){

        }
        return false;
    }
}
