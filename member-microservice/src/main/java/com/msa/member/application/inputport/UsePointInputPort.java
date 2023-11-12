package com.msa.member.application.inputport;

import com.msa.member.application.mapper.MemberMapper;
import com.msa.member.application.outputport.MemberOutputPort;
import com.msa.member.application.usecase.UsePointUseCase;
import com.msa.member.domain.model.Member;
import com.msa.member.domain.vo.IDName;
import com.msa.member.framework.web.dto.MemberOutputDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UsePointInputPort implements UsePointUseCase {
    private final MemberOutputPort memberOutputPort;
    private final MemberMapper memberMapper;


    @Override
    public MemberOutputDto usePoint(IDName idName, Integer point) {
        Member member = memberOutputPort.getByIdName(idName);
        member.usePoint(point);
        return memberMapper.toMemberOutputDto(member);
    }
}
