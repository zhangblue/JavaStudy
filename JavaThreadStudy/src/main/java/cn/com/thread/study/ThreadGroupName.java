package cn.com.thread.study;

import java.util.concurrent.TimeUnit;

/***
 * java线程组，可以将相同类型的线程放在线程组中
 */
public class ThreadGroupName implements Runnable {


  public void run() {
    String groupAndName =
        Thread.currentThread().getThreadGroup().getName() + "--" + Thread.currentThread().getName();
    while (true) {
      System.out.println("I am " + groupAndName);

      try {
        TimeUnit.SECONDS.sleep(3);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }


  public static void main(String[] args) {
    ThreadGroup threadGroup = new ThreadGroup("PringGroup");
    Thread t1 = new Thread(threadGroup, new ThreadGroupName(), "T1");
    Thread t2 = new Thread(threadGroup, new ThreadGroupName(), "T2");
    t1.start();
    t2.start();
    System.out.println(threadGroup.activeCount());
    threadGroup.list();
  }
}
