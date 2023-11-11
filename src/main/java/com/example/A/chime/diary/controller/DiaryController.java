package com.example.A.chime.diary.controller;


import com.example.A.chime.diary.domain.Diary;
import com.example.A.chime.diary.domain.Member;
import com.example.A.chime.diary.dto.requestDto.DairyRequest;
import com.example.A.chime.diary.dto.responseDto.DairyResponse;
import com.example.A.chime.diary.service.DiaryService;
import lombok.RequiredArgsConstructor;
import org.hibernate.boot.model.internal.CreateKeySecondPass;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("dairy")
@RequiredArgsConstructor
public class DiaryController {
    private final DiaryService diaryService;


    @PostMapping("/create")
    public ResponseEntity create(@RequestBody DairyRequest request){
        Member member = new Member();
        DairyResponse response = diaryService.create(request,member);

        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/read/{date}")
    public ResponseEntity read(@PathVariable("date") LocalDate date){
        Member member = new Member();
        Diary response = diaryService.read(date,member);

        return ResponseEntity.ok().body(response);
    }
}
