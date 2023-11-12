//프론트에서 access code
package com.example.A.chime.diary.kauth.controller;

import com.example.A.chime.diary.service.MemberService;
import com.example.A.chime.diary.domain.Member;
import com.example.A.chime.diary.kauth.dto.OauthToken;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class KoauthController{
    private final MemberService memberService;

    @PostMapping("/login/{code}")
    public ResponseEntity<String> getLoing(@PathVariable("code") String code){
        //access code로 access token 발급
        OauthToken oauthToken = memberService.getAccessToken(code);
        String accessToken = oauthToken.getAccess_token();

        HttpHeaders header = new HttpHeaders();
        header.set("Authorization", accessToken);
        //저장
        Member member = memberService.saveMember(oauthToken.getAccess_token());

        return new ResponseEntity<>(header, HttpStatus.OK);
    }
}
