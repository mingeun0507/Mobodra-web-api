package com.web.controller;

import com.web.domain.Likes;
import com.web.dto.ContentDto;
import com.web.service.ContentService;
import com.web.service.LikesService;
import com.web.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

    @GetMapping
    public List<ContentDto> getUserSimContents(HttpServletRequest req) {
        String loginId = (String) req.getSession().getAttribute("loginId");
        List<Likes> likesList = likesService.getAllByMember(memberService.getMemberByLoginId(loginId).getId());

        return contentService.get16SimContentsList(contentService.getSimIdList(likesList));
    }

}
