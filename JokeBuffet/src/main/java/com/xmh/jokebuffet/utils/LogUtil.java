package com.xmh.jokebuffet.utils;

import android.util.Log;

import com.xmh.jokebuffet.application.AppConfig;

/**
 * Created by mengh on 2016/6/7 007.
 */
public class LogUtil {
    public static void e(String tag,String text){
        if(AppConfig.isDebug){
            Log.e(tag,text);
        }
    }
}
