package com.example.A.chime.diary.dto.requestDto;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class SubmittedAnswerRequest {
    private Long[][] answerList;
}
