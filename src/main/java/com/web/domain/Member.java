package com.web.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name="Member")
public class Member {

    @Id
    @Column(name = "MEMBER_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; //유저 식별용 id

    @Column(name="loginid", nullable = false, unique = true, length = 20)
    private String loginId; //유저 로그인용 id

    @Column(name="loginpw", nullable = false, length = 20)
    private String loginPw; //유저 로그인용 pw

    @Column(name="nickname", nullable = false, length = 15)
    private String nickname; //유저 닉네임

//    public static Member createMember(MemberDto memberDto){
//        Member member = new Member();
//        member.setLoginId(memberDto.getLoginId());
//        member.setLoginPw(loginPw);
//        member.setNickname(memberDto.getNickName());
//
//        return member;
//    }
}