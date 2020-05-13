package com.liangjz.test.test.sort

object Bubulsortkt {

    @JvmStatic
    fun main(args : Array<String>){
        var strs : Array<Int> = arrayOf(23,1,2,43,231,4,3443,22)
        for (item in sort(strs))
            print("$item,")
    }

    fun sort(strs : Array<Int>) : Array<Int>{
        for(i in strs.indices){
           for(j in 0 until strs.size - 1 - i){
                if(strs[j] > strs[j+1]){
                   var tmp : Int = strs[j]
                    strs[j] = strs[j+1]
                    strs[j+1] = tmp
                }
           }
        }
        return strs
    }

}