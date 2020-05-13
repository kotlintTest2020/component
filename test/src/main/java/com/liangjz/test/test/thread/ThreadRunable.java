package com.liangjz.test.test.thread;

public class ThreadRunable implements Runnable {

    @Override
    public void run() {
        int i = 0;
        while(i < 10){
            System.out.println(i);
            i++;
        }
    }

    public static void main(String[] args) {
        new Thread(new ThreadRunable()).start();
    }
}
