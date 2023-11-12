package com.msa.member.application.inputport;

import com.msa.member.application.mapper.MemberMapper;
import com.msa.member.application.outputport.MemberOutputPort;
import com.msa.member.application.usecase.CreateMemberUseCase;
import com.msa.member.domain.model.Member;
import com.msa.member.domain.vo.Email;
import com.msa.member.domain.vo.IDName;
import com.msa.member.domain.vo.Password;
import com.msa.member.framework.web.dto.MemberInfoDto;
import com.msa.member.framework.web.dto.MemberOutputDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CreateMemberInputPort implements CreateMemberUseCase {
    private final MemberOutputPort memberOutputPort;

    private final MemberMapper memberMapper;

    @Override
    public MemberOutputDto createMember(MemberInfoDto memberInfoDto) {
        Member member = Member.create(
                IDName.create(memberInfoDto.id(), memberInfoDto.name()),
                Password.create(memberInfoDto.password()),
                Email.create(memberInfoDto.email())
        );
        memberOutputPort.save(member);
        return memberMapper.toMemberOutputDto(member);
    }
}
