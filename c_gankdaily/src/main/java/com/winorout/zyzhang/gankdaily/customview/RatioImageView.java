package com.winorout.zyzhang.gankdaily.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * @Description:
 * @Author: zyzhang
 * @Date: 17/9/13 下午9:11
 */
public class RatioImageView extends ImageView {
    private int originalWidth;
    private int originalHeight;


    private int measureWidth;
    private int measureHeight;

    public RatioImageView(Context context) {
        this(context, null);
    }

    public RatioImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RatioImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
    }

    public void setOriginalSize(int originalWidth, int originalHeight) {
        this.originalWidth = originalWidth;
        this.originalHeight = originalHeight;
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (originalHeight > 0 && originalWidth > 0) {
            float radio = (float) originalWidth / (float) originalHeight;

            measureWidth = MeasureSpec.getSize(widthMeasureSpec);
            measureHeight = MeasureSpec.getSize(heightMeasureSpec);

            if (measureWidth > 0) {
                measureHeight = (int) ((float) measureWidth / radio);
            }
            setMeasuredDimension(measureWidth, measureHeight);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }
}
