package com.example.A.chime.diary.dto.responseDto;

import com.example.A.chime.diary.domain.Status;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ResultResponse {
    //0~2
    private Status risk;
    private int Qnum=6;
    private int Anum;
    private LocalDate date;
}
