package com.example.demo.router;

import com.example.demo.handler.DemoHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class DemoRouter {

    @Bean
    RouterFunction<ServerResponse> routes(DemoHandler demoHandler) {
        return RouterFunctions.route()
                .GET("/demo1", demoHandler::findData)
                .build();
    }
}
