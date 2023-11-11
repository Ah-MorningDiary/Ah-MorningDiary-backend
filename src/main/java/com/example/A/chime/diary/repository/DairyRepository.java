package com.example.A.chime.diary.repository;

import com.example.A.chime.diary.domain.Diary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DairyRepository extends JpaRepository<Diary,Long> {
}
