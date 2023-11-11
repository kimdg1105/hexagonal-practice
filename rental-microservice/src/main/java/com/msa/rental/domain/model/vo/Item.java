package com.msa.rental.domain.model.vo;

import jakarta.persistence.Embeddable;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class Item {
    private Integer no;
    private String title;

    public static Item create(Integer no, String title) {
        return new Item(no, title);
    }
}
