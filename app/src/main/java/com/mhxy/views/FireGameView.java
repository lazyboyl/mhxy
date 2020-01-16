package com.mhxy.views;

import android.content.Context;
import android.graphics.*;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.mhxy.R;

/**
 * @author linzf
 * @since 2020/1/16
 * 类描述： 战斗的视图界面
 */
public class FireGameView extends SurfaceView implements SurfaceHolder.Callback {

    private int x = 100;

    private int y = 100;

    /**
     * 用户控制SurfaceView
     */
    private SurfaceHolder sfh;

    private Bitmap bmp;

    /**
     * 画笔
     */
    private Paint paint;

    public FireGameView(Context context) {
        super(context);
        sfh = this.getHolder();
        sfh.addCallback(this);
        paint = new Paint();
        paint.setColor(Color.GREEN);
        bmp = BitmapFactory.decodeResource(this.getResources(), R.drawable.mhxy);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        draw();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    public void draw() {
        Canvas canvas = sfh.lockCanvas();
        canvas.drawColor(Color.BLACK);
        canvas.drawBitmap(bmp, 100, 100, paint);
        sfh.unlockCanvasAndPost(canvas);
    }

    /**
     * 功能描述： 重写触屏函数
     *
     * @param event
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        x = (int) event.getX();
        y = (int) event.getY();
        draw();
        return super.onTouchEvent(event);
    }


}
