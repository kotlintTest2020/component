package com.liangjz.test.test.thread

import java.util.concurrent.*

object TestKt {
    @JvmStatic
    fun main(args: Array<String>) {
//        Thread1Kt().start()
//        Thread(ThreadRunablekt()).start()
//
//        var task  = FutureTask(ThreadCallableKt())
//        Thread(task).start()
//        var result = task.get()
//        print(result)

        var executor = ThreadPoolExecutor(5,10,60,TimeUnit.SECONDS,ArrayBlockingQueue<Runnable>(5))
        var i = 0
        while ( i < 24){
            i++
            executor.execute(MyThread(i))
            println("线程池的线程数:${executor.poolSize} ,"+
                    "线程池等待执行任务数：" + executor.queue.size +
                    "执行完毕任务数：" + executor.completedTaskCount)
        }
        executor.shutdown()
    }
    class MyThread(i:Int) : Thread(){
        var name = 0
        init {
            this.name = i
        }
        override fun run() {
            super.run()
            println("正在执行任务：$name" )
            Thread.sleep(2000)
            println("任务:$name，执行完毕")
        }
    }
}