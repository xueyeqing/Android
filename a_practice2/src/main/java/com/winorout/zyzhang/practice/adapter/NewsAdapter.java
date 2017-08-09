package com.winorout.zyzhang.practice.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.winorout.zyzhang.practice.R;
import com.winorout.zyzhang.practice.bean.LatestNews;

import java.util.List;

/**
 * @Description:
 * @Author: zyzhang
 * @Date: 17/8/9 下午9:53
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private Context mContext;
    private List<LatestNews.StoriesBean> storiesList;
    public static final String NEWS_ID = "news _id";

    public NewsAdapter(List<LatestNews.StoriesBean> list){
        this.storiesList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.latest_news_item, parent, false);
        final ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        LatestNews.StoriesBean storiesBean = storiesList.get(position);
        holder.newsText.setText(storiesBean.getTitle());
        Glide.with(mContext).load(storiesBean.getImages().get(0)).into(holder.newsImage);
    }

    @Override
    public int getItemCount() {
        return storiesList.size();
    }

    /**
     * ViewHolder
     */
    class ViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        ImageView newsImage;
        TextView newsText;

        public ViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.latest_news_cardview);
            newsImage = (ImageView) itemView.findViewById(R.id.latest_news_image);
            newsText = (TextView) itemView.findViewById(R.id.latest_news_title);
        }
    }
}
