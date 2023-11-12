package com.msa.member.application.usecase;

import com.msa.member.framework.web.dto.MemberInfoDto;
import com.msa.member.framework.web.dto.MemberOutputDto;

public interface CreateMemberUseCase {
    MemberOutputDto createMember(MemberInfoDto memberInfoDto);
}
