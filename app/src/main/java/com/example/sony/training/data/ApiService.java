package com.example.sony.training.data;

/**
 * Created by ThanhThang on 22/11/2017.
 */

public class ApiService {
    public boolean login(String userName, String passwrod){
        if (userName.equals("thanhthang") && passwrod.equals("123456")){
            return true;
        }
        return false;
    }
}
