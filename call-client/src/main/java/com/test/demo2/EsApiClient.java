package com.test.demo2;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "es-api-client", url = "http://localhost:8080")
public interface EsApiClient {
    @GetMapping("/demo1")
    String getData();
}
