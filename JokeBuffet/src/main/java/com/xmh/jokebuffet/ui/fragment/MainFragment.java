package com.xmh.jokebuffet.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xmh.jokebuffet.R;
import com.xmh.jokebuffet.biz.DataLoader;
import com.xmh.jokebuffet.model.JokeResult;
import com.xmh.jokebuffet.ui.adapter.JokeListAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends LazyLoadBaseFragment {

    private View mRootView;
    @Bind(R.id.rv_list)RecyclerView rvList;
    private JokeListAdapter mJokeListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView=inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this,mRootView);
        return mRootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mJokeListAdapter = new JokeListAdapter(getActivity());
        rvList.setAdapter(mJokeListAdapter);
        rvList.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    protected void lazyLoad() {
        DataLoader.LoadJoke(new DataLoader.OnJokeLoadFinishListener() {
            @Override
            public void onFinish(final JokeResult result) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mJokeListAdapter.setJokeList(result.getShowapi_res_body().getContentlist());
                    }
                });
            }
        });
    }
}
