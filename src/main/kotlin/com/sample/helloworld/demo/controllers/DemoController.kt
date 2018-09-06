package com.sample.helloworld.demo.controllers

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class DemoController {

    @RequestMapping(value = ["/hello"], produces = ["application/json"])
    fun sayHelloWorld(): ResponseEntity<Response> {
        println("Saying Hello")
        return ResponseEntity(Response("Hello World"), HttpStatus.OK)
    }
}

data class Response(val key: String)