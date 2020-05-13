package com.liangjz.test.test.thread

class ThreadRunablekt : Runnable{
    override fun run() {
        var i : Int = 0
        while(i < 10){
            i++
            println(i)
        }
    }

}