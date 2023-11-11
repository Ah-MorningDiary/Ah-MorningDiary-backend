package com.example.A.chime.diary.repository;


import com.example.A.chime.diary.domain.Answer;
import com.example.A.chime.diary.domain.AnswerId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, AnswerId> {
}
