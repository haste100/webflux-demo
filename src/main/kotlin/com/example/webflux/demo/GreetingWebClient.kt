package com.example.webflux.demo

import org.springframework.http.MediaType
import org.springframework.web.reactive.function.client.ClientResponse
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono


class GreetingWebClient {
    private val client = WebClient.create("http://localhost:8080")

    fun getResult(): Mono<String> = client.get()
        .uri("/hello")
        .accept(MediaType.TEXT_PLAIN)
        .exchangeToMono { res: ClientResponse ->
            res.bodyToMono(
                String::class.java
            )
        }
}