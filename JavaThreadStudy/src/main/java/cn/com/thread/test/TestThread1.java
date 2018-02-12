package cn.com.thread.test;

import java.util.concurrent.TimeUnit;

public class TestThread1 implements Runnable {

    public void run() {

        System.out.println("thread 1 is begin");

        TestMain.list.remove(0);
        System.out.println("thread1 remve 1");

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        TestMain.list.remove(0);
        System.out.println("thread1 remve 2");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("thread1 finish");

    }

}
