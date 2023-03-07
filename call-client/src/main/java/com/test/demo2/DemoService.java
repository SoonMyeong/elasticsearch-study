package com.test.demo2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class DemoService {

    public CompletableFuture<Optional<String>> completableFuture() throws InterruptedException {
        Thread.sleep(900);
        log.debug("completablefuture");
        return CompletableFuture.completedFuture(Optional.of("task"));
    }

    public CompletableFuture<String> completableFutureAsync() throws InterruptedException {
        return CompletableFuture.supplyAsync(() -> "taskAsync")
                .thenApply(s -> s );
    }

    public String sync() throws InterruptedException {
        Thread.sleep(900);
        return "syncTask";
    }
}
