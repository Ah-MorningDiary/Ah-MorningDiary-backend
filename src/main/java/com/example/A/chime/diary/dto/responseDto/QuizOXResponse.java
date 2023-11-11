package com.example.A.chime.diary.dto.responseDto;

import com.example.A.chime.diary.domain.QType;
import lombok.Data;

import java.util.List;

@Data
public class QuizOXResponse {
    private QType type;
    public String Question;
}