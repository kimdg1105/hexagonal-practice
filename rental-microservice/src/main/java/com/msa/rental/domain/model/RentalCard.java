package com.msa.rental.domain.model;

import com.msa.rental.domain.model.vo.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RentalCard {
    private RentalCardNo renalCardNo;
    private IDName member;
    private RentStatus rentStatus;
    private LateFee lateFee;
    private List<RentalItem> rentalItemList = new ArrayList<>();
    private List<ReturnItem> returnItemList = new ArrayList<>();

    public RentalCard(RentalCardNo renalCardNo, IDName member, RentStatus rentStatus, LateFee lateFee) {
        this.renalCardNo = renalCardNo;
        this.member = member;
        this.rentStatus = rentStatus;
        this.lateFee = lateFee;
    }

    public static RentalCard create(IDName member) {
        return new RentalCard(RentalCardNo.create(), member, RentStatus.RENT_AVAILABLE, LateFee.create(0));
    }

    public RentalCard rentItem(Item item) {
        checkRentalAvailable();
        checkRentalItemMaxCount();
        RentalItem rentalItem = RentalItem.create(item, LocalDate.now());
        addRentalItem(rentalItem);
        return this;
    }

    public RentalCard returnItem(Item item, LocalDate returnDate) {
        this.rentalItemList.stream()
                .filter(rentalItem -> rentalItem.getItem().equals(item))
                .findFirst()
                .ifPresent(rentalItem -> {
                    calculateLateFee(rentalItem, returnDate);
                    ReturnItem returnItem = ReturnItem.create(rentalItem);
                    addReturnItem(returnItem);
                    removeRentalItem(rentalItem);
                });
        return this;
    }

    public RentalCard overdueItem(Item item) {
        rentalItemList.stream()
                .filter(rentalItem -> rentalItem.getItem().equals(item))
                .findFirst()
                .ifPresent(rentalItem -> {
                    rentalItem.overdue();
                    this.rentStatus = RentStatus.RENT_UNAVAILABLE;
                });
        return this;

    }

    public Integer makeRentalCardAvailable(int point) {
        checkRentalItemListIsEmpty();
        checkLateFeeIsSmallerThanPoint(point);

        this.lateFee = this.lateFee.removePoint(point);
        if (lateFee.getPoint() == 0) {
            this.rentStatus = RentStatus.RENT_AVAILABLE;
        }
        return this.lateFee.getPoint();
    }

    private void checkLateFeeIsSmallerThanPoint(int point) {
        if (this.lateFee.getPoint() > point) {
            throw new IllegalArgumentException("포인트가 부족합니다.");
        }
    }

    private void calculateLateFee(RentalItem rentalItem, LocalDate returnDate) {
        if (rentalItem.checkOverdue()) {
            int point = Period.between(rentalItem.getOverdueDate(), returnDate).getDays() * 10;
            this.lateFee.addPoint(point);
        }

    }

    private void checkRentalItemMaxCount() {
        if (this.rentalItemList.size() > 5) {
            throw new IllegalStateException("대여 가능한 아이템의 수를 초과하였습니다.");
        }
    }

    private void checkRentalItemListIsEmpty() {
        if (!this.rentalItemList.isEmpty()) {
            throw new IllegalStateException("반납되지 않은 아이템이 있습니다.");
        }
    }

    private void checkRentalAvailable() {
        if (this.rentStatus == RentStatus.RENT_UNAVAILABLE) {
            throw new IllegalStateException("대여 불가능한 상태입니다.");
        }
    }

    private void addRentalItem(RentalItem rentalItem) {
        rentalItemList.add(rentalItem);
    }

    private void removeRentalItem(RentalItem rentalItem) {
        rentalItemList.remove(rentalItem);
    }

    private void addReturnItem(ReturnItem returnItem) {
        returnItemList.add(returnItem);
    }

    private void removeReturnItem(ReturnItem returnItem) {
        returnItemList.remove(returnItem);
    }
}
