package com.playground.spring.coroutines

import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch

fun main(args: Array<String>) {
    launch {
        delay(1000L)
        println("2")
    }
    print("1")
    Thread.sleep(2000L)
}