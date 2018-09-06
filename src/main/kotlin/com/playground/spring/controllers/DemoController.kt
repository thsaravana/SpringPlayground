package com.playground.spring.controllers

import com.github.jknack.handlebars.Handlebars
import com.github.jknack.handlebars.io.ClassPathTemplateLoader
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class DemoController {

    @RequestMapping(value = ["/hello"], produces = ["application/json"])
    fun sayHelloWorld(): ResponseEntity<Response> {
        println("Saying Hello")
        return ResponseEntity(Response("Hello World"), HttpStatus.OK)
    }

    @RequestMapping(value = ["/handlebars/inline"], produces = ["application/json"])
    fun inlineHandlebars(): ResponseEntity<Response> {
        val handlebars = Handlebars()
        val template = handlebars.compileInline("Parsing {{this}} value")
        val parsedValue = template.apply("sample")
        return ResponseEntity(Response(parsedValue), HttpStatus.OK)
    }

    @RequestMapping(value = ["/handlebars"], produces = ["application/json"])
    fun handlebars(): ResponseEntity<Response> {
        val loader = ClassPathTemplateLoader()
        loader.prefix = "/templates"
        val handlebars = Handlebars(loader)
        val template = handlebars.compile("expressions")
        val parsedValue = template.apply(Sample("a", "b"))
        return ResponseEntity(Response(parsedValue), HttpStatus.OK)
    }
}

data class Response(val key: String)

data class Sample(val a: String, val b: String)