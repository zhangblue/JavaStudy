package cn.com.thread.test;

import java.util.concurrent.TimeUnit;

public class TestThread1 implements Runnable {

  public void run() {
    TestMain.lock.lock();
    TestMain.i = 3;
    try {
      TimeUnit.SECONDS.sleep(10);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    TestMain.lock.unlock();
    System.out.println("thread1 finish");
  }

}
