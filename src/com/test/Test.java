package com.test;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

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

class DelListTest
{
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("b");
        list.add("c");
        list.add("b");
        list.add("e");
//        for (int i=0; i<list.size(); ++i)
//        {
//            if("b".equals(list.get(i)))
//            {
//                list.remove(i);
//                --i;
//            }
//        }
        int size = list.size();
        for (int i=size-1; i>=0; --i)
        {
            if("b".equals(list.get(i)))
            {
                list.remove(i);
            }
        }
//        Iterator<String> listItr = list.iterator();
//        while(listItr.hasNext())
//        {
//            String str = listItr.next();
//            if("b".equals(str))
//            {
//                listItr.remove();//正确执行
//                /**
//                 * 通过代码我们发现 Itr 是 ArrayList 中定义的一个私有内部类，
//                 * 在 next、remove方法中都会调用 checkForComodification 方法，
//                 * 该方法的作用是判断 modCount != expectedModCount是否相等，
//                 * 如果不相等则抛出ConcurrentModificationException异常。
//                 * 每次正常执行 remove 方法后，都会对执行expectedModCount = modCount赋值，
//                 * 保证两个值相等，那么问题基本上已经清晰了，在 foreach 循环中执行 list.remove(item);，
//                 * 对 list 对象的 modCount 值进行了修改，而 list 对象的迭代器的 expectedModCount 值未进行修改，
//                 * 因此抛出了ConcurrentModificationException异常。
//                 */
////                list.remove(str);//
//            }
//        }

        //
        final CopyOnWriteArrayList<String> cowList = new CopyOnWriteArrayList<String>(list);
        for (String item : cowList) {
            if ("b".equals(item)) {
                cowList.remove(item);
            }
        }

        for (int i=0; i<list.size(); ++i)
        {
            System.out.println(list.get(i));
        }




    }
}

//测试类中静态变量和静态块的执行顺序：按照在代码中的出现的先后顺序执行
class Main2
{


    static {
        a = 6;
    }

    static int a = 100;
    static{
        a /= 2;
    }
    public static void helper (String s1, String s2)throws IllegalArgumentException
    {



    }


    public static void main(String[] args) {
        System.out.println(a);
    }
}

//测试锁
class DeadLockDemo2 {

    public static void main(String[] args) {
        // 线程a
        Thread td1 = new Thread(new Runnable() {
            public void run() {
                DeadLockDemo2.method1();
            }
        });
        // 线程b
        Thread td2 = new Thread(new Runnable() {
            public void run() {
                DeadLockDemo2.method2();
            }
        });

        td2.start();
        td1.start();

    }

    public static void method1() {
        synchronized (String.class) {//类锁
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程a尝试获取integer.class");
            synchronized (Integer.class) {
                System.out.println("线程a获取到integer.class");
            }

        }
    }

    public static void method2() {
        // 不再获取线程a需要的Integer.class锁。
        synchronized (String.class) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程b尝试获取Integer.class");
            synchronized (Integer.class) {
                System.out.println("线程b获取到Integer.class");
            }

        }
    }

}


