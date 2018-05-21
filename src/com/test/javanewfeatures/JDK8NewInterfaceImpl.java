package com.test.javanewfeatures;

/**
 * Created by lony on 2018/4/20.
 */
public class JDK8NewInterfaceImpl implements JDK8NewInterface, JDK8NewInterface2{

    //default方法重写
    /**
     * 1.接口中default方法不需要重写，当然你也可以根据需要是否重写
     * 2.但当实现的两个接口中有相同的Jdefault方法时，就需要重写这个方法;
     * 3.而接口中的静态方法却不用，因为他们是通过类直接访问而不是对象
    */
     public void defaultMethod()
    {
        System.out.println("JDK8NewInterface2 jdk8中新接口中default方法");
    }


    public static void main(String[] args) {
         //1.接口中静态方法调用方式同一般的类
        JDK8NewInterface.staticMethod();
        JDK8NewInterface2.staticMethod();
    }

}
