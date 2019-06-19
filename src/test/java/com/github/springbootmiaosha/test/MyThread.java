package com.github.springbootmiaosha.test;

public class MyThread extends Thread {

    public void test() {
        for (int i = 0; i < 10; i++) {
            System.out.println(123);
        }
    }

}
