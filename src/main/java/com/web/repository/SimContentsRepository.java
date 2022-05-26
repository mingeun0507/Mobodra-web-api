package com.web.repository;

import com.web.domain.SimContents;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SimContentsRepository extends JpaRepository<SimContents, Long> {
    Optional<SimContents> findById(Long id);
}
