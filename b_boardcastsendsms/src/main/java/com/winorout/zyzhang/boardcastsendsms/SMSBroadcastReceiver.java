package com.winorout.zyzhang.boardcastsendsms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

/**
 * @Description: 广播接收者实现短信的监听
 * @Author: zyzhang
 * @Date: 17/8/2 下午9:12
 */
public class SMSBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        SmsMessage msg = null;
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            Log.d("zyzhang",bundle+"");
        }
    }
}
