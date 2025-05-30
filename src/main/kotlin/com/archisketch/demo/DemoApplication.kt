package com.archisketch.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
    runApplication<DemoApplication>(*args)
    println("Welcome, Kotlin")
}

@RestController
class HealthCheckController {
    @GetMapping("/health")
    fun health(): String = "1"
}
