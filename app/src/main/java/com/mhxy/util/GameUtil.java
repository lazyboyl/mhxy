package com.mhxy.util;

/**
 * @author linzf
 * @since 2019-01-17
 * 类描述： 游戏常用工具类
 */
public class GameUtil {


    public static int get8RoleDirection(int startX, int startY, int endX, int endY) {
        int direction = 0;
        double tan = Math.atan(Math.abs((endY - startY + 0.0) / (endX - startX + 0.0))) * 180 / Math.PI;
        if (endX > startX && endY > startY)
        {
            System.out.println("第一象限" + tan);
        }
        else if (endX > startX && endY < startY)
        {
            System.out.println("第二象限" + tan);
        }
        else if (endX < startX && endY > startY)
        {
            System.out.println("第三象限" + tan);
        }
        else
        {
            System.out.println("第四象限" + tan);
        }
        return direction;
    }


    public static void main(String [] args){
        get8RoleDirection(100,100,50,50);
    }

}
