package com.example.A.chime.diary.dto.responseDto;


import com.example.A.chime.diary.domain.Status;
import lombok.Data;

import java.time.LocalDate;
import java.util.Map;

@Data
public class ChartResponse {
    private Map<LocalDate, Status> datas;
}
