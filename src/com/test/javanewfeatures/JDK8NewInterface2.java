package com.test.javanewfeatures;

/**
 * Created by lony on 2018/4/20.
 */
public interface JDK8NewInterface2 {

    default void defaultMethod()
    {
        System.out.println("JDK8NewInterface2 jdk8中新接口中default方法");
    }

    static void staticMethod()
    {
        System.out.println("JDK8NewInterface jdk8中新接口中static方法");
    }
}
