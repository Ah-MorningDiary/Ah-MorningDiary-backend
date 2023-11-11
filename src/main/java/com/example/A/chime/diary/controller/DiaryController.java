package com.example.A.chime.diary.controller;


import com.example.A.chime.diary.domain.Member;
import com.example.A.chime.diary.dto.requestDto.DairyRequest;
import com.example.A.chime.diary.dto.responseDto.DairyResponse;
import com.example.A.chime.diary.service.DiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
