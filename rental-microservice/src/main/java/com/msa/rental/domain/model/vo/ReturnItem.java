package com.msa.rental.domain.model.vo;

import com.msa.rental.domain.model.RentalItem;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ReturnItem {
    @Embedded
    private RentalItem rentalItem;
    private LocalDate returnDate;

    public static ReturnItem create(RentalItem rentalItem) {
        return new ReturnItem(rentalItem, LocalDate.now());
    }
}
