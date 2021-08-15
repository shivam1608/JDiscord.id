package me.shivzee.io;



import me.shivzee.utils.Response;
import me.shivzee.utils.User;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

public class Request {

    private static final String avatarBaseUrl = "https://cdn.discordapp.com/avatars";

    public static void getResponse(EventAdapter eventAdapter , URL url , String authHead){
        new Thread(){
            @Override
            public void run() {
                try{

                    JSONParser parser = new JSONParser();

                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setRequestProperty("user-agent" , "Probably-not-a-human-lmao");
                    connection.setRequestProperty("Authorization" , authHead);
                    connection.setDoInput(true);
                    connection.setDoOutput(true);

                    int responseCode = connection.getResponseCode();

                    if(responseCode == 200){
                        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                        StringBuilder builder = new StringBuilder();
                        String line;

                        while((line=reader.readLine()) != null){
                            builder.append(line).append("\n");
                        }

                        JSONObject data = (JSONObject) parser.parse(builder.toString());
                        String userId = data.get("id").toString();
                        String avatarHash = data.get("avatar").toString();
                        String avatarUrl;
                        if(avatarHash.startsWith("a_")){
                            avatarUrl = avatarBaseUrl+"/"+userId+"/"+avatarHash+".gif";
                        }else{
                            avatarUrl = avatarBaseUrl+"/"+userId+"/"+avatarHash+".png";
                        }
                        int discriminator = Integer.parseInt(data.get("discriminator").toString());
                        String name = data.get("username").toString();
                        String binary = Long.toBinaryString(Long.parseLong(userId));
                        binary = binary.substring(0,binary.length()-22);
                        Date timeCreated  = new Date((Long.parseLong(binary , 2)+1420070400000L));

                        String publicFlags = data.get("public_flags").toString();
                        boolean isBot = data.get("bot") != null;


                        eventAdapter.onUserFound(new User(userId , avatarUrl , discriminator , name , timeCreated , publicFlags ,builder.toString() , isBot));


                    }else if(responseCode == 403){
                        eventAdapter.onError(new Response("Failure" , "Error 403 Bad Auth" , responseCode));
                    }else if(responseCode == 400){
                        eventAdapter.onError(new Response("Failure" , "Error 400 Bad Request" , responseCode));
                    }else if(responseCode == 404){
                        eventAdapter.onUserNotFound(new Response("Failure" , "Error 404 Not Found" , responseCode));
                    }else if(responseCode == 401){
                        eventAdapter.onError(new Response("Failure" , "Error 401 Bad Auth Token" , responseCode));
                    }
                    else{
                        eventAdapter.onError(new Response("Failure" , "Unknown Error Occurred" , responseCode));
                    }

                } catch (IOException ioException) {

                    eventAdapter.onError(new Response("Failure" , "IOException Error in Network" , 1));
                } catch (ParseException parseException){
                    eventAdapter.onError(new Response("Failure" , "JSON Response Parse Error" , 2));
                }
            }
        }.start();
    }
}
