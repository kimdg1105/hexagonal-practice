package com.msa.rental.domain.model.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ItemTest {
    @DisplayName("Item 생성 테스트")
    @Test
    void create() {
        Item item = Item.create(1, "item1");
        assertThat(item.getNo()).isEqualTo(1);
        assertThat(item.getTitle()).isEqualTo("item1");
    }
}
