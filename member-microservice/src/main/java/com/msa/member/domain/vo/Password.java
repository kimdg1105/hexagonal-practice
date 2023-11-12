package com.msa.member.domain.vo;


import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Password {
    private String currentPassword;
    private String pastPassword;

    public static Password create(String currentPassword) {
        return new Password(currentPassword, null);
    }
}
