package com.liangjz.test.test.design.chain.kt

abstract class AbstractLogger{
    var mNextLogger : AbstractLogger? = null

    abstract fun logger()

    fun startLogger(){
        this.logger()
        if(mNextLogger != null){
            mNextLogger!!.startLogger()
        }
    }

    fun nextLogger(next : AbstractLogger) : AbstractLogger{
        this.mNextLogger = next
        return next
    }

}