package com.liangjz.test.test.thread

class Thread1Kt : Thread(){
    override fun run() {
        super.run()
        var i : Int = 0
        while(i < 10){
            i++
            println(i)
        }
    }
}