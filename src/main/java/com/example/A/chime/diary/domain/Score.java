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
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name="member_id"),
            @JoinColumn(name="date")
    })
    private Diary diaryId;
    private int Qnum;
    private int Anum;
    private Status status;
    private LocalDate date;
}
