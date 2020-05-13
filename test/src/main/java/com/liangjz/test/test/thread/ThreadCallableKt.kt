package com.liangjz.test.test.thread

import java.util.concurrent.Callable

class ThreadCallableKt : Callable<String>{
    override fun call(): String {
        Thread.sleep(3000)
        return "callback"
    }

}