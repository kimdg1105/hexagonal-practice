package com.msa.rental.domain.model;

import com.msa.rental.domain.model.vo.Item;

import java.time.LocalDate;

public class RentalItem {
    private Item item;
    private LocalDate rentalDate;
    private LocalDate overdueDate;
    private boolean overdued;

    public static RentalItem create(Item item, LocalDate localDate) {
        RentalItem rentalItem = new RentalItem();
        rentalItem.item = item;
        rentalItem.rentalDate = localDate;
        rentalItem.overdueDate = localDate.plusDays(7);
        rentalItem.overdued = false;

        return rentalItem;
    }

    public void overdue() {
        this.overdued = true;
    }


}
