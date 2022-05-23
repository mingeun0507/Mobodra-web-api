package com.web.repository;


import com.web.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByLoginId(String LoginId);
//    Optional<Member> findById(Long id);

//    Member findByLoginId(String loginId);

//    List<Member> findAll();
}
