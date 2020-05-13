package com.liangjz.test.test.design.chain;

public abstract class AbstractLogger {
    public AbstractLogger mNextLogger;

    abstract void logger();

    public void startLogger(){
        this.logger();
        if(mNextLogger != null){
            mNextLogger.startLogger();
        }
    }

    public AbstractLogger nextLogger(AbstractLogger logger){
        this.mNextLogger = logger;
        return logger;
    }
}
