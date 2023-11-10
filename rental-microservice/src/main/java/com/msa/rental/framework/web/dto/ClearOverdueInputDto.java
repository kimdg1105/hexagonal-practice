package com.msa.rental.framework.web.dto;

public record ClearOverdueInputDto(
        String userId,
        String userName,
        Integer point
) {
}
