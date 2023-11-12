package com.example.A.chime.diary.service;


import com.example.A.chime.diary.domain.Member;
import com.example.A.chime.diary.domain.Score;
import com.example.A.chime.diary.domain.Status;
import com.example.A.chime.diary.dto.responseDto.ChartResponse;
import com.example.A.chime.diary.repository.MemberRepository;
import com.example.A.chime.diary.repository.ScoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ChartService {
    private final MemberRepository memberRepository;
    private final ScoreRepository scoreRepository;

    public ChartResponse chart(Member member, int month){

        List<Score> scores = scoreRepository.findAllByMonth(month);
        ChartResponse response = new ChartResponse();
        Map<LocalDate,Status> output = new HashMap<>();

        for(int i=1;i<31;i++){
            output.put(LocalDate.of(2023,month,i),null);
            for(Score score:scores){
                if(score.getDate().getDayOfMonth() == i){
                    Status status = score.getStatus();
                    output.put(LocalDate.of(2023,month,i),status);
                }
            }
        }
        response.setDatas(output);

        return response;
    }
}
