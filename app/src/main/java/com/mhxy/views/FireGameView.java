package com.mhxy.views;

import android.content.Context;
import android.graphics.*;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.mhxy.entity.BmpInfo;
import com.mhxy.init.InitGame;
import com.mhxy.util.CanvasUtil;
import com.mhxy.util.GameUtil;

/**
 * @author linzf
 * @since 2020/1/16
 * 类描述： 战斗的视图界面
 */
public class FireGameView extends SurfaceView implements SurfaceHolder.Callback {

    private int x = 0;

    private int y = 0;

    /**
     * 用户控制SurfaceView
     */
    private SurfaceHolder sfh;

    private int w;

    private int h;

    private int startX = 500, startY = 500;

    public boolean flag = false;

    /**
     * 画笔
     */
    private Paint paint;

    private int currentFrame = 0;

    private BmpInfo fyn;

    public FireGameView(Context context) {
        super(context);
        sfh = this.getHolder();
        sfh.addCallback(this);
        paint = new Paint();
        paint.setColor(Color.GREEN);
        InitGame.init(this.getResources());
        //获取屏幕数据
        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        //获取屏幕宽高，单位是像素
        w = displayMetrics.widthPixels;
        h = displayMetrics.heightPixels;
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        draw(0);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    public void draw(int direction) {
        Canvas canvas = sfh.lockCanvas();
        canvas.drawColor(Color.BLACK);
        canvas.save();
        fyn = InitGame.bitmapList.get("fyn");
        CanvasUtil.canvas8Role(fyn, canvas, paint, direction, currentFrame, startX, startY);
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
        flag = true;
        x = (int) event.getX();
        y = (int) event.getY();
        // 根据起始点和目的点来获取当前角色行走的方向【bmpWidth / 16】这是为了将起点设置为图像的中间位置
        int direction = GameUtil.get8RoleDirection(startX + fyn.getCenterX(), startY + fyn.getCenterY(), x, y);
        while (flag) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (x == startX + fyn.getCenterX() && y == startY + fyn.getCenterY()) {
                flag = false;
            }
            if (x != startX + fyn.getCenterX()) {
                startX = GameUtil.addX(startX, x, fyn.getCenterX());
            }
            if (y != startY + fyn.getCenterY()) {
                startY = GameUtil.addY(startY, y, fyn.getCenterY());
            }
            if (currentFrame < 7) {
                currentFrame++;
            } else {
                currentFrame = 0;
            }
            draw(direction);
        }
        return super.onTouchEvent(event);
    }


}
