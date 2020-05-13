package com.liangjz.test.test.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPool implements Runnable{
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,10,60, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(5));
        int i = 0;
        while(i < 14){
            i++;
            executor.execute(new ThreadPool(i));
            System.out.println("线程池的线程数:"+executor.getPoolSize()+
                    "线程池等待执行任务数："+executor.getQueue().size()+
                    "执行完毕任务数："+executor.getCompletedTaskCount());
        }
        executor.shutdown();
    }

    private int i;
    public ThreadPool(int i){
        this.i = i;
    }
    @Override
    public void run() {
        System.out.println("正在执行任务："+i);
        try{
            Thread.sleep(4000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("任务："+i + "执行完毕");
    }
}
