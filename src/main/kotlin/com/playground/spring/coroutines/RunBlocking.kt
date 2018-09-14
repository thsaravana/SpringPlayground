package com.playground.spring.coroutines

import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking

fun main(args: Array<String>) {
    runBlocking {
        val launch = launch {
            delay(1000L)
            println("2")
        }
        print("1")
        launch.join()
    }
}