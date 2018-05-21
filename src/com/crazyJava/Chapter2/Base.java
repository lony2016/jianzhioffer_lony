package com.crazyJava.Chapter2;

/**
 * Created by lony on 2018/5/3.
 */
public class Base {

    private float i = 1.2f;
    public Base()
    {
        System.out.println(this.i);
        this.display();
        System.out.println(this.getClass());
    }

    public void display()
    {
        System.out.println(i);
    }
}
