package com.web.controller;

import com.web.domain.Content;
import com.web.dto.ContentDto;
import com.web.service.ContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/main")
@RequiredArgsConstructor
public class ContentRestController {
    private final ContentService contentService;

    @GetMapping
    public List<ContentDto> getAllContents() {
        return contentService.getContents();
    }

}
