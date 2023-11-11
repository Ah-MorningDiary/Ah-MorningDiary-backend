package com.example.A.chime.diary.repository;

import com.example.A.chime.diary.domain.Diary;
import com.example.A.chime.diary.domain.Score;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, Diary> {
}
