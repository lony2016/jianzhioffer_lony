package com.string;

/**
 * Created by lony on 2018/5/7.
 */
public class StringTest {
    public static void main(String[] args) {
//        String s1 = "long";
//        String s2 = "long";
//        String s3 = new String("long");
//        String s4 = "long";
//
//        System.out.println(s1 == s2);
//        System.out.println(s1 == s3);
//        System.out.println(s1 == s4);
//        System.out.println(s3 == s4);

//        String s = new String("abc");
//        String s1 = "abc";
//        String s2 = new String("abc");
//        System.out.println(s == s1.intern());
//        System.out.println(s == s2.intern());
//        System.out.println(s1 == s2.intern());

        int[] arr = null;
        if(arr == null)
            System.out.println("arr=null+"+arr+"+hhh");
        if(arr.length == 0)
            System.out.println("arr.length=0" + arr);

        //1.别人面试出现的问题
        String a = "上海";
        char[] b = {'上', '海'};
//        if(a == b)
//            System.out.println("a == b");//报错，字符型没办法跟字节型进行比较
    }
}
