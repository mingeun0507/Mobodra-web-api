package com.web.controller;

import com.web.domain.Member;
import com.web.repository.MemberRepository;
import com.web.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberRestController {

    private final MemberService memberService;

    @GetMapping
    public List<Member> getMembers() {
        return memberService.getMembers();
    }

    @PostMapping(value = "/sign-up")
    public String createMember(@RequestBody Member member) throws URISyntaxException {
        try {
            Member savedMember = memberService.saveMember(member);
            return "true";
        } catch (IllegalStateException e) {
            System.out.println("asdfasdfasdfasdf");
            return "false";
        }
    }



}
