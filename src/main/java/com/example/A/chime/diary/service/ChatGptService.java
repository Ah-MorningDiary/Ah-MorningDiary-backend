package com.example.A.chime.diary.service;

import com.example.A.chime.diary.dto.requestDto.ChatGptRequest;
import com.example.A.chime.diary.dto.requestDto.Message;
import com.example.A.chime.diary.dto.responseDto.QuizOXResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ChatGptService {
    @Value("${gpt-key}")
    private String key;

    public QuizOXResponse questionOX(String diary){
        String url = "https://api.openai.com/v1/chat/completions";
        QuizOXResponse response = new QuizOXResponse();

        //요청 헤더
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + key);

        //요청 바디
        ChatGptRequest request = new ChatGptRequest();
        request.setModel("gpt-3.5-turbo");
        List<Message> messages = new ArrayList<>();
        messages.add(new Message("user", diary));
        request.setMessages(messages);
        request.setMaxTokens(100);
        request.setTemperature(1.0);
        request.setTopP(1.0);

        //HTTP 요청
        HttpEntity<ChatGptRequest> requestEntity = new HttpEntity<>(request, headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Map<String,Object>> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity,new ParameterizedTypeReference<Map<String,Object>>() {});

        //response 파싱
        Map<String,Object> result = responseEntity.getBody();
        assert result != null; //여기 예외처리 필요
        @SuppressWarnings("unchecked")
        ArrayList<Map<String,Object>> jsonArray = (ArrayList<Map<String,Object>>)result.get("choices");
        @SuppressWarnings("unchecked")
        Map<Object,Object> jsonObject = (Map<Object,Object>)jsonArray.get(0).get("message");


        response.setQuestion(String.valueOf(jsonObject.get("content")));
        return response;

    }

    public String questionChoice(String diary){
        String url = "https://api.openai.com/v1/chat/completions";
        QuizOXResponse response = new QuizOXResponse();

        //요청 헤더
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + key);

        //요청 바디
        ChatGptRequest request = new ChatGptRequest();
        request.setModel("gpt-3.5-turbo");
        List<Message> messages = new ArrayList<>();
        messages.add(new Message("user", diary));
        request.setMessages(messages);
        request.setMaxTokens(100);
        request.setTemperature(1.0);
        request.setTopP(1.0);

        //HTTP 요청
        HttpEntity<ChatGptRequest> requestEntity = new HttpEntity<>(request, headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Map<String,Object>> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity,new ParameterizedTypeReference<Map<String,Object>>() {});

        //response 파싱
        Map<String,Object> result = responseEntity.getBody();

        System.out.println(result);
        assert result != null; //여기 예외처리 필요
        @SuppressWarnings("unchecked")
        ArrayList<Map<String,Object>> jsonArray = (ArrayList<Map<String,Object>>)result.get("choices");
        @SuppressWarnings("unchecked")
        Map<Object,Object> jsonObject = (Map<Object,Object>)jsonArray.get(0).get("message");


        response.setQuestion(String.valueOf(jsonObject.get("content")));


        return String.valueOf(jsonObject.get("content"));

    }

    public void save_QA(String reponse){

    }
}