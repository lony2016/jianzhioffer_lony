package com.test.javanewfeatures;

/**
 * Created by lony on 2018/4/20.
 */
public interface JDK8NewInterface {
    public static final int NUM = 5;
    //接口中变量默认是static final类型
    int NUM2 = 6;

//    public abstract void func();
//    //方法默认是public abstract
//    void func2();

    //--------------------jdk8以前，接口中只有上述两种情况：只有常量和抽象方法--------------------

    //---------------------------jdk8以后，接口中可以有静态方法和默认方法---------------------------

    //1.static function
    static void staticMethod()
    {
        System.out.println("JDK8NewInterface jdk8中新接口中static方法");
    }

    //2.default function
    default void defaultMethod()
    {
        System.out.println("JDK8NewInterface jdk8中新接口中default方法");
    }

    //3.接口不能提供对Object类的任何方法的默认实现。
//   default String toString() {};//编译不通过
//    default int hashCode() {};//编译不通过

}
