package com.example.sony.training.Receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by ThanhThang on 13/11/2017.
 */

public class RestartBroadCastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("QQQ", "Reboot");
    }
}
