package com.liangjz.test.test.design.single

class SingleTonKt private constructor(){
    companion object{
        val instance : SingleTonKt =  SingleTonKt()
//        val instance : SingleTonKt by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
//            SingleTonKt()
//        }
    }
}