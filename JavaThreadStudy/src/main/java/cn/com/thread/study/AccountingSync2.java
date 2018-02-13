package cn.com.thread.study;

public class AccountingSync2 implements Runnable {


  static int i = 0;

  public synchronized void increase() {
    i++;
  }

  public void run() {
    for (int j = 0; j < 100000; j++) {
      increase();
    }
  }


  public static void main(String[] args) throws InterruptedException {
    AccountingSync2 accountingSync2 = new AccountingSync2();
    Thread t1 = new Thread(accountingSync2);
    Thread t2 = new Thread(accountingSync2);
    t1.start();
    t2.start();
    t1.join();
    t2.join();
    System.out.println(i);
  }
}
