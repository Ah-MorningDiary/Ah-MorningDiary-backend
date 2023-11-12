package com.example.A.chime.diary.controller;


import com.example.A.chime.diary.domain.Member;
import com.example.A.chime.diary.dto.responseDto.ChartResponse;
import com.example.A.chime.diary.service.ChartService;
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
    private final ChartService chartService;

    @GetMapping("chart/{month}")
    public ResponseEntity chart(@PathVariable("month") int month){
        Member member = new Member();
        ChartResponse response = chartService.chart(member,month);



        return ResponseEntity.ok().body(response);
    }
}
