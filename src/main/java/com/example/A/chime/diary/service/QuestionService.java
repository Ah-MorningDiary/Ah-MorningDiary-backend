package com.example.A.chime.diary.service;

import com.example.A.chime.diary.domain.Category;
import com.example.A.chime.diary.domain.Question;
import com.example.A.chime.diary.dto.responseDto.QuizChoiceResponse;
import com.example.A.chime.diary.repository.DiaryRepository;
import com.example.A.chime.diary.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final DiaryRepository diaryRepository;

    public Long save_question(Long DiaryId, QuizChoiceResponse quiz,String answer){
        Question question = new Question();
        question.setDairyId(DiaryId);
        question.setCategory(Category.기억력);
        question.setContext(quiz.getQuestion());

        int ans;
        if(answer.contains("a")){
            ans=1;
        } else if (answer.contains("b")) {
            ans=2;
        } else if (answer.contains("c")) {
            ans=3;
        }else{
            ans=4;
        }

        question.setAnswer(ans);
        questionRepository.save(question);

        return question.getQuestionId();
    }
}
