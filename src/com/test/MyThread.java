package com.test;

/**
 * Created by lony on 2017/11/21.
 */
public class MyThread implements Runnable{
    private int tickets = 3000;
    @Override
    public void run() {
        for (int i = 0; i < 3000; ++i)
        {
            synchronized (this)
            {
                if(tickets > 0)
                {
                    System.out.println(Thread.currentThread().getName() + "正在卖票" + this.tickets-- );
                }
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
//        MyThread myThread1 = new MyThread();
//        MyThread myThread2 = new MyThread();
//        myThread1.start();
//        myThread2.start();
        Runnable runn = new MyThread();
        Thread th1 = new Thread(runn, "1号窗口");
        Thread th2 = new Thread(runn, "2号窗口");
        Thread th3 = new Thread(runn, "3号窗口");

        th1.start();
        th2.start();
        th3.start();

    }
}
