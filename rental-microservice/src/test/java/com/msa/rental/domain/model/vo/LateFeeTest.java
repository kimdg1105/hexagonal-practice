package com.msa.rental.domain.model.vo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LateFeeTest {
    private LateFee lateFee = LateFee.create(1000);

    @BeforeEach
    void setUp() {
        lateFee = LateFee.create(1000);
    }

    @DisplayName("LateFee 증가 테스트")
    @Test
    void addPoint() {
        LateFee newLateFee = lateFee.addPoint(1000);
        assertThat(newLateFee.getPoint()).isEqualTo(2000);
    }

    @DisplayName("LateFee 초과 감소시 IllegalArgumentException 발생 테스트")
    @Test
    void removePoint() {
        assertThrows(IllegalArgumentException.class, () -> {
            lateFee.removePoint(2000);
        });
    }
}
