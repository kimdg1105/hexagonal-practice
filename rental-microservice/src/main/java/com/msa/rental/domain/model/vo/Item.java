package com.msa.rental.domain.model.vo;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class Item {
    private final Integer no;
    private final String title;

    public static Item create(Integer no, String title) {
        return new Item(no, title);
    }
}
