package com.mhxy.views;

import android.content.Context;
import android.graphics.*;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.mhxy.R;
import com.mhxy.init.InitGame;
import com.mhxy.util.CanvasUtil;

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

    private int w;

    private int h;

    private int startX = 100, startY = 100;

    /**
     * 画笔
     */
    private Paint paint;

    private int currentFrame = 0;

    public FireGameView(Context context) {
        super(context);
        sfh = this.getHolder();
        sfh.addCallback(this);
        paint = new Paint();
        paint.setColor(Color.GREEN);
        bmp = BitmapFactory.decodeResource(this.getResources(), R.drawable.mhxy);
        InitGame.init(this.getResources());
        //获取屏幕数据
        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        //获取屏幕宽高，单位是像素
        w = displayMetrics.widthPixels;
        h = displayMetrics.heightPixels;
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
        canvas.save();
        Bitmap fyn = InitGame.bitmapList.get("fyn");
        CanvasUtil.canvas8Role(fyn, canvas, paint, 6, currentFrame, startX, startY);
        canvas.restore();
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
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (currentFrame < 7) {
                currentFrame++;
            } else {
                currentFrame = 0;
            }
            startY = startY + 20;
            draw();
        }
        return super.onTouchEvent(event);
    }


}
