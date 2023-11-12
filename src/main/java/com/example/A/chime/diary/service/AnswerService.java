package com.example.A.chime.diary.service;


import com.example.A.chime.diary.domain.Answer;
import com.example.A.chime.diary.repository.AnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnswerService {
    private final AnswerRepository answerRepository;

    public void save_answer(List<String> options, Long questionId){
        Long num = 1L;

        for (String option:options){
            Answer answer = new Answer();
            answer.setQuestionId(questionId);
            answer.setAnswerId(num);
            answer.setContext(option);
            answerRepository.save(answer);
            num=num+1;
        }

    }
}
