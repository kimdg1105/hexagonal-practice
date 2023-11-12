package com.msa.member.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IDName {
    private String id;
    private String name;

    public static IDName create(String id, String name) {
        return new IDName(id, name);
    }
}
