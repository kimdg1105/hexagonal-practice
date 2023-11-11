package com.msa.rental.framework.web.dto;


public record RentalCardOutputDto(
        String rentalCardId,
        String memberId,
        String memberName,
        String rentalCardStatus,
        Integer totalLateFee,
        Integer totalRentalCount,
        Integer totalReturnCount,
        Integer totalOverdueCount
) {
}
