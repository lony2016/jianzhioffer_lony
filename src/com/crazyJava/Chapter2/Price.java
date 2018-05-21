package com.crazyJava.Chapter2;

/**
 * Created by lony on 2018/5/2.
 * 疯狂java突破程序员基本功的16课
 */
public class Price {
    //类成员price
    final static Price INSTANCE = new Price(2.8);

    static double initPrice = 20;

    double currentPrice ;
     public Price(double discount)
     {
         currentPrice = initPrice - discount;
     }

    public static void main(String[] args) {
        System.out.println(Price.INSTANCE.currentPrice);//输出：-2.8
        //为什么输出的-2.8呢？
        /**
         * 因为对于类成员变量的初始化，每次jvm对一个java类只初始化一次，
         * 首先，先为类中的类成员变量分配内存；
         * 然后按照类成员变量和静态初始化块在类中出现的次序进行初始化；
         * 首先Price类为类成员变量NSTANCE实例和IinitPrice分配内存，此时还尚未对其初始化赋值，所以都是默认值null和0.0；
         * 然后按照顺寻，INSTANCE先出现，先对其初始化赋值，调用构造函数Price（2.8）,initPrice尚未完成初始化赋值20，而是默认值0.0，所以，currentPrice是-2.8；
         * INSTANCE赋值完成后，才进行initPrice的初始化赋值
         */


        Price p = new Price(2.8);
        System.out.println(p.currentPrice);//输出17.2
    }

}
