package com.example.A.chime.diary.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private Long diaryId;

    private Long memberId;
    private int Qnum = 6;
    private int Anum;//맞은 문제수
    private Status status;
    private LocalDate date;//푼 날짜
}
