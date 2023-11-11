package com.example.A.chime.diary.repository;


import com.example.A.chime.diary.domain.Answer;
import com.example.A.chime.diary.domain.AnswerId;
import com.example.A.chime.diary.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, AnswerId> {
    List<Answer> findByQuestionId(Question questionId);
}
