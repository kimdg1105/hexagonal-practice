package com.msa.member.application.usecase;

import com.msa.member.framework.web.dto.MemberOutputDto;

public interface InQueryUseCase {
    MemberOutputDto getMember(Long memberNo);
}
