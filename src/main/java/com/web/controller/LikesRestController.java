package com.web.controller;

import com.web.domain.Likes;
import com.web.dto.LikesDto;
import com.web.service.LikesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    public String createLikes(@RequestBody LikesDto likesDto){
        try {
            likesService.saveLikes(likesDto);
            return "true";
        } catch (IllegalStateException e){
            System.out.println(e.getMessage());
            return "false";
        }
    }
}
