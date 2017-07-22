package com.winorout.zyzhang.practicedraw.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.winorout.zyzhang.practicedraw.R;

public class Practice2DrawCircleView extends View {

    private Paint paint = new Paint();
    private Bitmap bitmap;

    public Practice2DrawCircleView(Context context) {
        super(context);
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // LinearGradient 线性渐变
        Shader shader = new LinearGradient(0, 0, 200, 200, Color.parseColor("#E91E63"), Color.parseColor("#2196F3"), Shader.TileMode.CLAMP);
        paint.setShader(shader);
        paint.setAntiAlias(true);
        canvas.drawCircle(100, 100, 100, paint);

        // RadialGradient 辐射渐变
        Shader shader2 = new RadialGradient(400, 100, 100, Color.parseColor("#E91E63"), Color.parseColor("#2196F3"), Shader.TileMode.CLAMP);
        paint.setShader(shader2);
        canvas.drawCircle(400, 100, 100, paint);

        // SweepGradient 扫描渐变

        // BitmapShader
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.yy);
//         tileX：横向的 TileMode tileY：纵向的 TileMode。
        Shader shader3 = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        paint.setShader(shader3);
        canvas.drawCircle(280, 280, 200, paint);
//        canvas.drawRect(0, 0, bitmap.getWidth() * 2, bitmap.getHeight() * 2, paint);

    }
}
