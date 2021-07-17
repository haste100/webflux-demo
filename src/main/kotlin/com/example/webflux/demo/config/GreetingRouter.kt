package com.example.webflux.demo.config

import com.example.webflux.demo.handler.GreetingHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.RequestPredicates
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.RouterFunctions
import org.springframework.web.reactive.function.server.ServerResponse


@Configuration
class GreetingRouter {
    @Bean
    fun route(greetingHandler: GreetingHandler): RouterFunction<ServerResponse> {
        return RouterFunctions
            .route()
            .GET("/hello", RequestPredicates.accept(MediaType.TEXT_PLAIN), greetingHandler::hello)
//            .GET("/messages/{id}", RequestPredicates.accept(MediaType.APPLICATION_JSON), messageHandler::getMessageById)
            .build()
    }
}