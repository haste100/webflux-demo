package com.example.webflux.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Application

fun main(args: Array<String>) {
	runApplication<Application>(*args)

	val result = GreetingWebClient().getResult().block()
	println(">> result = $result")
}
