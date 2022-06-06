package com.web.service;

import com.web.domain.Content;
import com.web.domain.Likes;
import com.web.domain.Member;
import com.web.dto.LikesDto;
import com.web.repository.ContentRepository;
import com.web.repository.LikesRepository;
import com.web.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
@RequiredArgsConstructor
public class LikesService {
    private LikesRepository likesRepository;

    private ContentRepository contentRepository;

    private MemberRepository memberRepository;

    @Autowired
    public LikesService(LikesRepository likesRepository, ContentRepository contentRepository, MemberRepository memberRepository) {
        this.likesRepository = likesRepository;
        this.contentRepository = contentRepository;
        this.memberRepository = memberRepository;
    }

    public List<Likes> getAllLikes(){
        return likesRepository.findAll();
    }

    public Long getMemberId(String loginId){
        return memberRepository.findByLoginId(loginId).getId();
    }

    public List<Likes> getAllByMember(Long memberId) {
        return likesRepository.findAllByMember(memberRepository.findById(memberId).get());
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
            if (Objects.equals(likes.getContent().getId(), likesDto.getContentId())){
                throw new IllegalStateException("이미 선호 등록한 작품입니다.");
            }
        }
    }

    public void deleteLikes(LikesDto likesDto){
        List<Likes> foundLikesByMember = likesRepository.findAllByMember(memberRepository.findById(likesDto.getMemberId()).get());
        Likes foundLikes = null;

        for (Likes likes: foundLikesByMember){
            if (likes.getContent().getId() == likesDto.getContentId()){
                foundLikes = likes;
            }
        }

        if (foundLikes == null) {
            throw new IllegalStateException("등록되지 않은 작품입니다.");
        } else {
            likesRepository.delete(foundLikes);
        }
    }

}
