package com.liangjz.test.test.design.chain;

public class Demo {
    public static void main(String[] args) {
        AbstractLogger errorLog = new ErrorLogger();
        AbstractLogger infoLog = new InfoLogger();
        AbstractLogger warnLog = new WarnLogger();
        errorLog.nextLogger(infoLog).nextLogger(warnLog);
//        infoLog.nextLogger(warnLog);
        errorLog.startLogger();
    }
}
