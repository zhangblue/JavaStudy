package cn.com.thread.test;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SearchTask implements Runnable {

  private Result result;

  public SearchTask(Result result) {
    this.result = result;
  }

  public void run() {
    String name = Thread.currentThread().getName();
    System.out.printf("Thread %s: Start\n", name);

    try {
      doTask();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    result.setName(name);
    
  }

  private void doTask() throws InterruptedException {
    Random random = new Random(new Date().getTime());
    int value = (int) (random.nextDouble()*100);
    System.out.printf("Thread %s: %d\n",Thread.currentThread().getName(),value);
    TimeUnit.SECONDS.sleep(value);
  }
}
