package com.msa.rental.framework.web.dto;

public record UserItemInputDto(
        String userId,
        String userName,
        Integer itemId,
        String itemName,
        Integer rentalDayCount) {
}
