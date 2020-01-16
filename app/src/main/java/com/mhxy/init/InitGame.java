package com.mhxy.init;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author linzf
 * @since 2020-01-16
 * 类描述： 游戏初始化类
 */
public class InitGame {

    /**
     * 存放游戏图片资源的集合
     */
    public static Map<String, Bitmap> bitmapList = new HashMap<>();

    public static void init(Resources resources) {
        Bitmap dhw = null;
        try {
            dhw = BitmapFactory.decodeStream(resources.getAssets().open("dhw.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        bitmapList.put("dhw", imageScale(dhw, dhw.getWidth(),dhw.getHeight()));
    }

    /**
     * 调整图片大小
     *
     * @param bitmap
     *            源
     * @param dst_w
     *            输出宽度
     * @param dst_h
     *            输出高度
     * @return
     */
    public static Bitmap imageScale(Bitmap bitmap, int dst_w, int dst_h) {
        int src_w = bitmap.getWidth();
        int src_h = bitmap.getHeight();
        float scale_w = ((float) dst_w) / src_w;
        float scale_h = ((float) dst_h) / src_h;
        Matrix matrix = new Matrix();
        matrix.postScale(scale_w, scale_h);
        return Bitmap.createBitmap(bitmap, 0, 0, src_w, src_h, matrix,  true);
    }


}
