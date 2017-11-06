package com.example.sony.training.model;

import com.example.sony.training.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 11/06/17.
 */

public class Data {
    private static final int[] listAvatars = {R.drawable.avt2,R.drawable.avt3,R.drawable.avt4};
    private static final String[] listNames = {"Truyền",
            "Chương","Long"};
    private static final String[] listPhoneNumbers = {"0167xxxxxxxx",
            "01696xxxxxxx","0967xxxxxxxx"};
    public static List<Contact> getListContacts() {
        List<Contact> listItem = new ArrayList<>();
        for (int i=0;i<4;i++) {
            for (int j=0;j<listAvatars.length && j<listNames.length && j<listPhoneNumbers.length;j++) {
                Contact item = new Contact();
                item.setAvatar(listAvatars[j]);
                item.setName(listNames[j]);
                item.setPhoneNumber(listPhoneNumbers[j]);
                listItem.add(item);
            }
        }
        return listItem;
    }
}
