package com.example.A.chime.diary.domain;


import com.example.A.chime.diary.oauth.OAuthProvider;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;
    private String nickname;
    @Enumerated(EnumType.STRING)
    private OAuthProvider oAuthProvider;
}
