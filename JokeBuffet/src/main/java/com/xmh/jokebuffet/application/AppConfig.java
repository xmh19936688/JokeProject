package com.xmh.jokebuffet.application;

/**
 * Created by mengh on 2016/6/7 007.
 */
public class AppConfig {

    /**请求完整URL*/
    public static final String httpUrl = "http://apis.baidu.com/showapi_open_bus/showapi_joke/joke_text";
    /**请求分页参数*/
    public static final String httpArg = "page=1";
    /**请求key*/
    public static final String appKey = "033f3a4c145c2fada9a74aea0220fef0";

    /**Retrofit请求BaseUrl*/
    public static final String BASE_URL="http://apis.baidu.com/";
    /**Retrofit请求joke相对URL*/
    public static final String JOKE_URL="showapi_open_bus/showapi_joke/joke_text";

    public static final boolean isDebug=true;
}
