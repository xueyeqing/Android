package com.winorout.zyzhang.activity.android_stickydecoration.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.winorout.zyzhang.activity.android_stickydecoration.R;
import com.winorout.zyzhang.activity.android_stickydecoration.module.City;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @Description:
 * @Author: zyzhang
 * @Date: 17/7/5 下午10:22
 */
public class SimpleAdapter extends RecyclerView.Adapter {

    private ArrayList<City> datalist;

    public SimpleAdapter(ArrayList list) {
        this.datalist = list;
    }

    /**
     * 实例化view
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view, parent, false);
        return new Holder(view);
    }

    /**
     * 绑定view
     *
     * @param viewHolder
     * @param position
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        Holder holder = (Holder) viewHolder;
        holder.mTextView.setText(datalist.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    public static class Holder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv)
        TextView mTextView;

        public Holder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
