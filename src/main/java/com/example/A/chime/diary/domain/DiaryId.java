package com.example.A.chime.diary.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiaryId implements Serializable {
    private LocalDate date;
    private Member memberId;
}
