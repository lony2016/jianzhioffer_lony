package com.test;

/**
 * Created by lony on 2018/3/29.
 */
public class ArrayTest {
    public static void main(String[] args) {
        String[] str  = new String[10];//动态初始化，需指定数组长度
//        String[] str3  = new String[];//动态初始化，需指定数组长度

        str[0] = "slwang";
        str[1] = "string";
        System.out.println("str_length="+ str.length);
//        System.out.println("str3_length=" + str3.length);
        System.out.println("str[0]=" + str[0] );
        String str2[] = new String[]{"1", "2", "3"};
        System.out.println("str2_length=" + str2.length);
//        String[] str4 = new String[4]{"9","8", "10", };//初始化时，不能同时动态初始化和静态初始化
//        System.out.println("str4_length=" + str4.length);

    }
}
