package com.msa.member.framework.web;

import com.msa.member.application.usecase.CreateMemberUseCase;
import com.msa.member.application.usecase.InQueryUseCase;
import com.msa.member.application.usecase.UsePointUseCase;
import com.msa.member.framework.web.dto.MemberInfoDto;
import com.msa.member.framework.web.dto.MemberOutputDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {
    private final CreateMemberUseCase createMemberUseCase;
    private final UsePointUseCase usePointUseCase;
    private final InQueryUseCase inQueryUseCase;

    @PostMapping
    public ResponseEntity<MemberOutputDto> createMember(@RequestBody MemberInfoDto requestDto) {
        MemberOutputDto response = createMemberUseCase.createMember(requestDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{memberNo}")
    public ResponseEntity<MemberOutputDto> getMember(@PathVariable Long memberNo) {
        MemberOutputDto response = inQueryUseCase.getMember(memberNo);
        return ResponseEntity.ok(response);
    }
}
