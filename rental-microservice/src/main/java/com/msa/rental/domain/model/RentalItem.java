package com.msa.rental.domain.model;

import com.msa.rental.domain.model.vo.Item;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class RentalItem {
    private Item item;
    private LocalDate rentalDate;
    private LocalDate overdueDate;
    private boolean overdue;

    public static RentalItem create(Item item, LocalDate localDate) {
        RentalItem rentalItem = new RentalItem();
        rentalItem.item = item;
        rentalItem.rentalDate = localDate;
        rentalItem.overdueDate = localDate.plusDays(7);
        rentalItem.overdue = false;

        return rentalItem;
    }

    public boolean isOverdue() {
        boolean result = LocalDate.now().isAfter(this.overdueDate);
        if (result) {
            this.overdue();
        }
        return result;
    }

    protected void overdue() {
        this.overdue = true;
    }


}
