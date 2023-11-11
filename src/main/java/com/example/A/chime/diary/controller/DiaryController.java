package com.example.A.chime.diary.controller;


import com.example.A.chime.diary.domain.Diary;
import com.example.A.chime.diary.domain.Member;
import com.example.A.chime.diary.dto.requestDto.DiaryRequest;
import com.example.A.chime.diary.dto.responseDto.DiaryResponse;
import com.example.A.chime.diary.service.DiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("dairy")
@RequiredArgsConstructor
public class DiaryController {
    private final DiaryService diaryService;


    @PostMapping("/create")
    public ResponseEntity create(@RequestBody DiaryRequest request){
        Member member = new Member();
        DiaryResponse response = diaryService.create(request,member);

        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/read/{date}")
    public ResponseEntity read(@PathVariable("date") LocalDate date){
        Member member = new Member();
        Diary response = diaryService.read(date,member);

        return ResponseEntity.ok().body(response);
    }


    @PutMapping("/update/{date}")
    public ResponseEntity update(@PathVariable("date") LocalDate date,
                                 @RequestBody DiaryRequest request){
        Member member = new Member();
        DiaryResponse response = diaryService.update(request,date,member);

        return ResponseEntity.ok().body(response);
    }
}
