package com.example.A.chime.diary.controller;

import com.example.A.chime.diary.domain.Member;
import com.example.A.chime.diary.dto.responseDto.QuizChoiceResponse;
import com.example.A.chime.diary.service.DiaryService;
import com.example.A.chime.diary.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("quiz")
@RequiredArgsConstructor
public class QuizController {
    private final QuizService quizService;
    //1. 퀴즈한개씩 가져오기
    @GetMapping()
    public ResponseEntity get_quiz(){
        Member member = new Member();
        QuizChoiceResponse response = quizService.generate_quizChoice(member);




        return ResponseEntity.ok().body(response);
    }

    //2. 퀴즈답안 제출했을때

    //3. 퀴즈결과 반환
}