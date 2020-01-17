package com.mhxy.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * @author linzf
 * @since 2020/1/17
 * 类描述：
 */
public class CanvasUtil {


    public static void canvas8Role(Bitmap bmp, Canvas canvas, Paint paint, int direction, int currentFrame, int startX, int startY) {
        int bmpWidth = bmp.getWidth();
        int bmpHeight = bmp.getHeight();
        // 设置当前的可视区域
        canvas.clipRect(startX, startY, startX + bmpWidth / 8, startY + bmpHeight / 8);
        // 绘制角色的移动图片
        canvas.drawBitmap(bmp, startX - currentFrame * bmpWidth / 8, startY - direction * bmpHeight / 8, paint);
    }

}
