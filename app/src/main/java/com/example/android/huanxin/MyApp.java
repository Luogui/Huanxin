package com.example.android.huanxin;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;

import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMOptions;
import com.hyphenate.easeui.EaseUI;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Android on 2017/8/4.
 */

public class MyApp extends Application {


    @Override
    public void onCreate() {
        super.onCreate();

        EaseUI.getInstance().init(this, null);
        EMClient.getInstance().setDebugMode(true);

    }


}
