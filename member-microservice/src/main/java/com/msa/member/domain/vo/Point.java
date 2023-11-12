package com.msa.member.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Point {
    private int value;

    public static Point create() {
        return new Point(0);
    }

    public int add(int value) {
        this.value += value;
        return this.value;
    }

    public int subtract(int value) {
        if (this.value < value)
            throw new IllegalArgumentException("포인트가 부족합니다.");

        this.value -= value;
        return this.value;
    }
}

