package com.test.demo2;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DemoController {
    private final EsApiClient esApiClient;

    @GetMapping("/test")
    public String test() throws InterruptedException {
        Thread.sleep(500);
        return esApiClient.getData();
    }
}
