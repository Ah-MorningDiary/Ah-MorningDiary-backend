package com.example.A.chime.diary.dto.requestDto;


import com.example.A.chime.diary.domain.Whether;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DairyRequest {
    private String context;
    private String imgUrl;
    private Whether whether;
}
