package com.test;


import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by lony on 2017/11/6.
 */
public class Test {
    static boolean classStatic = false;
    public boolean noStatic;

    public Test(String str)
    {
        System.out.println(str);
    }
    public Test()
    {
        b = 11;
    }

    //测试代码块中变量定义在后的情况

    {
        System.out.println("执行非静态代码块中部分");
        b = 10;//1
        int c = 11;//此时c变量只是在代码块中能识别
    }
    int b = 5;//1
    //c= 12;//报错
    int c = 12;//编译通过
    //end


    public static boolean getClassStatic() {
        return classStatic;
    }

    public static void setClassStatic(boolean classStatic) {
        Test.classStatic = classStatic;
    }

    public boolean getNoStatic() {
        return noStatic;
    }

    public void setNoStatic(boolean noStatic) {
        this.noStatic = noStatic;
    }

    public void test()
    {
        int a=1,b=2,max; //max只是负责接收表达式的值，不需要初始化
        max=a>b?2:1;//相当于在此处初始化
        int c;
        c = 1;//这样也可以
    }


    private static void test(int a)
    {
        System.out.println("test(int a)" + a);
    }
    public static void test(char c)
    {
        System.out.println("test(char c)" + c);
    }

    //测试异常
    public static String output = "";
    public static void foo(int i)
    {

        try {
            if( i == 1)
            {
                throw new Exception();
            }
        }
        catch (Exception e)
        {
            output += "2";
            return;//return感觉是在finally之后执行
        }finally {
            output += "3";
        }
        output +=4;
    }
    public static void main(String[] args) {
        foo(0);
        foo(1);
        System.out.println(output);
        ConcurrentHashMap map = null;

//        X te = new X();
        System.out.println(Color.RED.getCode());
        System.out.println(Color.BLue.getCode());
        System.out.println(Color.RED == Color.BLue);

    }
}

enum Color
{
    RED(1), BLue(2);

    private int code;
    Color(int code){
        this.code=code;
    }
    public int getCode(){
        return code;
    }
}

class Father
{
    private Inner inner;
    public class Inner
    {
        public Inner()
        {
            System.out.println("father's Inner");
        }
    }
    public Father()
    {
        System.out.println("father's constructor");
        inner = new Inner();
    }
}

class Son extends Father
{
    private Inner inner;
    public class Inner
    {
        public Inner()
        {
            System.out.println("Son's Inner");
        }
    }
    public Son()
    {
        System.out.println("Son's constructor");
    }

    public static void main(String[] args) {
        new Son();
    }
}
