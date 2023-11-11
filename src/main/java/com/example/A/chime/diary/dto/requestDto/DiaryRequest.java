package com.example.A.chime.diary.dto.requestDto;


import com.example.A.chime.diary.domain.Whether;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DiaryRequest {
    private String context;
    private String imgUrl;
    private Whether whether;
}
