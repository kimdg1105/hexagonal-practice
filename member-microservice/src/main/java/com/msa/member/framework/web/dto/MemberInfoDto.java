package com.msa.member.framework.web.dto;

public record MemberInfoDto(
        String id,
        String name,
        String password,
        String email
) {
}
