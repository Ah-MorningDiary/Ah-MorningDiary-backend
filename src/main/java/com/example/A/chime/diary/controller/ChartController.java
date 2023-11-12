package com.example.A.chime.diary.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class ChartController {

    @GetMapping("chart/{month}")
    public ResponseEntity chart(@PathVariable("month") LocalDate month, @RequestHeader("Authorization") String accessToken){



        return ResponseEntity.ok().body(null);
    }
}
