package com.example.demok8s.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.TimeUnit;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello from Kubernetes! - " + System.currentTimeMillis();
    }

    // Endpoint để test tải - giả lập CPU cao
    @GetMapping("/load")
    public String load() throws InterruptedException {
        long start = System.currentTimeMillis();
        // Tạo CPU load trong khoảng 300-500ms
        while (System.currentTimeMillis() - start < 400) {
            Math.pow(Math.random(), Math.random());
        }
        return "Heavy load completed!";
    }
}