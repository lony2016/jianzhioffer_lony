package com.jianzhioffer;

import jdk.nashorn.internal.ir.CatchNode;

/**
 * Created by lony on 2018/4/2.
 */
public class Chapter1 {
    /**
     * P12: 把一个字符串转换成证书
     */
    public static int StrToInt(String str)
    {
        int num = 0;
//        num = Integer.parseInt(str);//这种显然没有考虑一些边界值的情况
//        num = Integer.valueOf(str).intValue();//
        //解法一
        try {
            num =  Integer.parseInt(str);
            return num;
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return num;
    }

    public static void main(String[] args) {
        String str = "1+";
        int num = Chapter1.StrToInt(str);
        System.out.println(num);
    }
}
