package com.example.A.chime.diary.service;


import com.example.A.chime.diary.domain.Member;
import com.example.A.chime.diary.domain.Score;
import com.example.A.chime.diary.dto.responseDto.ResultResponse;
import com.example.A.chime.diary.repository.AnswerRepository;
import com.example.A.chime.diary.repository.QuestionRepository;
import com.example.A.chime.diary.repository.ScoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ResultService {

    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;
    private final ScoreRepository scoreRepository;


    //오늘 푼 문제에 대한 결과
    public ResultResponse result(Member member, LocalDate date){
        //Long memberId = member.getMemberId();
        ResultResponse response = new ResultResponse();
        response.setDate(date);
        response.setQnum(6);

        //1. memberId date로 score가져오기
        Optional<Score> score = scoreRepository.findAllByChecked(1L,date);
        if(score.isPresent()){
            response.setRisk(score.get().getStatus());
            response.setAnum(score.get().getAnum());
        }


        return response;
    }
}
