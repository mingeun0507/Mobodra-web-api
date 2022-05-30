package com.web.service;

import com.web.domain.Member;
import com.web.dto.MemberDto;
import com.web.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public List<Member> getMembers(){
        return memberRepository.findAll();
    }

    public Member getMemberByLoginId(String loginId) {
        return memberRepository.findByLoginId(loginId);
    }

    public Member saveMember(MemberDto memberDto){
        validateDuplicateMember(memberDto);
        return memberRepository.save(Member.createMember(memberDto));
    }

    private void validateDuplicateMember(MemberDto memberDto){

        Member foundMember = memberRepository.findByLoginId(memberDto.getLoginId());

        if (foundMember != null){
            throw new IllegalStateException("이미 존재하는 ID입니다.");
        }
    }

    public void loginCheck(MemberDto memberDto){

         Member foundMemberByLoginId = memberRepository.findByLoginId(memberDto.getLoginId());
         if (foundMemberByLoginId == null) {
             throw new IllegalStateException("존재하지 않는 아이디나 비밀번호이거나 아이디와 비밀번호가 일치하지 않습니다.1");
         }

         if (!foundMemberByLoginId.getLoginPw().equals(memberDto.getLoginPw())) {
             throw new IllegalStateException("존재하지 않는 아이디나 비밀번호이거나 아이디와 비밀번호가 일치하지 않습니다.");
         }

    }

}
