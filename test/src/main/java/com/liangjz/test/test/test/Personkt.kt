package com.liangjz.test.test.test

class Personkt(var name: String, var age : Int) {

}
object Demo{
    @JvmStatic
    fun main(args: Array<String>) {
       var p =  Personkt("test",18)
        print("${p.name},${p.age}")
    }
}