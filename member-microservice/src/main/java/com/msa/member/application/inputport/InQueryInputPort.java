package com.msa.member.application.inputport;

import com.msa.member.application.mapper.MemberMapper;
import com.msa.member.application.outputport.MemberOutputPort;
import com.msa.member.application.usecase.InQueryUseCase;
import com.msa.member.domain.model.Member;
import com.msa.member.framework.web.dto.MemberOutputDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class InQueryInputPort implements InQueryUseCase {
    private final MemberOutputPort memberOutputPort;
    private final MemberMapper memberMapper;

    @Override
    public MemberOutputDto getMember(Long memberNo) {
        Member member = memberOutputPort.getByMemberNo(memberNo);
        return memberMapper.toMemberOutputDto(member);
    }
}
