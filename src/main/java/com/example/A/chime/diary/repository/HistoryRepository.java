package com.example.A.chime.diary.repository;

import com.example.A.chime.diary.domain.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<History,Long> {
}
