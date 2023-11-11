package com.example.A.chime.diary.controller;

import com.example.A.chime.diary.domain.Member;
import com.example.A.chime.diary.repository.ScoreRepository;
import com.example.A.chime.diary.service.StartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class StartController {
    private final StartService startService;

    @GetMapping("start")
    public ResponseEntity start(){
        Member member = new Member();
        boolean result = startService.start(member);
        return ResponseEntity.ok().body(result);
    }
}
