package com.msa.rental.application.mapper;

import com.msa.rental.domain.model.RentalCard;
import com.msa.rental.domain.model.RentalItem;
import com.msa.rental.framework.web.dto.RentalCardOutputDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RentalCardMapper {
    @Mapping(source = "rentalCard.renalCardNo.no", target = "rentalCardId")
    @Mapping(source = "rentalCard.member.id", target = "memberId")
    @Mapping(source = "member.name", target = "memberName")
    @Mapping(source = "rentalCard.rentStatus", target = "rentalCardStatus")
    @Mapping(source = "rentalCard.lateFee.point", target = "totalLateFee")
    @Mapping(source = "rentalCard", target = "totalRentalCount", qualifiedByName = "getTotalRentalCount")
    @Mapping(source = "rentalCard", target = "totalReturnCount", qualifiedByName = "getTotalReturnCount")
    @Mapping(source = "rentalCard", target = "totalOverdueCount", qualifiedByName = "getTotalOverdueCount")
    RentalCardOutputDto toRentalCardOutputDto(RentalCard rentalCard);

    @Named("getTotalRentalCount")
    default Integer getTotalRentalCount(RentalCard rentalCard) {
        return rentalCard.getRentalItemList().size();
    }

    @Named("getTotalReturnCount")
    default Integer getTotalReturnCount(RentalCard rentalCard) {
        return rentalCard.getReturnItemList().size();
    }

    @Named("getTotalOverdueCount")
    default Integer getTotalOverdueCount(RentalCard rentalCard) {
        return rentalCard.getRentalItemList()
                .stream().filter(RentalItem::isOverdue)
                .toList()
                .size();
    }
}

