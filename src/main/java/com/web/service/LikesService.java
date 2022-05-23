package com.web.service;

import com.web.controller.LikesRestController;
import com.web.domain.Content;
import com.web.domain.Likes;
import com.web.domain.Member;
import com.web.dto.LikesDto;
import com.web.dto.MemberDto;
import com.web.repository.ContentRepository;
import com.web.repository.LikesRepository;
import com.web.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class LikesService {
    private final LikesRepository likesRepository;

    @Autowired
    private ContentRepository contentRepository;

    @Autowired
    private MemberRepository memberRepository;

    public List<Likes> getAllLikes(){
        return likesRepository.findAll();
    }

    public Long getMemberId(String loginId){
        return memberRepository.findByLoginId(loginId).getId();
    }

    public Likes saveLikes(LikesDto likesDto){
        validateDuplicateLikes(likesDto);
        Content content = contentRepository.findById(likesDto.getContentId()).get();
        Member member = memberRepository.findById(likesDto.getMemberId()).get();
        return likesRepository.save(Likes.createLikes(content, member));
    }

    public void validateDuplicateLikes(LikesDto likesDto){
        List<Likes> foundLikes = likesRepository.findAllByMember(memberRepository.findById(likesDto.getMemberId()).get());

        for (Likes likes: foundLikes){
            if (likes.getContent().getId() == likesDto.getContentId()){
                throw new IllegalStateException("이미 선호 등록한 작품입니다.");
            }
        }
    }


}
