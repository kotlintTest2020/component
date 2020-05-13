package com.liangjz.test.test.design.single;
/*
 * 懒汉模式的单例（线程安全）
 * 但是效率不高，90%情况下不需要同步
 * */
public class SingleTon2 {
    private static SingleTon2 mStance;
    private SingleTon2(){

    }
    public static synchronized SingleTon2 getInstance(){
        if(mStance == null){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mStance = new SingleTon2();
        }
        return mStance;
    }
}
