package cn.com.thread.study;

/**
 * 代码范例测试线程的interrupt()和currentThread().isInterrupted()函数。
 * 用于优雅的使某个线程推出
 */

import java.util.concurrent.TimeUnit;

public class StopThreadSafe {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("Interruted!");
                        break;
                    }

                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        System.out.println("Interruted When sleep");
                        Thread.currentThread().interrupt();
                    }
                    Thread.yield();
                }
            }
        };

        t1.start();
        Thread.sleep(2000);
        t1.interrupt();
    }
}
