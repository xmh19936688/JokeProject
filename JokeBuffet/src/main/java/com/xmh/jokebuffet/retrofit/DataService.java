package com.xmh.jokebuffet.retrofit;

import com.xmh.jokebuffet.model.JokeResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

/**
 * Created by mengh on 2016/6/14 014.
 */
public interface DataService {

    @GET("showapi_open_bus/showapi_joke/joke_text")
    Call<JokeResult> getJoke(@Header("apikey")String key,@Path("page") int page);
}
