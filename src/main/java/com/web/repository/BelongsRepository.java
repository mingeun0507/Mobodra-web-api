package com.web.repository;

import com.web.domain.Belongs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BelongsRepository extends JpaRepository<Belongs, Long> {
//    Optional<Belongs> findById(Long id);

//    @Query("select * from BELONGS, ")
//    List<Belongs> findAllByContent_Id();
}
