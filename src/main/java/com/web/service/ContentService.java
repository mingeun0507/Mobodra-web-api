package com.web.service;

import com.web.domain.Content;
import com.web.dto.ContentDto;
import com.web.repository.ContentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ContentService {

    @Autowired
    private ContentRepository contentRepository;

    public List<ContentDto> getContents() {
        List<Content> contentList = contentRepository.findAll();
        List<ContentDto> contentDtoList = new ArrayList<>();

        for (Content content: contentList){
            ContentDto contentDto = new ContentDto(content.getType(), content.getTitle(), content.getYear());
            contentDtoList.add(contentDto);
        }

        return contentDtoList;
    }
}
