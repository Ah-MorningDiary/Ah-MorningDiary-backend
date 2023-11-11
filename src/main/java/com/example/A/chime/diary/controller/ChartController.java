package com.example.A.chime.diary.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class ChartController {

    @GetMapping("chart/{month}")
    public ResponseEntity chart(@PathVariable("month") LocalDate month){



        return ResponseEntity.ok().body(null);
    }
}
