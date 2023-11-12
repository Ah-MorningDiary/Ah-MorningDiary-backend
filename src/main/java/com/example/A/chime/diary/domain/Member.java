package com.example.A.chime.diary.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;
    private String nickName;
    private String accessToken;
}
