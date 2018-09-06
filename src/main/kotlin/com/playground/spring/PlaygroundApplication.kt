@file:JvmName("PlaygroundApplication")

package com.playground.spring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.io.IOException

@SpringBootApplication
class PlaygroundApplication {

    companion object {
        @Throws(IOException::class)
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<PlaygroundApplication>(*args)
        }
    }
}
