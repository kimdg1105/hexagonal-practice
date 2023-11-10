package com.msa.rental.framework.web.dto;

public record UserItemInputDto(
        String userId,
        String userName,
        String itemId,
        String itemName,
        Integer rentalDayCount) {
}
