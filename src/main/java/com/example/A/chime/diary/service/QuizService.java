package com.example.A.chime.diary.service;

import com.example.A.chime.diary.domain.Answer;
import com.example.A.chime.diary.domain.Diary;
import com.example.A.chime.diary.domain.Member;
import com.example.A.chime.diary.domain.Question;
import com.example.A.chime.diary.dto.responseDto.QuizChoiceResponse;
import com.example.A.chime.diary.dto.responseDto.QuizOXResponse;
import com.example.A.chime.diary.repository.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuizService {
    private final DiaryRepository diaryRepository;
    private final MemberRepository memberRepository;
    private final ChatGptService chatGptService;
    private final PromptRepository promptRepository;
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    public QuizOXResponse generate_quizOX(LocalDate date, String diary){
        QuizOXResponse quizOXResponse = new QuizOXResponse();
        quizOXResponse = chatGptService.questionOX(diary);
        return quizOXResponse;
    }



    @Transactional
    public QuizChoiceResponse generate_quizChoice(Member member){
        //피료없는거 ...
        //Optional<Diary> diary = diaryRepository.findByMemberIdAndDate(member,date);
        QuizChoiceResponse response = new QuizChoiceResponse();

        //TODO: date-checked=flase인 가장 최근일기 , member-현재 사용자의 member
        member = memberRepository.findById(1L).get();
        Optional<Diary> diary = diaryRepository.findAllByChecked(member.getMemberId());
        String prompt = promptRepository.findById(1L).get().getContext();
        prompt = diary.get().getContext()+"\n\n"+prompt;
        System.out.println(prompt);
        String quiz = chatGptService.questionChoice(prompt);

        System.out.println(quiz);
        response.setQuestion(quiz);

        return response;

    }
    public QuizChoiceResponse get_quize(Long questionId) {

        QuizChoiceResponse response = new QuizChoiceResponse();
        Question question = questionRepository.findByQuestionId(questionId).get();
        List<String> options = getOptionsForQuiz(question);

        response.setQuestion(question.getContext());
        response.setOptions(options);

        return response;
    }

    private List<String> getOptionsForQuiz(Question question) {
        List<String> options = new ArrayList<>();
        List<Answer> answers = answerRepository.findByQuestionId(question);
        for (Answer answer : answers) {
            options.add(answer.getContext());
        }
        return options;
    }


}
