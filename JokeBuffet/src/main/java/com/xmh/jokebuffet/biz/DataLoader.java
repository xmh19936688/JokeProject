package com.xmh.jokebuffet.biz;

import com.google.gson.Gson;
import com.xmh.jokebuffet.application.AppConfig;
import com.xmh.jokebuffet.model.JokeResult;
import com.xmh.jokebuffet.retrofit.DataService;
import com.xmh.jokebuffet.web.WebLoader;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;

/**
 * Created by mengh on 2016/6/7 007.
 */
public class DataLoader {

    /**使用原生HttpURLConnection请求*/
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

    /**使用OkHttp框架请求*/
    public static void LoadJokeByOkHttp(final OnJokeLoadFinishListener listener){
        String httpUrl = AppConfig.httpUrl + "?" + AppConfig.httpArg;//拼接url
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(httpUrl)
                .addHeader("apikey", AppConfig.appKey)//header
                .build();

        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //处理返回json串
                JokeResult jokeResult = new Gson().fromJson(response.body().string(), JokeResult.class);
                listener.onFinish(jokeResult);
            }
        });
    }

    public static void loadJokeByRetrofit(final OnJokeLoadFinishListener listener){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(AppConfig.BASE_URL)
                .build();
        DataService service=retrofit.create(DataService.class);

        retrofit2.Call<JokeResult> joke = service.getJoke(AppConfig.appKey, 1);
    }

    public interface OnJokeLoadFinishListener{
        void onFinish(JokeResult result);
    }

}
