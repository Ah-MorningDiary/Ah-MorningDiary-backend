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
@IdClass(DiaryId.class)
public class Diary {
    @Id
    @ManyToOne
    @JoinColumn(name="member_id")
    private Member memberId;
    @Id
    private LocalDate date;
    private String context;
    private String imgUrl;
    private Whether whether;


}
