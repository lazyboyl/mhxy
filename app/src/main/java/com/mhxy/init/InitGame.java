package com.mhxy.init;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import com.mhxy.R;
import com.mhxy.entity.BmpInfo;

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
    public static Map<String, BmpInfo> bitmapList = new HashMap<>();

    /**
     * 功能描述： 初始化图片对象
     *
     * @param resources
     */
    public static void init(Resources resources) {
        BmpInfo bmpInfo = new BmpInfo();
        Bitmap fyn = BitmapFactory.decodeResource(resources, R.drawable.fyn);
        bmpInfo.setBmp(fyn);
        bmpInfo.setBmpHeight(fyn.getHeight());
        bmpInfo.setBmpWidth(fyn.getWidth());
        bmpInfo.setCenterX(fyn.getWidth() / 16);
        bmpInfo.setCenterY(fyn.getHeight() / 16);
        bmpInfo.setRectX(fyn.getWidth() / 8);
        bmpInfo.setRectY(fyn.getHeight() / 8);
        bitmapList.put("fyn", bmpInfo);
        // 计算放大比
        double imageScaleSize = fyn.getWidth() / 544;
        try {
            Bitmap dhw = BitmapFactory.decodeStream(resources.getAssets().open("dhw.png"));
            dhw = imageScale(dhw, dhw.getWidth() * imageScaleSize,dhw.getHeight()* imageScaleSize);
            BmpInfo dhwInfo = new BmpInfo();
            dhwInfo.setBmp(dhw);
            dhwInfo.setBmpHeight(dhw.getHeight());
            dhwInfo.setBmpWidth(dhw.getWidth());
            bitmapList.put("dhw", dhwInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 调整图片大小
     *
     * @param bitmap 源
     * @param dst_w  输出宽度
     * @param dst_h  输出高度
     * @return
     */
    public static Bitmap imageScale(Bitmap bitmap, double dst_w, double dst_h) {
        int src_w = bitmap.getWidth();
        int src_h = bitmap.getHeight();
        float scale_w = ((float) dst_w) / src_w;
        float scale_h = ((float) dst_h) / src_h;
        Matrix matrix = new Matrix();
        matrix.postScale(scale_w, scale_h);
        return Bitmap.createBitmap(bitmap, 0, 0, src_w, src_h, matrix, true);
    }


}
