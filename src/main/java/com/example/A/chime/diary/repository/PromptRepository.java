package com.example.A.chime.diary.repository;

import com.example.A.chime.diary.domain.Prompt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromptRepository extends JpaRepository<Prompt,Long> {
}
