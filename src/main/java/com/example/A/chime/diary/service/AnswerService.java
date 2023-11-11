package com.example.A.chime.diary.service;


import com.example.A.chime.diary.domain.*;
import com.example.A.chime.diary.dto.requestDto.SubmittedAnswerRequest;
import com.example.A.chime.diary.repository.DiaryRepository;
import com.example.A.chime.diary.repository.MemberRepository;
import com.example.A.chime.diary.repository.QuestionRepository;
import com.example.A.chime.diary.repository.ScoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnswerService {
    private final MemberRepository memberRepository;
    private final QuestionRepository questionRepository;
    private final ScoreRepository scoreRepository;
    private final DiaryRepository diaryRepository;

    public String submit(SubmittedAnswerRequest request, Member member){
        //memberRepository.findById(member.getMemberId());
        //TODO:member 맵핑
        Member member1 = memberRepository.findById(1L).get();
        LocalDate date = LocalDate.now();
        Long diary_id=0L;
        Score score = new Score();
        score.setAnum(0);
        score.setDate(date);
        score.setMemberId(member1.getMemberId());


        for (int i=0; i<6;i++){
            Long[] input = request.getAnswerList()[i];
            Optional<Question> q = questionRepository.findById(input[0]);
            diary_id = q.get().getDairyId();
            if(q.isPresent()){
                int answer = q.get().getAnswer();
                Long output = input[1];
                System.out.println(output + answer);
                if(answer == output.intValue()){
                    score.setAnum(score.getAnum()+1);
                }
            }
            else{
                return "없는 문제입니다. 제출에 실패하였습니다.";
            }

        }

        score.setStatus(risk(score.getAnum()));
        score.setDiaryId(diary_id);
        scoreRepository.save(score);

        return "성공적으로 제출되었습니다.";

    }

    public Status risk(int num){
        Status status;
        if (num>4){
            status = Status.GOOD;
        } else if (num>3) {
            status = Status.NORMAL;
        } else {
            status = Status.BAD;
        }
        return  status;
    }

}
