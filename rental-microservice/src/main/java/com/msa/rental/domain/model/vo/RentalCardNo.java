package com.msa.rental.domain.model.vo;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@Embeddable
public class RentalCardNo implements Serializable {
    private String no;

    public static RentalCardNo create() {
        UUID uuid = UUID.randomUUID();
        String year = String.valueOf(LocalDate.now().getYear());
        String createdNo = createNo(year, uuid);
        RentalCardNo rentalCardNo = new RentalCardNo();
        rentalCardNo.setNo(createdNo);
        return rentalCardNo;
    }

    private static String createNo(String year, UUID uuid) {
        return year + "-" + uuid;
    }
}
