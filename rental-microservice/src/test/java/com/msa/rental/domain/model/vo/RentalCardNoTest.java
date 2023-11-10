package com.msa.rental.domain.model.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class RentalCardNoTest {
    @DisplayName("대여카드번호 생성 테스트")
    @Test
    void testRentalCardNo() {
        RentalCardNo rentalCardNo = RentalCardNo.create();

        assertThat(rentalCardNo)
                .isNotNull()
                .hasFieldOrPropertyWithValue("no", rentalCardNo.getNo());
        assertThat(rentalCardNo.getNo())
                .startsWith(String.valueOf(LocalDate.now().getYear()));
    }
}
