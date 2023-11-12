package com.msa.member.framework.web.dto;

public record MemberOutputDto(
        String id,
        String name,
        String password,
        String email,
        Integer point
) {
}
