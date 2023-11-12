package com.msa.member.framework.jpaadapter;

import com.msa.member.application.outputport.MemberOutputPort;
import com.msa.member.domain.model.Member;
import com.msa.member.domain.vo.IDName;
import com.msa.member.framework.jpaadapter.repository.MemberJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
@RequiredArgsConstructor
public class MemberJpaAdapter implements MemberOutputPort {
    private final MemberJpaRepository memberJpaRepository;

    @Override
    public Member getByMemberNo(Long memberNo) {
        return memberJpaRepository.findById(memberNo)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
    }

    @Override
    public Member getByIdName(IDName idName) {
        return memberJpaRepository.findByIdName(idName)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
    }

    @Override
    public Member save(Member member) {
        return memberJpaRepository.save(member);
    }
}
