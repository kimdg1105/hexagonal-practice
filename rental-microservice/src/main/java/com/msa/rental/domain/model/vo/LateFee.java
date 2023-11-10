package com.msa.rental.domain.model.vo;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LateFee {
    private int point;

    public static LateFee create(int point) {
        LateFee lateFee = new LateFee();
        lateFee.point = point;
        return lateFee;
    }

    public LateFee addPoint(int point) {
        return create(this.point + point);
    }

    public LateFee removePoint(int point) {
        if (point > this.point) {
            throw new IllegalArgumentException("현재 금액보다 큰 차감은 할 수 없습니다.");
        }
        return create(this.point - point);
    }

}
