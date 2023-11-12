package com.example.A.chime.diary.dto.responseDto;

import com.example.A.chime.diary.domain.QType;
import lombok.Data;

import java.util.List;

@Data
public class QuizChoiceResponse {
    private Long questionId;
    private QType type;
    public String question;
    private List<String> options;
}
