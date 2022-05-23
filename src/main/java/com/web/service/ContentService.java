package com.web.service;

import com.web.domain.Content;
import com.web.repository.ContentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ContentService {

    @Autowired
    private ContentRepository contentRepository;

    public List<Content> getContents() {
        return contentRepository.findAll();}
}
