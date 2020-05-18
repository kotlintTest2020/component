package com.liangjz.test.view

import android.content.Intent

class Test {
    private fun test() {
        InnerClass(Any::class.java)
    }

    internal inner class InnerClass(z: Class<*>)
}
