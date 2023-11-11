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
@IdClass(ResultId.class)
public class Result {
    @Id
    @ManyToOne
    @JoinColumn(name="member_id")
    private Member memberId;
    @Id
    private LocalDate date;
    @Id
    @ManyToOne
    @JoinColumn(name="questionId")
    private Question questionId;
    private Long number;
    private Long pickedAns;
    private OX result;
}
