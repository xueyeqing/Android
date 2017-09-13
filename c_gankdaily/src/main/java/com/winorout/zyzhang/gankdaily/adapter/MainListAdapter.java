package com.winorout.zyzhang.gankdaily.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.orhanobut.logger.Logger;
import com.winorout.zyzhang.gankdaily.R;
import com.winorout.zyzhang.gankdaily.activity.BaseActivity;
import com.winorout.zyzhang.gankdaily.customview.RatioImageView;
import com.winorout.zyzhang.gankdaily.mvprx.entity.GankData;
import com.winorout.zyzhang.gankdaily.util.DateUtil;
import com.winorout.zyzhang.gankdaily.util.StringStyleUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Author: zyzhang
 * @Date: 17/9/13 下午3:58
 */
public class MainListAdapter extends RecyclerView.Adapter<MainListAdapter.ViewHolderItem> {

    private List<GankData.Result.Gank> mGankList;
    private BaseActivity mContext;

    public MainListAdapter(BaseActivity context) {
        mContext = context;
        mGankList = new ArrayList<>();
//        mGankList.add(getDefGankGirl());
    }

    /**
     * before add data , it will remove history data
     *
     * @param data
     */
    public void updateWithClear(List<GankData.Result.Gank> data) {
        mGankList.clear();
        update(data);
    }

    /**
     * add data append to history data*
     *
     * @param data new data
     */
    public void update(List<GankData.Result.Gank> data) {
        formatGankData(data);
        notifyDataSetChanged();
    }

    private void formatGankData(List<GankData.Result.Gank> data) {
        String lastHeader = "";
        for (int i = 0; i < data.size(); i++) {
            GankData.Result.Gank gank = data.get(i);
            String header = gank.type;
            // 如果不是福利 且 上一个和下一个header不相等
            if (!gank.is妹子() && !TextUtils.equals(lastHeader, header)) {
                // Insert new header view.
                GankData.Result.Gank gankHeader = gank.clone();
                lastHeader = header;
                gankHeader.isHeader = true;
                mGankList.add(gankHeader);
            }
            gank.isHeader = false;
            mGankList.add(gank);
        }
    }

    private enum EItemType {
        ITEM_TYPE_GIRL,
        ITEM_TYPE_NORMAL,
        ITEM_TYPE_CATEGOTY;
    }

    @Override
    public int getItemViewType(int position) {
        GankData.Result.Gank gank = mGankList.get(position);
        if (gank.is妹子()) {
            return EItemType.ITEM_TYPE_GIRL.ordinal();
        } else if (gank.isHeader) {
            return EItemType.ITEM_TYPE_CATEGOTY.ordinal();
        } else {
            return EItemType.ITEM_TYPE_NORMAL.ordinal();
        }
    }

    @Override
    public ViewHolderItem onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (viewType == EItemType.ITEM_TYPE_GIRL.ordinal()) {
            view = LayoutInflater.from(mContext).inflate(R.layout.gank_item_girl, null);
            return new ViewHolderItemGirl(view);
        } else if (viewType == EItemType.ITEM_TYPE_CATEGOTY.ordinal()) {
            view = LayoutInflater.from(mContext).inflate(R.layout.gank_item_category, null);
            return new ViewHolderItemCategory(view);
        } else {
            view = LayoutInflater.from(mContext).inflate(R.layout.gank_item_normal, null);
            return new ViewHolderItemNormal(view);
        }
    }

    @Override
    public void onBindViewHolder(ViewHolderItem holder, int position) {
        holder.bindItem(mContext, mGankList.get(position), position);
    }

    @Override
    public int getItemCount() {
        return mGankList.size();
    }

    static abstract class ViewHolderItem extends RecyclerView.ViewHolder {

        public ViewHolderItem(View itemView) {
            super(itemView);
        }

        abstract void bindItem(Context context, GankData.Result.Gank gank, int position);
    }

    static class ViewHolderItemNormal extends ViewHolderItem {

        TextView mTvTitle;
        RelativeLayout mRlGankParent;

        public ViewHolderItemNormal(View itemView) {
            super(itemView);
            mTvTitle = (TextView) itemView.findViewById(R.id.tv_gank_title);
            mRlGankParent = (RelativeLayout) itemView.findViewById(R.id.ll_gank_parent);
        }

        @Override
        void bindItem(Context context, GankData.Result.Gank gank, int position) {
            mTvTitle.setText(StringStyleUtils.getGankInfoSequence(context, gank));
        }
    }

    static class ViewHolderItemCategory extends ViewHolderItem {
        TextView mTvCategory;

        ViewHolderItemCategory(View itemView) {
            super(itemView);
            mTvCategory = (TextView) itemView.findViewById(R.id.tv_category);
        }

        @Override
        void bindItem(Context context, GankData.Result.Gank gank, int position) {
            mTvCategory.setText(gank.type);
        }
    }

    static class ViewHolderItemGirl extends ViewHolderItem {
        TextView mTvTime;
        View mBkTime;
        RatioImageView mImageView;

        ViewHolderItemGirl(View itemView) {
            super(itemView);
            mTvTime = (TextView) itemView.findViewById(R.id.tv_video_name);
            mBkTime = itemView.findViewById(R.id.ll_bk_time);
            mImageView = (RatioImageView) itemView.findViewById(R.id.iv_index_photo);
            mImageView.setOriginalSize(200, 100);
        }

        @Override
        void bindItem(Context context, final GankData.Result.Gank gank, final int position) {

            Glide.with(context)
                    .load(gank.url)
                    .asBitmap()
                    .into(new BitmapImageViewTarget(mImageView) {
                        @Override
                        public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                            super.onResourceReady(resource, glideAnimation);
                            mBkTime.setVisibility(View.VISIBLE);
                        }
                    });

            mTvTime.setText(DateUtil.toDate(gank.publishedAt));
        }
    }

    private GankData.Result.Gank getDefGankGirl() {
        GankData.Result.Gank gank = new GankData.Result.Gank();
        gank.publishedAt = new Date(System.currentTimeMillis());
        gank.url = "empty";
        gank.type = "福利";
        return gank;
    }
}
