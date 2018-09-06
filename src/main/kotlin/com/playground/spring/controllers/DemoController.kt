package com.playground.spring.controllers

import com.github.jknack.handlebars.Handlebars
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

    @RequestMapping(value = ["/handlebars"], produces = ["application/json"])
    fun handlebars(): ResponseEntity<Response> {
        val handlebars = Handlebars()
        val template = handlebars.compileInline("Parsing {{this}} value")
        val parsedValue = template.apply("sample")
        return ResponseEntity(Response(parsedValue), HttpStatus.OK)
    }
}

data class Response(val key: String)