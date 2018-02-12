package cn.com.thread.test;


public class TestThread2 implements Runnable {

    private Thread testThread1;

    public TestThread2(Thread testThread1) {
        this.testThread1 = testThread1;
    }

    public void run() {
        System.out.println("thread 2 begin");

        try {
            testThread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("thread 2 finish "+TestMain.list.size());


    }
}
