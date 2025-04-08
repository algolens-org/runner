package com.algo.algolensrunner.global.base;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;

@RestController
public class BaseController {


    // 기본 경로 처리 (Root "/")
    @GetMapping("/")
    public ResponseEntity<String> root() {
        return ResponseEntity.ok("Algolens runner Service API: Success!"
        + LocalTime.now());
    }
}