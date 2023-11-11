package com.example.A.chime.diary.repository;

import com.example.A.chime.diary.domain.Diary;
import com.example.A.chime.diary.domain.DiaryId;
import com.example.A.chime.diary.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface DiaryRepository extends JpaRepository<Diary, DiaryId> {
    Optional<Diary> findByMemberIdAndDate(Member memberId, LocalDate date);
    @Query(value = "SELECT * from diary WHERE member_id = :memberId ORDER by date desc limit 1",nativeQuery = true)
    Optional<Diary> findAllByChecked(@Param("memberId") Long memberId);

}
