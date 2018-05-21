package com.testextends;

/**
 * Created by lony on 2018/3/28.
 */
public class FatherBase {

    static
    {
        System.out.println("FatherBase static{}");
    }

    public FatherBase()
    {
        System.out.println("FatherBase init");
    }
}
