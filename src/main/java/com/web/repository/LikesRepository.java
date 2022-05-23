package com.web.repository;

import com.web.domain.Likes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikesRepository extends JpaRepository<Likes, Long> {
//    Optional<Likes> findById(Long id);
}
