package com.web.controller;

import com.web.domain.Likes;
import com.web.dto.LikesDto;
import com.web.service.LikesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/likes")
@RequiredArgsConstructor
public class LikesRestController {

    private final LikesService likesService;

    @GetMapping
    public List<Likes> getAllLikes() {
        return likesService.getAllLikes();
    }

    @PostMapping(value = "/survey")
    public String createLikes(@RequestBody LikesDto likesDto, HttpServletRequest req){

        likesDto.setMemberId(likesService.getMemberId((String) req.getSession().getAttribute("loginId")));

        try {
            likesService.saveLikes(likesDto);
            return "true";
        } catch (IllegalStateException e){
            System.out.println(e.getMessage());
            return "false";
        }
    }

    /* /survey/first 로 POST 받았을 때 - 선호도 조사*/
    @PostMapping(value = "/survey/first")
    public String createLikesFirst(@RequestBody List<LikesDto> likesDtos, HttpServletRequest req){
        System.out.println(req.getSession());
        Long memberId = likesService.getMemberId((String) req.getSession().getAttribute("loginId"));

        for (LikesDto likesDto: likesDtos) {
            likesDto.setMemberId(memberId);

            try {
                likesService.saveLikes(likesDto);
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
                return "false";
            }

        }

        return "true";
    }

    @DeleteMapping(value = "/survey")
    public String deleteLikes(@RequestBody LikesDto likesDto, HttpServletRequest req){

        likesDto.setMemberId(likesService.getMemberId((String) req.getSession().getAttribute("loginId")));

        try {
            likesService.deleteLikes(likesDto);
            return "true";
        } catch (IllegalStateException e){
            System.out.println(e.getMessage());
            return "false";
        }

    }

    /* /survey/first 로 DELETE 받았을 때 - 선호도 재조사를 위해 삭제*/
    @DeleteMapping(value = "/survey/first")
    public String deleteLikesFirst(HttpServletRequest req){
        Long memberId = likesService.getMemberId((String) req.getSession().getAttribute("loginId"));

        List<Likes> likesList = likesService.getAllByMember(memberId);

        for (Likes likes: likesList) {
            LikesDto likesDto = new LikesDto(likes.getMember().getId(), likes.getContent().getId());
            likesService.deleteLikes(likesDto);
        }

        return "true";
    }
}
