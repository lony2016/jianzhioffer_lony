package com.crazyJava.Chapter2;

/**
 * Created by lony on 2018/5/3.
 */
public class Derived extends Base {
    private float i = 1.22f;
    public Derived()
    {
        i = 1.222f;
    }
    public void display()
    {
        System.out.println(i);
    }

    public static void main(String[] args) {
        System.out.println(new Derived().i);
    }

}
