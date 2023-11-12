package com.example.A.chime.diary.service;

import com.example.A.chime.diary.domain.Member;
import com.example.A.chime.diary.kauth.dto.KakaoProfile;
import com.example.A.chime.diary.kauth.dto.OauthToken;
import com.example.A.chime.diary.repository.MemberRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;


import static org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED;

@Service
public class MemberService {
    @Autowired
    MemberRepository memberRepository;

    @Value("${kakao.clientId}")
    String client_id;

    //TODO:params에 redirectUrl 박아두는거 아니면 redirectUrl missmatch error남.. 왜?
    //바꿔야댐
    //@Value("${kakao.redirectUrl}")
    //String redirect_url;


    //됨
    public OauthToken getAccessToken(String code) {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        //APPLICATION_FORM_URLENCODED "application/x-www-form-urlencoded;charset=utf-8"
        headers.add("Content-type", String.valueOf(APPLICATION_FORM_URLENCODED));

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "authorization_code");
        params.add("client_id", client_id);
        //프론트 url +"/auth"
        params.add("redirect_uri","http://localhost:8080/new/redirect");
        params.add("code",code);
        //client_secret

        HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest = new HttpEntity<>(params, headers);

        ResponseEntity<String> accessTokenResponse = restTemplate.exchange(
                "https://kauth.kakao.com/oauth/token",
                HttpMethod.POST,
                kakaoTokenRequest,
                String.class
        );

        ObjectMapper objectMapper = new ObjectMapper();
        OauthToken oauthToken = new OauthToken();
        try {
            oauthToken = objectMapper.readValue(accessTokenResponse.getBody(), OauthToken.class);
        } catch (JsonProcessingException e){
            e.printStackTrace();
        }

        return oauthToken;

    }


    public Member saveMember(String token){

        KakaoProfile profile = findProfile(token);

        Member member = memberRepository.findByMemberId(profile.getId());

        if(member == null) {
            member = member.builder()
                    .memberId(profile.getId())
                    .nickName(profile.getKakao_account().getProfile().getNickname())
                    .accessToken(token)
                    .build();
            //(5)
            memberRepository.save(member);
        }

        return member;
    }

    public KakaoProfile findProfile(String token) {

        RestTemplate rt = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + token); //(1-4)
        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

        HttpEntity<MultiValueMap<String, String>> kakaoProfileRequest = new HttpEntity<>(headers);

        // Http 요청 (POST 방식) 후, response 변수에 응답을 받음
        ResponseEntity<String> kakaoProfileResponse = rt.exchange(
                "https://kapi.kakao.com/v2/user/me",
                HttpMethod.POST,
                kakaoProfileRequest,
                String.class
        );

        System.out.println(kakaoProfileResponse);

        //(1-7)
        ObjectMapper objectMapper = new ObjectMapper();
        KakaoProfile kakaoProfile = new KakaoProfile();
        try {
            kakaoProfile = objectMapper.readValue(kakaoProfileResponse.getBody(), KakaoProfile.class);
        } catch (JsonProcessingException e) {
            System.out.println(kakaoProfile);
            e.printStackTrace();
        }

        return kakaoProfile;
    }


    public Member findMember(String accessToken) {
        return memberRepository.findByAccessToken(accessToken);
    }
}
