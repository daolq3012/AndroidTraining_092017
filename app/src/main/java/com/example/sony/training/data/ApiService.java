package com.example.sony.training.data;

/**
 * Created by Administrator on 11/22/17.
 */

public class ApiService {
    // data co the goi len server va tra ve.
    public boolean login(String username, String password){
        if (username.equals("vanchuong") && password.equals("123456")){
            return true;
        } else {
            return false;
        }
    }
}
