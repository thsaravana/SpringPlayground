package com.playground.spring.coroutines

import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking

fun main(args: Array<String>) {
    runBlocking {
        val job = launch {
            perform()
        }
        print("1")
        job.join()
    }
}

private suspend fun perform() {
    delay(1000L)
    println("2")
}

