package com.msa.member.framework.jpaadapter.repository;

import com.msa.member.domain.model.Member;
import com.msa.member.domain.vo.IDName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByIdName(IDName idName);
}
