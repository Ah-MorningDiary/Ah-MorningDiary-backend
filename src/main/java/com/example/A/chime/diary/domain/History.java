package com.example.A.chime.diary.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class History {
    @Id
    private Long historyId;
    private Long MemberId;
    private List<Long> question_list;
}
