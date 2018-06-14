package com.test;

/**
 * Created by lony on 2018/3/29.
 */

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ArrayTest {


    int i;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public static void main(String[] args) {
//        String[] str  = new String[10];//动态初始化，需指定数组长度
////        String[] str3  = new String[];//动态初始化，需指定数组长度
//
//        str[0] = "slwang";
//        str[1] = "string";
//        System.out.println("str_length="+ str.length);
////        System.out.println("str3_length=" + str3.length);
//        System.out.println("str[0]=" + str[0] );
//        String str2[] = new String[]{"1", "2", "3"};
//        System.out.println("str2_length=" + str2.length);
//        String[] str4 = new String[4]{"9","8", "10", };//初始化时，不能同时动态初始化和静态初始化
//        System.out.println("str4_length=" + str4.length);
//        ArrayTest te1 = new ArrayTest();
//        te1.setI(1);
//        ArrayTest te2 = te1;
//        te2.setI(2);
//        System.out.println(te1.getI());
//        int i = -8, j = -11;
//        System.out.println(Integer.highestOneBit(i));
//        System.out.println(Integer.highestOneBit(j));
//        System.out.println(-33 >> 5);
//        System.out.println(-33 >>> 1);
//        System.out.println(-23 >>> 1);
//        System.out.println(-2 >>> 1);
//        System.out.println(-1 >>> 1);

        ArrayTest[] te1 = new ArrayTest[1];
        System.out.println(te1[0].i);
        ArrayTest[] te2 = new ArrayTest[2];
        System.out.println(te1);
        System.out.println(te2);
//        boolean hash = null == te;



    }
}
