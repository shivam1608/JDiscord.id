package me.shivzee.utils;

public class Response {
    private String status;
    private String response;
    private int responseCode;

    public Response(String status , String response , int responseCode){
        this.status = status;
        this.response = response;
    }

    public String getStatus() {
        return status;
    }

    public String getResponse() {
        return response;
    }

    public int getResponseCode() {
        return responseCode;
    }
}
