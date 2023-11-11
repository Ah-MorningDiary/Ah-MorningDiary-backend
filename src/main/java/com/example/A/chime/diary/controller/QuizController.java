package com.example.A.chime.diary.controller;

import com.example.A.chime.diary.domain.Member;
import com.example.A.chime.diary.dto.responseDto.QuizChoiceResponse;
import com.example.A.chime.diary.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("quiz")
@RequiredArgsConstructor
public class QuizController {
    private final QuizService quizService;
    //1. 퀴즈한개씩 가져오기
    @GetMapping("/{number}")
    public ResponseEntity get_quiz(@PathVariable("number") int number){

        Member member = new Member();

        // 1--> 날씨 묻는 퀴즈, 3,5--> 일기기반 2,4,6--> 저장된 퀴즈
        if(number==3 || number==5){
            QuizChoiceResponse response = quizService.generate_quizChoice(member);
            return ResponseEntity.ok().body(response);
        }
        else if (number==2 || number==4 || number==6) {
            Long randomValue = getRandomNumberInRange(1, 7);
            QuizChoiceResponse response = quizService.get_stored_quiz(randomValue);
            return ResponseEntity.ok().body(response);
        }
        else if (number==1) {
            //
        }

        return ResponseEntity.ok().body(null);
    }


    private Long getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("Max must be greater than min");
        }
        Random random = new Random();
        return (long) (random.nextInt((max - min) + 1) + min);
    }




    //3. 퀴즈결과 반환
}