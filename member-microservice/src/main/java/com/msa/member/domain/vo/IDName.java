package com.msa.member.domain.vo;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class IDName {
    private String id;
    private String name;

    public static IDName create(String id, String name) {
        return new IDName(id, name);
    }
}
