package com.msa.member.application.usecase;

import com.msa.member.domain.vo.IDName;
import com.msa.member.framework.web.dto.MemberOutputDto;

public interface UsePointUseCase {
    MemberOutputDto usePoint(IDName idName, Integer point);
}
