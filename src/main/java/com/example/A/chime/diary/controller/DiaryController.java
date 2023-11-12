package com.example.A.chime.diary.controller;


import com.example.A.chime.diary.domain.Diary;
import com.example.A.chime.diary.domain.Member;
import com.example.A.chime.diary.dto.requestDto.DiaryRequest;
import com.example.A.chime.diary.dto.responseDto.DiaryResponse;
import com.example.A.chime.diary.service.DiaryService;
import com.example.A.chime.diary.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("dairy")
@RequiredArgsConstructor
public class DiaryController {
    private final DiaryService diaryService;
    private final MemberService memberService;


    @PostMapping("/create")
    public ResponseEntity create(@RequestBody DiaryRequest request){
        Member member = new Member();
        DiaryResponse response = diaryService.create(request,member);

        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/read/{date}")
    public ResponseEntity read(@PathVariable("date") LocalDate date, @RequestHeader("Authorization") String accessToken){
        //Member member = new Member();
        Member member = memberService.findMember(accessToken);
        Diary response = diaryService.read(date,member);
        //System.out.println(response);
        return ResponseEntity.ok().body(response);
    }


    @PutMapping("/update/{date}")
    public ResponseEntity update(@PathVariable("date") LocalDate date,
                                 @RequestBody DiaryRequest request, @RequestHeader("Authorization") String accessToken){
        Member member = memberService.findMember(accessToken);
        DiaryResponse response = diaryService.update(request,date,member);

        return ResponseEntity.ok().body(response);
    }


    @DeleteMapping("/delete/{date}")
    public ResponseEntity delete(@PathVariable("date") LocalDate date, @RequestHeader("Authorization") String accessToken){
        Member member = memberService.findMember(accessToken);
        DiaryResponse response = diaryService.delete(date,member);

        return ResponseEntity.ok().body(response);
    }
}
