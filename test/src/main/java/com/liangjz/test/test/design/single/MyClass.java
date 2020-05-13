package com.liangjz.test.test.design.single;

public class MyClass {
    public static void main(String[] args) {
        for(int i = 0; i < 10; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(SingleTonEnum.MSTANCE.getStr());
                }
            }).start();
        }
    }
}
