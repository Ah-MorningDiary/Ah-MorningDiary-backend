package com.example.A.chime.diary.service;


import com.example.A.chime.diary.domain.Diary;
import com.example.A.chime.diary.domain.Member;
import com.example.A.chime.diary.dto.requestDto.DiaryRequest;
import com.example.A.chime.diary.dto.responseDto.DiaryResponse;
import com.example.A.chime.diary.repository.DairyRepository;
import com.example.A.chime.diary.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DiaryService {
    private final DairyRepository dairyRepository;
    private final MemberRepository memberRepository;

    public DiaryResponse create(DiaryRequest request, Member member){
        DiaryResponse response = new DiaryResponse();
        Diary diary = new Diary();

        member = memberRepository.findById("testId").get();

        //TODO: 예외처리 고려
        diary.setMemberId(member);
        diary.setContext(request.getContext());
        diary.setDate(LocalDate.now());
        diary.setWhether(request.getWhether());
        diary.setImgUrl(request.getImgUrl());

        dairyRepository.save(diary);
        response.setDairyId(diary.getDiaryId());
        response.setMessage("성공적으로 저장하였습니다.");

        return response;
    }

    public Diary read(LocalDate date, Member member){
        member = memberRepository.findById("testId").get();
        Optional<Diary> diary = dairyRepository.findByMemberIdAndDate(member,date);

        //TODO: 예외처리 어떻게 할지
        if(diary.isPresent()){

        }
        return diary.get();
    }


    public DiaryResponse update(DiaryRequest request, LocalDate date, Member member){
        DiaryResponse response = new DiaryResponse();
        member = memberRepository.findById("testId").get();
        Optional<Diary> diary = dairyRepository.findByMemberIdAndDate(member,date);
        //TODO: 예외처리 어떻게 할지
        if(diary.isPresent()){
            Diary data = diary.get();
            data.setContext(request.getContext());
            data.setWhether(request.getWhether());
            data.setImgUrl(request.getImgUrl());

            dairyRepository.save(data);

            response.setDairyId(data.getDiaryId());
            response.setMessage("성공적으로 수정하였습니다.");
        }
        else{
            response.setMessage("수정에 실패하였습니다.");
        }

        return response;
    }
}
