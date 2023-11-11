package com.msa.rental.framework.web.dto;

import java.time.LocalDate;

public record RentalItemOutputDto(Integer itemNo,
                                  String itemTitle,
                                  LocalDate rentDate,
                                  boolean overdue,
                                  LocalDate overdueDate) {
}
