package com.test;

/**
 * Created by lony on 2018/4/27.
 * 测试代码块的执行顺序
 */
public class CodeBlockTest {
    public CodeBlockTest(int a)
    {
        System.out.println("有参数构造函数执行 a =" + a);
    }

    {
        System.out.println("构造代码块部分执行");
    }

    public static Test test = new Test("静态变量执行");

    static
    {
//        System.out.println(staticield);//静态变量
        System.out.println("静态代码块部分执行");
    }



    public static void main(String[] args) {
        int a = 5;
       CodeBlockTest test =  new CodeBlockTest(a);
    }
}
