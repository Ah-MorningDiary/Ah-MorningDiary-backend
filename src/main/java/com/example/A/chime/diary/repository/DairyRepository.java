package com.example.A.chime.diary.repository;

import com.example.A.chime.diary.domain.Diary;
import com.example.A.chime.diary.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;


@Repository
public interface DairyRepository extends JpaRepository<Diary,Long> {
    Optional<Diary> findByMemberIdAndDate(Member memberId, LocalDate date);
}
