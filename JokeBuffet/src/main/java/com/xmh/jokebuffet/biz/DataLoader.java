package com.xmh.jokebuffet.biz;

import com.google.gson.Gson;
import com.xmh.jokebuffet.application.AppConfig;
import com.xmh.jokebuffet.model.JokeResult;
import com.xmh.jokebuffet.web.WebLoader;

/**
 * Created by mengh on 2016/6/7 007.
 */
public class DataLoader {

    public static void LoadJoke(final OnJokeLoadFinishListener listener){
        new Thread(new Runnable() {
            @Override
            public void run() {
                final String jsonResult = WebLoader.request(AppConfig.httpUrl, AppConfig.httpArg);
                JokeResult jokeResult = new Gson().fromJson(jsonResult, JokeResult.class);
                listener.onFinish(jokeResult);
            }
        }).start();
    }

    public interface OnJokeLoadFinishListener{
        void onFinish(JokeResult result);
    }

}
