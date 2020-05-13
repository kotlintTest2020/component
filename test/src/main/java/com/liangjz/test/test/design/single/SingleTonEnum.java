package com.liangjz.test.test.design.single;

public enum  SingleTonEnum {
    MSTANCE;
    public static SingleTonEnum getInstance(){
        return MSTANCE;
    }

    public String getStr(){
        return "d";
    }
}
