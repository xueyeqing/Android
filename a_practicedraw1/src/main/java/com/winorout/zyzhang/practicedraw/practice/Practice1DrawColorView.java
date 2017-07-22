package com.winorout.zyzhang.practicedraw.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice1DrawColorView extends View {

    private Paint paint = new Paint();

    public Practice1DrawColorView(Context context) {
        super(context);
    }

    public Practice1DrawColorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice1DrawColorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setAntiAlias(true);
        paint.setColor(Color.parseColor("#009688"));
        // 左上右下
        canvas.drawRect(30, 30, 230, 180, paint);

        paint.setColor(Color.parseColor("#FF9800"));
        paint.setStrokeWidth(10);
        // startX startY stopX stopY
        canvas.drawLine(300, 30, 450, 180, paint);

        paint.setARGB(100, 255, 0, 0);
        canvas.drawRect(30, 230, 230, 380, paint);

        paint.setColor(Color.parseColor("#E91E63"));
        paint.setTextSize(36);
        // x y
        canvas.drawText("HenCoder", 500, 130, paint);

        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(1);
        canvas.drawCircle(110, 500, 100, paint);

        paint.setStrokeWidth(5);
        canvas.drawCircle(350, 500, 100, paint);

        paint.setStrokeWidth(40);
        canvas.drawCircle(580, 500, 100, paint);

    }
}
