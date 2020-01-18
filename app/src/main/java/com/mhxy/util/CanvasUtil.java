package com.mhxy.util;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.mhxy.entity.BmpInfo;

/**
 * @author linzf
 * @since 2020/1/17
 * 类描述：
 */
public class CanvasUtil {


    /**
     * 功能描述：实现角色的绘制
     *
     * @param bmpInfo      角色资源信息
     * @param canvas       画图对象
     * @param paint        画笔
     * @param currentFrame 当前帧数
     * @param startX       起点X
     * @param startY       起点Y
     */
    public static void canvas8Role(BmpInfo bmpInfo, Canvas canvas, Paint paint, int direction,int currentFrame, int startX, int startY) {
        int bmpWidth = bmpInfo.getBmpWidth();
        int bmpHeight = bmpInfo.getBmpHeight();
        // 设置当前的可视区域
        canvas.clipRect(startX, startY, startX + bmpInfo.getRectX(), startY + bmpInfo.getRectY());
        // 绘制角色的移动图片
        canvas.drawBitmap(bmpInfo.getBmp(), startX - currentFrame * bmpWidth / 8, startY - direction * bmpHeight / 8, paint);
    }

}
