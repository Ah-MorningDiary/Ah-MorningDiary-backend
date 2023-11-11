package com.example.A.chime.diary.controller;

import com.example.A.chime.diary.domain.Member;
import com.example.A.chime.diary.dto.requestDto.SubmittedAnswerRequest;
import com.example.A.chime.diary.service.AnswerService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("quiz")
@RequiredArgsConstructor
public class ResultController {
    private final AnswerService answerService;

    @PostMapping("submit")
    public ResponseEntity result(@RequestBody SubmittedAnswerRequest request){
        Member member = new Member();

        String response = answerService.submit(request,member);
        return ResponseEntity.ok().body(response);
    }
}