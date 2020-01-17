package com.mhxy.init;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import com.mhxy.R;

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
        Bitmap cjsn = null;
        Bitmap cjsn_new = null;
        Bitmap fyn = null;
        Bitmap ddf = null;
        try {
            dhw = BitmapFactory.decodeStream(resources.getAssets().open("dhw.png"));
            cjsn = BitmapFactory.decodeStream(resources.getAssets().open("cjsn.png"));
            cjsn_new = BitmapFactory.decodeResource(resources, R.drawable.cjsn);
            fyn = BitmapFactory.decodeResource(resources, R.drawable.fyn);
            ddf = BitmapFactory.decodeResource(resources, R.drawable.ddf);
        } catch (IOException e) {
            e.printStackTrace();
        }
        bitmapList.put("dhw", imageScale(dhw, dhw.getWidth() * 2.625,dhw.getHeight()* 2.625) );
        bitmapList.put("cjsn", imageScale(cjsn, cjsn.getWidth(),cjsn.getHeight()));
        bitmapList.put("cjsn_new", cjsn_new);
        bitmapList.put("fyn", fyn);
        bitmapList.put("ddf", ddf);
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
    public static Bitmap imageScale(Bitmap bitmap, double dst_w, double dst_h) {
        int src_w = bitmap.getWidth();
        int src_h = bitmap.getHeight();
        float scale_w = ((float) dst_w) / src_w;
        float scale_h = ((float) dst_h) / src_h;
        Matrix matrix = new Matrix();
        matrix.postScale(scale_w, scale_h);
        return Bitmap.createBitmap(bitmap, 0, 0, src_w, src_h, matrix,  true);
    }


}
