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
public class Diary {
    @Id
    private Long diaryId;
    @ManyToOne
    @JoinColumn(name="member_id")
    private Member memberId;

    private String context;
    private String imgUrl;
    private LocalDate date;
    private Whether whether;


}
