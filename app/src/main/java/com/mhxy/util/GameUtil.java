package com.mhxy.util;

/**
 * @author linzf
 * @since 2019-01-17
 * 类描述： 游戏常用工具类
 */
public class GameUtil {

    /**
     * 十度
     */
    public static final Double TEN = 15.0;

    /**
     * 八十度
     */
    public static final Double EIGHTY = 75.0;

    /**
     * 移动的步数
     */
    public static final Integer STEP = 25;

    /**
     * 功能描述：实现角色X轴上的移动
     * @param startX 开始点
     * @param endX 结束点
     * @param centerX 中心偏移值
     * @return 返回移动后的点
     */
    public static int addX(int startX, int endX,int centerX){
        if(startX + centerX > endX){
            return startX - STEP;
        } else {
            return startX + STEP;
        }
    }

    /**
     * 功能描述：实现角色Y轴上的移动
     * @param startY 开始点
     * @param endY 结束点
     * @param centerY 中心偏移值
     * @return 返回移动后的点
     */
    public static int addY(int startY, int endY, int centerY){
        if(startY + centerY > endY){
            return startY - STEP;
        } else {
            return startY + STEP;
        }
    }

    /**
     * 功能描述： 根据两点算出当前角色需要行走的方向
     * @param startX 起点x坐标
     * @param startY 起点y坐标
     * @param endX  终点x坐标
     * @param endY 终点y坐标
     * @return 返回角色行走方向
     */
    public static int get8RoleDirection(int startX, int startY, int endX, int endY) {
        int direction = 0;
        double tan = Math.atan(Math.abs((endY - startY + 0.0) / (endX - startX + 0.0))) * 180 / Math.PI;
        if (endX > startX && endY > startY) {
            if (tan < TEN) {
                // 向右
                direction = 2;
            } else if (tan > EIGHTY) {
                // 向下
                direction = 0;
            } else {
                // 右上
                direction = 5;
            }
            System.out.println("第四象限" + tan);
        } else if (endX > startX && endY < startY) {
            if (tan < TEN) {
                // 向右
                direction = 2;
            } else if (tan > EIGHTY) {
                // 向上
                direction = 3;
            } else {
                // 右上
                direction = 7;
            }
            System.out.println("第一象限" + tan);
        } else if (endX < startX && endY > startY) {
            if (tan < TEN) {
                // 向左
                direction = 1;
            } else if (tan > EIGHTY) {
                // 向下
                direction = 0;
            } else {
                // 左上
                direction = 4;
            }
            System.out.println("第三象限" + tan);
        } else {
            if (tan < TEN) {
                // 向左
                direction = 1;
            } else if (tan > EIGHTY) {
                // 向上
                direction = 3;
            } else {
                // 左上
                direction = 6;
            }
            System.out.println("第二象限" + tan);
        }
        return direction;
    }

}
