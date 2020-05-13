package com.liangjz.test.test.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ThreadCallable implements Callable {
    @Override
    public Object call() throws Exception {
        int i = 0;
        while(i < 10){
            i++;
        }
        return i;
    }

    public static void main(String[] args) {
        FutureTask<Integer> f = new FutureTask<>(new ThreadCallable());
        new Thread(f).start();
        System.out.println("-------");
        try {
            int result = f.get();
            System.out.println("------->>>>");
            System.out.println(result);
        }catch (Exception e){

        }
    }
}
