package com.xmh.jokebuffet.retrofit;

import com.xmh.jokebuffet.application.AppConfig;
import com.xmh.jokebuffet.model.JokeResult;

import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by mengh on 2016/6/14 014.
 */
public interface DataService {

    /**静态指定相对Url*/
    @GET(AppConfig.JOKE_URL)
    /**第一个参数为请求Header中的apikey，第二个参数为请求参数中的page*/
    Observable<JokeResult> getJoke(@Header("apikey")String key, @Query("page") int page);
}
