package cn.com.thread.test;

import java.util.concurrent.TimeUnit;

public class Main {

  public static void main(String[] args) {
    ThreadGroup threadGroup = new ThreadGroup("Searcher");
    Result result = new Result();
    SearchTask searchTask = new SearchTask(result);
    for (int i = 0; i < 5; i++) {
      Thread thread = new Thread(threadGroup, searchTask);
      thread.start();
      try {
        TimeUnit.SECONDS.sleep(1);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    System.out.printf("Number of Threads: %d\n", threadGroup.activeCount());
    System.out.printf("Infomation about the Thread Group\n");
    threadGroup.list();

    Thread[] threads = new Thread[threadGroup.activeCount()];
    threadGroup.enumerate(threads);
    for (int i = 0; i < threadGroup.activeCount(); i++) {
      System.out.printf("Thread1111 %s\n", threads[i].getName(), threads[i].getState());
    }
    waitFinish(threadGroup);

    threadGroup.interrupt();
  }

  private static void waitFinish(ThreadGroup threadGroup) {
    while (threadGroup.activeCount()>5){
      try {

        TimeUnit.SECONDS.sleep(1);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
