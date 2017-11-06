package com.example.sony.training.model;

import com.example.sony.training.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 11/06/17.
 */

public class Data {
    private static final int[] listAvatars = {R.drawable.avt5,R.drawable.avt5,R.drawable.avt5};
    private static final String[] listContents = {"Thái Huy liked your photo","Thành Trung liked your photo","Văn Chương liked your photo"};
    private static final String[] listTimes = {"20 phút trước",
            "1 giờ trước","3 giờ trước"};
    private static final String[] listNames = {"Truyền",
            "Chương","Long"};
    public static List<Timeline> getListTimeline() {
        List<Timeline> listItem = new ArrayList<>();
        for (int i=0;i<4;i++) {
            for (int j=0;j<listAvatars.length && j<listContents.length && j<listTimes.length;j++) {
                Timeline item = new Timeline();
                item.setAvatar(listAvatars[j]);
                item.setContent(listContents[j]);
                item.setTime(listTimes[j]);
                listItem.add(item);
            }
        }
        return listItem;
    }
    public static List<Person> getListNames() {
        List<Person> listItem = new ArrayList<>();
        for (int i=0;i<4;i++) {
            for (int j=0;j<listNames.length;j++) {
                Person item = new Person();
                item.setName(listNames[j]);
                listItem.add(item);
            }
        }
        return listItem;
    }
}
