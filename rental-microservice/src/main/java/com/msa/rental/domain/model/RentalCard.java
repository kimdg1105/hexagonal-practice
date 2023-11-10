package com.msa.rental.domain.model;

import com.msa.rental.domain.model.vo.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
