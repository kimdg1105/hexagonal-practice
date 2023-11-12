package com.msa.member.application.outputport;

import com.msa.member.domain.model.Member;
import com.msa.member.domain.vo.IDName;

public interface MemberOutputPort {
    Member getByMemberNo(Long memberNo);

    Member getByIdName(IDName idName);

    Member save(Member member);
}
