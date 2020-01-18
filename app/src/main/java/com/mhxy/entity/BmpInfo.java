package com.mhxy.entity;

import android.graphics.Bitmap;

/**
 * @author linzf
 * @since 2020/1/18
 * 类描述：bmp图像的实体类
 */
public class BmpInfo {

    /**
     * 图像的bmp
     */
    private Bitmap bmp;

    /**
     * 图像的宽度
     */
    private int bmpWidth;

    /**
     * 图像的高度
     */
    private int bmpHeight;

    /**
     * 距中心点x的距离
     */
    private int centerX;

    /**
     * 距中心点Y的距离
     */
    private int centerY;

    /**
     * 可视区域X的值
     */
    private int rectX;

    /**
     * 可视区域y的值
     */
    private int rectY;

    public int getRectX() {
        return rectX;
    }

    public void setRectX(int rectX) {
        this.rectX = rectX;
    }

    public int getRectY() {
        return rectY;
    }

    public void setRectY(int rectY) {
        this.rectY = rectY;
    }

    public int getCenterX() {
        return centerX;
    }

    public void setCenterX(int centerX) {
        this.centerX = centerX;
    }

    public int getCenterY() {
        return centerY;
    }

    public void setCenterY(int centerY) {
        this.centerY = centerY;
    }

    public Bitmap getBmp() {
        return bmp;
    }

    public void setBmp(Bitmap bmp) {
        this.bmp = bmp;
    }

    public int getBmpWidth() {
        return bmpWidth;
    }

    public void setBmpWidth(int bmpWidth) {
        this.bmpWidth = bmpWidth;
    }

    public int getBmpHeight() {
        return bmpHeight;
    }

    public void setBmpHeight(int bmpHeight) {
        this.bmpHeight = bmpHeight;
    }
}
