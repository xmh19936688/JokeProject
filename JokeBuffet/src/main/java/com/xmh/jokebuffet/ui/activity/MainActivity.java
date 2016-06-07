package com.xmh.jokebuffet.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.xmh.jokebuffet.R;
import com.xmh.jokebuffet.biz.DataLoader;
import com.xmh.jokebuffet.model.JokeResult;
import com.xmh.jokebuffet.ui.adapter.JokeListAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

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

        DataLoader.LoadJoke(new DataLoader.OnJokeLoadFinishListener() {
            @Override
            public void onFinish(final JokeResult result) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mJokeListAdapter.setJokeList(result.getShowapi_res_body().getContentlist());
                    }
                });
            }
        });
    }

}
