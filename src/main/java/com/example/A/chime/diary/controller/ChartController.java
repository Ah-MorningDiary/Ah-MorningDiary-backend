package com.example.A.chime.diary.controller;


import com.example.A.chime.diary.domain.Member;
import com.example.A.chime.diary.dto.responseDto.ChartResponse;
import com.example.A.chime.diary.service.ChartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class ChartController {
    private final ChartService chartService;

    @GetMapping("chart/{month}")
    public ResponseEntity chart(@PathVariable("month") LocalDate month, @RequestHeader("Authorization") String accessToken){
        Member member = memberService.findMember(accessToken);
        ChartResponse response = chartService.chart(member,month);

        return ResponseEntity.ok().body(response);
    }
}
