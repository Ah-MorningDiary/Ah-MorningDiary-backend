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
public class Diary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long diaryId;
    @ManyToOne
    @JoinColumn(name="member_id")
    private Member memberId;

    private String context;
    private String imgUrl;
    private LocalDate date;
    private Whether whether;


}
