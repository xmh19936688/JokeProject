package com.xmh.jokebuffet.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.xmh.jokebuffet.R;
import com.xmh.jokebuffet.model.JokeResult;
import com.xmh.jokebuffet.ui.adapter.JokeListAdapter;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    String httpUrl = "http://apis.baidu.com/showapi_open_bus/showapi_joke/joke_text";
    String httpArg = "page=1";

    @Bind(R.id.rv_list) RecyclerView rvList;
    private JokeListAdapter mJokeListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mJokeListAdapter = new JokeListAdapter(MainActivity.this);
        rvList.setAdapter(mJokeListAdapter);
        rvList.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        new Thread(new Runnable() {
            @Override
            public void run() {
                final String jsonResult = request(httpUrl, httpArg);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        JokeResult jokeResult = new Gson().fromJson(jsonResult, JokeResult.class);
                        mJokeListAdapter.setJokeList(jokeResult.getShowapi_res_body().getContentlist());
                    }
                });
            }
        }).start();
    }

    /**
     * @param httpUrl
     *            :请求接口
     * @param httpArg
     *            :参数
     * @return 返回结果
     */
    public static String request(String httpUrl, String httpArg) {
        BufferedReader reader = null;
        String result = null;
        StringBuffer sbf = new StringBuffer();
        httpUrl = httpUrl + "?" + httpArg;

        try {
            URL url = new URL(httpUrl);
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            connection.setRequestMethod("GET");
            // 填入apikey到HTTP header
            connection.setRequestProperty("apikey",  "033f3a4c145c2fada9a74aea0220fef0");
            connection.connect();
            InputStream is = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sbf.append(strRead);
                sbf.append("\r\n");
            }
            reader.close();
            result = sbf.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
