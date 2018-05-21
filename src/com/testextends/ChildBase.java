package com.testextends;

/**
 * Created by lony on 2018/3/28.
 */
public class ChildBase  extends Base{
    ChildBase cBase = new ChildBase();//slwang note:编译器可以通过，但new ChildBase()时又会执行一遍此句话，这是一个迭代的死缓坏

    static
    {
        System.out.println("ChildBase static{}");
    }

    public ChildBase()
    {
        System.out.println("ChildBase init");
    }

    public static void main(String[] args) {
        ChildBase cBase = new ChildBase();
    }
}
