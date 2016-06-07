package com.xmh.jokebuffet.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.xmh.jokebuffet.R;
import com.xmh.jokebuffet.ui.fragment.MainFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.fl_content)FrameLayout flContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        MainFragment fragment = new MainFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fl_content, fragment, "gifList").commit();
    }

}
