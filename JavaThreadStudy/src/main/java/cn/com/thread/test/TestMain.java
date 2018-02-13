package cn.com.thread.test;

import java.util.concurrent.locks.ReentrantLock;

public class TestMain {

  public static ReentrantLock lock = new ReentrantLock();
  public static int i = 0;

  public static void main(String[] args) throws InterruptedException {
    Thread t1 = new Thread(new TestThread1());
    Thread t2 = new Thread(new TestThread2());
    t1.start();
    t2.start();
    t1.join();
    t2.join();

    System.out.println("finally i="+i);


  }
}
