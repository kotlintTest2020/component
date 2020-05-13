package com.liangjz.test.test.design.single


fun main(args:Array<String>){
    for(i in 1..100){
        Thread(){
            run {
                println(SingleTonKt.instance.hashCode())
            }
        }.start()
    }
}
