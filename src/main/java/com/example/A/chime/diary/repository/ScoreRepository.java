package com.example.A.chime.diary.repository;

import com.example.A.chime.diary.domain.Diary;
import com.example.A.chime.diary.domain.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ScoreRepository extends JpaRepository<Score, Diary> {
    @Query(value = "SELECT * from Score WHERE member_id = :memberId and date = :date",nativeQuery = true)
    Optional<Score> findAllByChecked(@Param("memberId") Long memberId, @Param("date") LocalDate date);

    @Query(value = "SELECT * from Score WHERE month(date) = :month", nativeQuery = true)
    List<Score> findAllByMonth(@Param("month") int month);
}
