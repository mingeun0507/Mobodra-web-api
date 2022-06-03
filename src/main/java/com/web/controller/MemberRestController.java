package com.web.controller;

import com.web.domain.Member;
import com.web.dto.MemberDto;
import com.web.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MemberRestController {

    private final MemberService memberService;

    @GetMapping
    public List<Member> getMembers() {
        return memberService.getMembers();
    }

    @PostMapping(value = "/sign-up")
    public String createMember(@RequestBody MemberDto memberDto, HttpServletRequest req) {
        HttpSession session = req.getSession();

        try {
            memberService.saveMember(memberDto);
            session.setAttribute("loginId", memberDto.getLoginId());
            return "true";
        } catch (IllegalStateException e) {
            session.setAttribute("loginId", null);
            System.out.println(e.getMessage());
            return "false";
        }
    }

    @PostMapping("/login")
    public String login (@RequestBody MemberDto memberDto, HttpServletRequest req) {
        HttpSession session = req.getSession();

        try {
            memberService.loginCheck(memberDto);
            session.setAttribute("loginId", memberDto.getLoginId());
            return "true";
        } catch (IllegalStateException e){
            session.setAttribute("loginId", null);
            System.out.println(e.getMessage());
            return "false";
        }
    }

    @GetMapping("/error")
    public String error(){
        return "로그인을 해주세요.";
    }

}
