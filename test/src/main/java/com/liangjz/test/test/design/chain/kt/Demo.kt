package com.liangjz.test.test.design.chain.kt

object Demo{
    @JvmStatic
    fun main(args: Array<String>) {
        var error = ErrorLogger()
        error.nextLogger(InfoLogger()).nextLogger(WarningLogger())
        error.startLogger()
    }
}