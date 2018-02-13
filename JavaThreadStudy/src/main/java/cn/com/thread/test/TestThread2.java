package cn.com.thread.test;


import java.util.concurrent.TimeUnit;

public class TestThread2 implements Runnable {


  public void run() {
    try {
      TimeUnit.SECONDS.sleep(3);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    TestMain.i = 100;

    System.out.println("thread2 finish");
  }
}
