package com.web.service;

import com.web.domain.Content;
import com.web.domain.Likes;
import com.web.domain.SimContents;
import com.web.dto.ContentDto;
import com.web.repository.ContentRepository;
import com.web.repository.LikesRepository;
import com.web.repository.SimContentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
@RequiredArgsConstructor
public class ContentService {

    @Autowired
    private ContentRepository contentRepository;

    @Autowired
    private SimContentsRepository simContentsRepository;

    @Autowired
    private LikesRepository likesRepository;

    public List<ContentDto> getContents() {
        List<Content> contentList = contentRepository.findAll();
        List<ContentDto> contentDtoList = new ArrayList<>();

        for (Content content: contentList){
            ContentDto contentDto = new ContentDto(content.getType(), content.getTitle(), content.getYear());
            contentDtoList.add(contentDto);
        }

        return contentDtoList;
    }

    public List<Long[]> getSimIdList(List<Likes> findLikes) {
        ArrayList<Long[]> simIdArrayList = new ArrayList<>();
        for (Likes likes: findLikes){
            Long[] simIds = new Long[16];
            SimContents findSim = simContentsRepository.
                    findById(likes.getContent().getId()).get();

            simIds[0] = findSim.getSim1();
            simIds[1] = findSim.getSim2();
            simIds[2] = findSim.getSim3();
            simIds[3] = findSim.getSim4();
            simIds[4] = findSim.getSim5();
            simIds[5] = findSim.getSim6();
            simIds[6] = findSim.getSim7();
            simIds[7] = findSim.getSim8();
            simIds[8] = findSim.getSim9();
            simIds[9] = findSim.getSim10();
            simIds[10] = findSim.getSim11();
            simIds[11] = findSim.getSim12();
            simIds[12] = findSim.getSim13();
            simIds[13] = findSim.getSim14();
            simIds[14] = findSim.getSim15();
            simIds[15] = findSim.getSim16();

            simIdArrayList.add(simIds);
        }

        return simIdArrayList;
    }

    public List<ContentDto> get16SimContentsList(List<Long[]> findSimIdList){
        Map<Long, Long> SimIdMap = new HashMap<Long, Long>();
        for (int i = 0; i < findSimIdList.size(); i++){
            for (int j = 0; j < 16; j++){
                if (SimIdMap.containsKey(findSimIdList.get(i)[j])){
                    SimIdMap.replace(findSimIdList.get(i)[j], SimIdMap.get(findSimIdList.get(i)[j]) + 16 - j);
                }
                else {
                    SimIdMap.put(findSimIdList.get(i)[j], (long) (16 - j));
                }
            }
        }

        List<Map.Entry<Long, Long>> entryList = new LinkedList<>(SimIdMap.entrySet());
        entryList.sort((o1, o2) -> (int) (o2.getValue() - o1.getValue()));

        List<ContentDto> contentDtoList = new ArrayList<>();

        for (Map.Entry<Long, Long> entry: entryList){
            ContentDto contentDto = new ContentDto();
            contentDto.setContentType(contentRepository.findById(entry.getKey()).get().getType());
            contentDto.setTitle(contentRepository.findById(entry.getKey()).get().getTitle());
            contentDto.setYear(contentRepository.findById(entry.getKey()).get().getYear());
            contentDtoList.add(contentDto);
        }

        return contentDtoList;
    }



}