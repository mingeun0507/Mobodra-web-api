package com.web.controller;

import com.web.domain.Likes;
import com.web.dto.ContentDto;
import com.web.service.ContentService;
import com.web.service.LikesService;
import com.web.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/main")
@RequiredArgsConstructor
public class ContentRestController {
    private ContentService contentService;

    private LikesService likesService;

    private MemberService memberService;

    @Autowired
    public ContentRestController(ContentService contentService, LikesService likesService, MemberService memberService) {
        this.contentService = contentService;
        this.likesService = likesService;
        this.memberService = memberService;
    }

    @GetMapping(value = "", headers = "loginId")
    public List<ContentDto> getUserSimContents(@RequestHeader String loginId) {
        List<Likes> likesList = likesService.getAllByMember(memberService.getMemberByLoginId(loginId).getId());
        List<ContentDto> contentDtoList = contentService.get16SimContentsList(contentService.getSimIdList(likesList));
        for (Likes likes: likesList) {
            contentDtoList.removeIf(contentDto -> Objects.equals(likes.getContent().getId(), contentDto.getId()));
        }

        return contentDtoList;
    }

    @GetMapping(value = "/total")
    public List<ContentDto> getAllContents(){
        return contentService.getContents();
    }

}
