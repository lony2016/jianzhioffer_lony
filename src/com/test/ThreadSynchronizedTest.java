package com.test;

/**
 * Created by 12038 on 2018/7/31.
 */
public class ThreadSynchronizedTest {
    //两个方法都被synchronized修饰

    /**
     *
     * @param a
     */
    public static synchronized void main(String[] a){
        Thread t= new Thread(){
            public void run(){Sogou();}
        };
        /**
         * 静态同步函数的锁是该类的字节码文件.class，main线程获得锁
         * 调用run方法，获得锁，锁是ThreadSynchronizedTest.class；锁谁持有？
         * 当前线程（不可以说是main方法持有该锁），main方法中的run又调用Sogou()，也需要*.class锁，该main线程已持有此锁，
         * 当然可以直接调用Sougou()
         */
//        t.run();//输出：SogouHello
        /**
         *
         *首先调用start是开始了一个线程，那么现在程序中有了两个线程主线程main和线程T。
         *这就涉及本题第二个知识点了，函数使用的锁是this(即对象本身)，若函数被static修饰则锁为 类名.class.
         *那么题目中两个函数都是使用了同一个锁即ThreadSynchronizedTest.class，当执行t.start时，t线程准备调用Sogou方法，
         *但是锁对象已被主线程占用，故要等待主线程执行完System.out.print("Hello")后释放锁才可以执行自己的Sogou方法。
         *故此结果是HelloSogou
         **/
        t.start();//输出：HelloSogou
        System.out.print("Hello");
    }
    static synchronized void Sogou(){
        System.out.print("Sogou");
    }
}
