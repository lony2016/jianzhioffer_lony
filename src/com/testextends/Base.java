package com.testextends;

/**
 * Created by lony on 2018/3/28.
 */
public class Base extends FatherBase{

//    Base base = new Base();

    static
    {
        System.out.println("Base static{}");
    }

    public Base()
    {
        System.out.println("Base init");
    }

}
