package com.msa.member.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Email {
    private String address;

    public static Email create(String address) {
        return new Email(address);
    }
}
