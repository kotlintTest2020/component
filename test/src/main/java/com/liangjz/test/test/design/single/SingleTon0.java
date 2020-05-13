package com.liangjz.test.test.design.single;
/*
* 饿汉模式的单例
* 线程安全
* */
public class SingleTon0 {
    private static SingleTon0 mStance = new SingleTon0();
    private SingleTon0(){

    }
    public static SingleTon0 getInstance()
    {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return mStance;
    }
}
