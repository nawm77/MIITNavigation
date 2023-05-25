package com.example.miitnavigation.controller;

import com.example.miitnavigation.model.Time;
import com.example.miitnavigation.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("${api.base-path}")
public class TimeController {
    private final TimeService timeService;

    @Autowired
    public TimeController(TimeService timeService) {
        this.timeService = timeService;
    }

    //todo подумать о целесообразности создания POST эндпоинтов
//    @PostMapping("/times")
//    public CompletableFuture<ResponseEntity<Time>> createTime(@RequestBody Time time) {
//        return timeService.createTime(time)
//                .thenApply(ResponseEntity::ok)
//                .exceptionally(e -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
//    }

    @GetMapping("/times")
    public CompletableFuture<ResponseEntity<List<Time>>> getAllTimes() {
        return timeService.getAllTimes()
                .thenApply(ResponseEntity::ok)
                .exceptionally(e -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
    }

    @GetMapping("/times/{id}")
    public CompletableFuture<ResponseEntity<Time>> getTimeById(@PathVariable Long id) {
        return timeService.getTimeById(id)
                .thenApply(optionalTime -> optionalTime.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build()))
                .exceptionally(e -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
    }

    //todo подумать о целесообразности создания DELETE эндпоинтов
//    @DeleteMapping("/times/{id}")
//    public CompletableFuture<ResponseEntity<Object>> deleteTimeById(@PathVariable Long id) {
//        return timeService.deleteTimeById(id)
//                .thenApply(ignored -> ResponseEntity.noContent().build())
//                .exceptionally(e -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
//    }
}

