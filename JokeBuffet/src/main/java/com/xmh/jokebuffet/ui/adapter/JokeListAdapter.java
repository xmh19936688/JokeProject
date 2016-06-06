package com.xmh.jokebuffet.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xmh.jokebuffet.R;
import com.xmh.jokebuffet.model.JokeBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by mengh on 2016/6/6 006.
 */
public class JokeListAdapter extends RecyclerView.Adapter<JokeListAdapter.JokeViewHolder>{

    private final Context mContext;
    List<JokeBean> mJokeList=new ArrayList<>();
    
    public JokeListAdapter(Context context){
        this.mContext=context;
    }

    public void setJokeList(List<JokeBean> list){
        mJokeList.clear();
        if(list!=null&&!list.isEmpty()){
            mJokeList.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override
    public JokeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(mContext).inflate(R.layout.layout_joke_item, parent, false);
        return new JokeViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(JokeViewHolder holder, int position) {
        JokeBean jokeBean = mJokeList.get(position);
        holder.tvTitle.setText(jokeBean.getTitle());
        holder.tvTime.setText(jokeBean.getCt());
        holder.tvContent.setText(jokeBean.getText());
    }

    @Override
    public int getItemCount() {
        return mJokeList.size();
    }

    class JokeViewHolder extends RecyclerView.ViewHolder{

        @Bind(R.id.tv_title) TextView tvTitle;
        @Bind(R.id.tv_time) TextView tvTime;
        @Bind(R.id.tv_content) TextView tvContent;

        public JokeViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
