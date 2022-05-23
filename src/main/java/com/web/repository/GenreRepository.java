package com.web.repository;

import com.web.domain.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GenreRepository extends JpaRepository<Genre, Long> {
//    Optional<Genre> findById(Long id);
}
