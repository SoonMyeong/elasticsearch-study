package com.example.demo.handler;

import com.example.demo.domain.Ecommerce;
import com.example.demo.service.SearchTestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class DemoHandler {
    private final SearchTestService searchTestService;

    public Mono<ServerResponse> findData(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .body(searchTestService.search().collectList()
                        , Ecommerce.class);
    }

}
