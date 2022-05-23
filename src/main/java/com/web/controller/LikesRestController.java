package com.web.controller;

import com.web.domain.Likes;
import com.web.dto.LikesDto;
import com.web.service.LikesService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
}