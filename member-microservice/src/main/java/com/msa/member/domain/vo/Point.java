package com.msa.member.domain.vo;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Point {
    private int point;

    public static Point create() {
        return new Point(0);
    }

    public int add(int value) {
        this.point += value;
        return this.point;
    }

    public int subtract(int value) {
        if (this.point < value)
            throw new IllegalArgumentException("포인트가 부족합니다.");

        this.point -= value;
        return this.point;
    }
}

