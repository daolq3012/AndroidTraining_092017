package com.example.sony.training.model;

import com.example.sony.training.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 11/06/17.
 */

public class Data {

    private static final int[] listAndroidImages = {
            R.drawable.android_eclair, R.drawable.android_froyo, R.drawable.android_gingerbread,
            R.drawable.android_honeycomb, R.drawable.android_ics, R.drawable.android_jelly_bean,
            R.drawable.android_lollipop, R.drawable.android_marshmallow
    };
    private static final String[] listNameVersions = {
            "Android Eclair", "Android Froyo", "Android Gingerbread", "Android Honeycomb",
            "Android Ice Cream Sandwich", "Android Jelly Bean", "Android Lollipop",
            "Android Marshmallow"
    };

    private static final String[] listNames = {
            "Truyền", "Chương", "Long"
    };

    public static List<Timeline> getListTimeline() {
        List<Timeline> listItem = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < listAndroidImages.length && j < listNameVersions.length; j++) {
                Timeline item = new Timeline();
                item.setAndroidImages(listAndroidImages[j]);
                item.setNameVersion(listNameVersions[j]);
                listItem.add(item);
            }
        }
        return listItem;
    }

    public static List<Person> getListNames() {
        List<Person> listItem = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < listNames.length; j++) {
                Person item = new Person();
                item.setName(listNames[j]);
                listItem.add(item);
            }
        }
        return listItem;
    }
}
