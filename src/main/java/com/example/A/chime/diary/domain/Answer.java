package com.example.A.chime.diary.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(AnswerId.class)
public class Answer {
    @Id
    private Long questionId;
    @Id
    private Long answerId;
    private String context;

}
