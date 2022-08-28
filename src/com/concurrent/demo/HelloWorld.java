package com.concurrent.demo;

import java.util.concurrent.TimeUnit;

public class HelloWorld {
    public static void main(String[] args) throws InterruptedException {
        /*
        Thread myThread = new Thread(
                () -> System.out.println("Hello from new thread")
        );*/
        Thread myThread = new Thread() {
            @Override
            public void run() {
                System.out.println("Hello from new thread");
            }
        };
        myThread.start();
        Thread.yield();
       // TimeUnit.MILLISECONDS.sleep(1);
        System.out.println("Hello from main thread");
        myThread.join();
    }
}
