package com.liangjz.test.test.design.single;
/*
* 懒汉模式的单例（线程不安全）
* */
public class SingleTon {
    private static SingleTon mStance;
    private SingleTon(){

    }
    public static SingleTon getInstance(){
        if(mStance == null){
            try {
//              模拟在创建对象时，初始化一些动作
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mStance = new SingleTon();
        }
        return mStance;
    }
}
