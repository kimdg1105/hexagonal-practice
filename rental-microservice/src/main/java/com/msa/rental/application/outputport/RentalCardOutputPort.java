package com.msa.rental.application.outputport;

import com.msa.rental.domain.model.RentalCard;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalCardOutputPort {
    RentalCard getRentalCardByUserId(String userId);

    RentalCard save(RentalCard rentalCard);

}
