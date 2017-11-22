package com.example.sony.training.data;

/**
 * Created by Admin on 11/22/17.
 */

public class ApiService {
    public boolean login(String username, String password) {
        if(username.equals("tdtruyen") && password.equals("123456")) {
            return true;
        } else {
            return false;
        }
    }
}
