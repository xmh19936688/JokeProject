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
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.functions.Action1;

/**
 * Created by mengh on 2016/6/7 007.
 */
public class DataLoader {

    /**使用原生HttpURLConnection请求*/
    public static void loadJoke(final OnJokeLoadFinishListener listener){
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
    public static void loadJokeByOkHttp(final OnJokeLoadFinishListener listener){
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

    /**使用Retrofit框架请求*/
    public static void loadJokeByRetrofit(final OnJokeLoadFinishListener listener){
        //必须在线程中访问网络
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //实例化Retrofit
                    Retrofit retrofit=new Retrofit.Builder()
                            .baseUrl(AppConfig.BASE_URL)//指明baseUrl
                            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//与RxJava结合必须指明CallAdapter
                            .addConverterFactory(GsonConverterFactory.create())//必须指明反序列化转换器（即json解析，此处用Gson）
                            .build();
                    DataService service=retrofit.create(DataService.class);

                    //调用该接口中的方法
                    service.getJoke(AppConfig.appKey,1).subscribe(new Action1<JokeResult>() {
                        @Override
                        public void call(JokeResult jokeResult) {
                            //返回结果
                            listener.onFinish(jokeResult);
                        }
                    });
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public interface OnJokeLoadFinishListener{
        void onFinish(JokeResult result);
    }

}
