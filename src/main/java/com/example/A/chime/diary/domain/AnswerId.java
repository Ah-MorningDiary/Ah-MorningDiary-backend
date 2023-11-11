package com.example.A.chime.diary.domain;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswerId implements Serializable {
    private Long questionId;
    private Long answerId;
}
