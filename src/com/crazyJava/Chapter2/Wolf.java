package com.crazyJava.Chapter2;

/**
 * Created by lony on 2018/5/3.
 */
public class Wolf extends Animal{

    private String name;
    private double weight;

    public Wolf(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String getDesc() {
        return "Wolf[name = "+ name +", weight = "+ weight +"]";
    }

    public static void main(String[] args) {
        Wolf wolf = new Wolf("灰太狼",20.6);
        System.out.println(wolf);


        String str1 = "abc";
        String str2 = new String("def");
        String str3 = "abc";
        String str4 = str2.intern();
        String str5 = "def";
        System.out.println(str1 == str3);//true
        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());
        System.out.println(str3.hashCode());
        System.out.println(str4.hashCode());
        System.out.println(str2 == str4);//false
        System.out.println(str4 == str5);//true

    }
}
