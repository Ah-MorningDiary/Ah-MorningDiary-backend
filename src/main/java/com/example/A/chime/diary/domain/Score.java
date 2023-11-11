package com.example.A.chime.diary.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    @ManyToOne
    @JoinColumn(name="diary_id")
    private Diary diaryId;
    private int Qnum;
    private int Anum;
    private Status status;
    private LocalDate date;
}
