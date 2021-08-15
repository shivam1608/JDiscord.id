package me.shivzee.io;

import me.shivzee.utils.Response;
import me.shivzee.utils.User;

public interface EventAdapter {

    void onUserFound(User user);
    default void onUserNotFound(Response response){

    }

    void onError(Response response);

}
