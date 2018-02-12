package cn.com.thread.test;

import java.util.ArrayList;
import java.util.List;

public class TestMain {

    public static List<String> list = new ArrayList<String>();

    public static void main(String[] args) {
        list.add("aaaaa");
        list.add("bbbbb");
        list.add("ccccc");

        TestThread1 tt1 = new TestThread1();


        Thread t1 = new Thread(tt1);
        t1.start();

        TestThread2 tt2 = new TestThread2(t1);
        new Thread(tt2).start();


    }
}
