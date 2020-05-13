package com.liangjz.test.test.design.single;

/*
* 懒汉模式的单例（线程安全）
* DCL双重检测锁
* */
public class SingleTon3 {
    private static SingleTon3 mStance;
    private SingleTon3(){

    }
    public static SingleTon3 getInstance(){
        if(mStance == null){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (SingleTon3.class){
                if(mStance == null){
                    mStance = new SingleTon3();
                }
            }
        }
        return mStance;
    }


}
