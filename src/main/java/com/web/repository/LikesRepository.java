package com.web.repository;

import com.web.domain.Content;
import com.web.domain.Likes;
import com.web.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LikesRepository extends JpaRepository<Likes, Long> {
    List<Likes> findAllByContent(Content content);
    List<Likes> findAllByMember(Member member);
}
