package com.crazyJava.Chapter2;

/**
 * Created by lony on 2018/5/3.
 */
public class Animal {
    private String desc;

    public Animal()
    {
//        this.desc = getDesc();
    }

    public String getDesc()
    {
        return "animal";
    }

    @Override
    public String toString() {
        return  this.getDesc();
    }

    public static void main(String[] args) {
        Animal animal = new Animal();
        System.out.println(animal);
    }
}
