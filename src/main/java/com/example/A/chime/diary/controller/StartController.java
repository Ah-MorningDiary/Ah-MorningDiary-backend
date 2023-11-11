package com.example.A.chime.diary.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class StartController {
    @GetMapping("start")
    public ResponseEntity start(){
        return ResponseEntity.ok().body(true);
    }
}
