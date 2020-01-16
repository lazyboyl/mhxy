package com.mhxy.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

/**
 * @author linzf
 * @since 2020/1/16
 * 类描述：
 */
public class MainView extends View {

    private int x = 100;

    private int y = 100;

    public MainView(Context context) {
        super(context);
    }

    /**
     * 功能描述：重写父类绘图函数
     *
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.GREEN);
        canvas.drawText("hello paint", x, y, paint);
        super.onDraw(canvas);
    }

    /**
     * 功能描述： 重写触屏函数
     *
     * @param event
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        x = x + 5;
        y = y + 5;
        invalidate();
        return super.onTouchEvent(event);
    }

}
