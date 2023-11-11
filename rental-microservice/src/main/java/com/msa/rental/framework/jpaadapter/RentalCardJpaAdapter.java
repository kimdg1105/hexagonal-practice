package com.msa.rental.framework.jpaadapter;

import com.msa.rental.application.outputport.RentalCardOutputPort;
import com.msa.rental.domain.model.RentalCard;
import com.msa.rental.framework.jpaadapter.repository.RentalCardJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class RentalCardJpaAdapter implements RentalCardOutputPort {
    private final RentalCardJpaRepository rentalCardJpaRepository;

    @Override
    public RentalCard getRentalCardByUserId(String userId) {
        return findRentalCardByUserId(userId).orElseThrow(() -> new RuntimeException("rental card not found"));
    }

    private Optional<RentalCard> findRentalCardByUserId(String userId) {
        return rentalCardJpaRepository.findByMember_Id(userId);
    }

    @Override
    public RentalCard save(RentalCard rentalCard) {
        return rentalCardJpaRepository.save(rentalCard);
    }
}
