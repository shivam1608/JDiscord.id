package me.shivzee;

import me.shivzee.io.EventAdapter;
import me.shivzee.io.Request;
import me.shivzee.utils.Utils;

import java.net.MalformedURLException;
import java.net.URL;

public class JDiscordID {
    private String token;
    private EventAdapter eventAdapter;
    private static final String baseUrl = "https://discord.com/api/v8/users/";

    /**
     * Initialization
     * @param token The Discord Bot Token (Grab it from https://discord.com/developers)
     * */

    public JDiscordID(String token){
        this.token = token;
    }

    /**
     * Changes the Value of token to the specified value
     * @param token The Discord Bot Token (Grab it from https://discord.com/developers)
     * */

    public void changeToken(String token){
        this.token = token;
    }

    /**
     * Register the Event Adapter the Implementation
     * @param eventAdapter The EventAdapter Implemented Class
     * */

    public void registerEventAdapter(EventAdapter eventAdapter){
        this.eventAdapter = eventAdapter;
    }

    /**
     * Start the Search in Async Process. Results by Implementing EventAdapter.class
     * @see me.shivzee.io.EventAdapter
      @param userId The ID of the user to Search For
     * */

    public void search(String userId){
        String urlString = baseUrl+userId;
        
        if(eventAdapter==null){
            System.out.println("|NO_LOGGER| |WARNING| EventAdapter Not Registred");
        }
        
        if(Utils.isValidUrl(urlString)){
           try{
               URL url = new URL(urlString);
               Request.getResponse(eventAdapter , url , "Bot "+token);

           }catch (MalformedURLException e){
               System.out.println("|NO_LOGGER| Something Went Wrong. Contact Developer");
           }

        }else{
            System.out.println("|NO_LOGGER| Something Went Wrong. Contact Developer");
        }
    }
}
