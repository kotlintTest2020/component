package com.liangjz.test.test.design.single;
/*
* 懒汉模式的单例
* 使用静态内部类的形式
* */
public class SingleTon4 {

    private SingleTon4(){

    }
    private static class InnerClass{
         private static SingleTon4 mStance = new SingleTon4();
         public static SingleTon4 getInstance(){
             try {
                 Thread.sleep(300);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
             return mStance;
         }
    }

    public static SingleTon4 getInstance(){
        return InnerClass.getInstance();
    }
}
