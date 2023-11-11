package com.msa.rental.framework.web.dto;

import java.time.LocalDate;

public record ReturnItemOutputDto(
        Integer itemNo,
        String itemTitle,
        LocalDate returnDate
) {
}
