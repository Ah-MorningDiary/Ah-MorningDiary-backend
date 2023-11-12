//프론트에서 access code
package com.example.A.chime.diary.kauth.controller;

import com.example.A.chime.diary.service.MemberService;
import com.example.A.chime.diary.domain.Member;
import com.example.A.chime.diary.kauth.dto.OauthToken;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/login")
public class KoauthController{
    private final MemberService memberService;

    @PostMapping("/{code}")
    //ResponseEntity<String>
    public void getLoing(@PathVariable("code") String code, HttpServletResponse response){
        //access code로 access token 발급

        OauthToken oauthToken = memberService.getAccessToken(code);
        String accessToken = oauthToken.getAccess_token();

        //헤더로 전송
//        HttpHeaders header = new HttpHeaders();
//        header.set("Authorization", accessToken);

        //멤버 저장
        Member member = memberService.saveMember(oauthToken.getAccess_token());

        //쿠키
        Cookie cookie = new Cookie("Authorization", accessToken);
        cookie.setMaxAge(3600);
        cookie.setPath("/");

        response.addCookie(cookie);
        //return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
