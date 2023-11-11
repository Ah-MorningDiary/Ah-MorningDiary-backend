package com.example.A.chime.diary.repository;

import com.example.A.chime.diary.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Long> {
    Optional<Question> findByQuestionId(Long questionId);
}
