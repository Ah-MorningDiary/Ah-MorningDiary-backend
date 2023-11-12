package com.example.A.chime.diary.controller;

import com.example.A.chime.diary.domain.Member;
import com.example.A.chime.diary.dto.requestDto.SubmittedAnswerRequest;
import com.example.A.chime.diary.dto.responseDto.ResultResponse;
import com.example.A.chime.diary.service.ResultService;
import com.example.A.chime.diary.service.ScoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("quiz")
@RequiredArgsConstructor
public class ResultController {
    private final ScoreService scoreService;
    private final ResultService resultService;

    @PostMapping("submit")
    public ResponseEntity submit(@RequestBody SubmittedAnswerRequest request){
        Member member = new Member();

        String response = scoreService.submit(request,member);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("result")
    public ResponseEntity result(){
        Member member = new Member();
        LocalDate date = LocalDate.now();
        ResultResponse response = resultService.result(member,date);



        return ResponseEntity.ok().body(response);
    }
}