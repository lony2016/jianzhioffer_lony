package com.test;

/**
 * Created by lony on 2018/4/28.
 */
class X {
    public void show(Y y){
        System.out.println("x and y");
    }

    public void show(){
        System.out.println("only x");
    }
}

class Y extends X {
    public void show(Y y){
        System.out.println("y and y");
    }
    public void show(int i){

    }

    public static void main(String[] args) {
        X x = new Y();
        x.show(new Y());
        x.show();

        //X是引用变量类型，它决定哪些方法可以调用,Y是被引用对象的类型，它决定了调用谁的方法：调用y的方法。；
        // show（）和show(Y y)可以调用，而show(int i)不可以调用。
//        x.show(0);//编译不通过，这是Y子类独有的方法，x是父类X的引用
    }
}
