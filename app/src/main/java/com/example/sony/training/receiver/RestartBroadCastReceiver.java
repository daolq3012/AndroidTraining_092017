package com.example.sony.training.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by phong on 11/13/17.
 */

public class RestartBroadCastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("QQQQQQQQ","Reboot");
    }
}
