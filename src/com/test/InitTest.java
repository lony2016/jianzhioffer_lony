package com.test;

/**
 * Created by lony on 2018/7/2.
 * 当访问一个Java类或接口中的静态域的时候，只有真正声明这个域的类或接口才会被初始化
 */
 class BB {
    static int value = 100;
    static {
        System.out.println("Class B is initialized."); //输出
    }
}
class AA extends BB {
    static {
        System.out.println("Class A is initialized."); //不会输出
    }
}
   public class InitTest {
    public static void main(String[] args) {
        System.out.println(AA.value); //输出100
    }
}
