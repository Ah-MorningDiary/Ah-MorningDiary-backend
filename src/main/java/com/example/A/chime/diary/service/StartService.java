package com.example.A.chime.diary.service;


import com.example.A.chime.diary.domain.Member;
import com.example.A.chime.diary.domain.Score;
import com.example.A.chime.diary.repository.ScoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StartService {
    private final ScoreRepository scoreRepository;
    public boolean start(Member member){

        //memberId = 1L
        Optional<Score> score = scoreRepository.findAllByChecked(1L, LocalDate.now());
        if(score.isPresent()){
            return false;
        }
        else {
            return true;
        }
    }
}
