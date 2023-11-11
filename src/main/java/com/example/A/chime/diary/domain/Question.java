package com.example.A.chime.diary.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    @Id
    private Long questionId;
    private Long dairyId;
    private String Context;
    private QType qType;
    private Category category;
    private int answer;

}
