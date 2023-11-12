package com.msa.member.application.mapper;

import com.msa.member.domain.model.Member;
import com.msa.member.framework.web.dto.MemberOutputDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MemberMapper {

    @Mapping(source = "member.idName.id", target = "id")
    @Mapping(source = "member.idName.name", target = "name")
    @Mapping(source = "member.password.currentPassword", target = "password")
    @Mapping(source = "member.email.address", target = "email")
    @Mapping(source = "member.point.point", target = "point")
    MemberOutputDto toMemberOutputDto(Member member);
}
