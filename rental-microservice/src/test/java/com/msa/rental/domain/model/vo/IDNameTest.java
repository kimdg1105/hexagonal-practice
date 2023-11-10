package com.msa.rental.domain.model.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class IDNameTest {
    @DisplayName("IDName 객체 생성 테스트")
    @Test
    void create() {
        IDName idName = IDName.create("testId", "testName");
        assertThat(idName)
                .hasFieldOrPropertyWithValue("id", "testId")
                .hasFieldOrPropertyWithValue("name", "testName");
    }

}
