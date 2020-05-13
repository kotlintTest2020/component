package com.liangjz.test.test.thread;

public class Thread1 extends Thread {
    @Override
    public void run() {
        int i = 0;
        while (i<10){
            System.out.println("2");
            i++;
        }
    }

    public static void main(String[] args) {
        new Thread1().start();
    }
}
