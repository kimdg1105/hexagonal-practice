package com.msa.rental.framework.jpaadapter.repository;

import com.msa.rental.domain.model.RentalCard;
import com.msa.rental.domain.model.vo.RentalCardNo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RentalCardJpaRepository extends JpaRepository<RentalCard, RentalCardNo> {
    Optional<RentalCard> findByMember_Id(String userId);

    Optional<RentalCard> findByRenalCardNo_No(String rentalCardNo);
}
