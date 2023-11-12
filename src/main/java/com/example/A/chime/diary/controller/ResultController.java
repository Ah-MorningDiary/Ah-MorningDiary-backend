package com.example.A.chime.diary.controller;

import com.example.A.chime.diary.domain.Member;
import com.example.A.chime.diary.dto.requestDto.SubmittedAnswerRequest;
import com.example.A.chime.diary.service.MemberService;
import com.example.A.chime.diary.service.ScoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("quiz")
@RequiredArgsConstructor
public class ResultController {
    private final ScoreService scoreService;
    private final MemberService memberService;

    @PostMapping("submit")
    public ResponseEntity result(@RequestBody SubmittedAnswerRequest request, @RequestHeader("Authorization") String accessToken){
        Member member = memberService.findMember(accessToken);

        String response = scoreService.submit(request,member);
        return ResponseEntity.ok().body(response);
    }
}