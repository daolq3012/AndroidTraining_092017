package com.example.sony.training.model;

import com.example.sony.training.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 11/06/17.
 */

public class Data {
    private static final int[] listAvatar = {R.drawable.avt5,R.drawable.avt5,R.drawable.avt5};
    private static final String[] listContent = {"Thái Huy liked your photo","Thành Trung liked your photo","Văn Chương liked your photo"};
    private static final String[] listTime = {"20 phút trước",
            "1 giờ trước","3 giờ trước"};
    private static final String[] listName = {"Truyền",
            "Chương","Long"};
    public static List<Timeline> getListTimeline() {
        List<Timeline> listItem = new ArrayList<>();
        for (int i=0;i<4;i++) {
            for (int j=0;j<listAvatar.length && j<listContent.length && j<listTime.length;j++) {
                Timeline item = new Timeline();
                item.setAvatar(listAvatar[j]);
                item.setContent(listContent[j]);
                item.setTime(listTime[j]);
                listItem.add(item);
            }
        }
        return listItem;
    }
    public static List<Person> getListName() {
        List<Person> listItem = new ArrayList<>();
        for (int i=0;i<4;i++) {
            for (int j=0;j<listName.length;j++) {
                Person item = new Person();
                item.setName(listName[j]);
                listItem.add(item);
            }
        }
        return listItem;
    }
}
