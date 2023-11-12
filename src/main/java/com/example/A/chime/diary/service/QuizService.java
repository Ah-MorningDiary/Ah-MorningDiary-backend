package com.example.A.chime.diary.service;

import com.example.A.chime.diary.domain.*;
import com.example.A.chime.diary.dto.responseDto.QuizChoiceResponse;
import com.example.A.chime.diary.dto.responseDto.QuizOXResponse;
import com.example.A.chime.diary.repository.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
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
    private final QuestionService questionService;
    private final AnswerService answerService;


    //TODO: 할꺼면 다른 클래스로 옮겨가자 ..
    public QuizOXResponse generate_quizOX(LocalDate date, String diary){
        QuizOXResponse quizOXResponse = new QuizOXResponse();
        quizOXResponse = chatGptService.questionOX(diary);
        return quizOXResponse;
    }



    // 퀴즈로 만들어야 할 일기 찾고 gpt호출하는 함수
    @Transactional
    public QuizChoiceResponse generate_quizChoice(Member member){
        //피료없는거 ...
        //Optional<Diary> diary = diaryRepository.findByMemberIdAndDate(member,date);


        //TODO: date-checked=flase인 가장 최근일기 , member-현재 사용자의 member
        member = memberRepository.findById(member.getMemberId()).get();
        Optional<Diary> diary = diaryRepository.findAllByChecked(member.getMemberId());
        String prompt = promptRepository.findById(1L).get().getContext();
        prompt = diary.get().getContext()+"\n\n"+prompt;
        //
        String quiz = chatGptService.questionChoice(prompt);

        QuizChoiceResponse response = parse_dto(quiz,diary.get());


        System.out.println(quiz);
        response.setType(QType.CHOICE);

        return response;

    }



    //질문, 선택지 파싱해 response에 돌려주는 함수
    public QuizChoiceResponse parse_dto(String quiz,Diary diary){
        QuizChoiceResponse response = new QuizChoiceResponse();
        List<String> options = new ArrayList<>();
        String[] input = quiz.split("\n");
        String question = input[0].replace("질문","");

        int a=1;
        for (int i=1; i<input.length-1; i++){
            if (!input[i].isEmpty()){
                options.add(input[a]);
                a+=1;
            }

        }

        //TODO: Question 엔티티에 정답 번호 저장쓰
        String answer = input[input.length-1].replace("정답","");
        response.setQuestion(question);
        response.setOptions(options);

        Long questionId = questionService.save_question(diary.getDiaryId(), response,answer);

        //save_answer
        answerService.save_answer(response.getOptions(),questionId);

        return response;
    }




    public QuizChoiceResponse get_stored_quiz(Long questionId) {

        QuizChoiceResponse response = new QuizChoiceResponse();
        Question question = questionRepository.findByQuestionId(questionId).get();
        System.out.println(question.getContext());
        List<String> options = getOptionsForQuiz(questionId);
        System.out.println(options);

        response.setQuestion(question.getContext());
        response.setOptions(options);
        response.setType(QType.CHOICE);

        return response;
    }



    private List<String> getOptionsForQuiz(Long questionId) {
        List<String> options = new ArrayList<>();

        List<Answer> answers = answerRepository.findByQuestionId(questionId);
        for (Answer answer : answers) {
            options.add(answer.getContext());
        }
        return options;
    }

    public QuizChoiceResponse whether_question(Member member){
        QuizChoiceResponse response = new QuizChoiceResponse();


        member = memberRepository.findById(member.getMemberId()).get();

        Optional<Diary> diary = diaryRepository.findAllByChecked(member.getMemberId());
        String question = "날씨가 없습니다.";
        List<String> options = new ArrayList<>();

        if(diary.isPresent()){
            LocalDate date = diary.get().getDate();
            SimpleDateFormat format = new SimpleDateFormat("yyyy년 MM월 dd일");
            String str = format.format(date);
            question = str+ "의 날씨는 어떠했나요?";

            options.add("맑음");
            options.add("흐림");
            options.add("눈");
            options.add("비");

            //TODO: question의 정답필드에 저장해야함
            //answer = diary.get().getWhether();

        }

        response.setQuestion(question);
        response.setOptions(options);
        response.setType(QType.CHOICE);

        return response;
    }


}
