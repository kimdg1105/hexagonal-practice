package com.msa.rental.framework.web.dto;

public record RentalResultOutputDto(
        String userId,
        String userName,
        Integer rentCount,
        Integer totalLateFee
) {
}
