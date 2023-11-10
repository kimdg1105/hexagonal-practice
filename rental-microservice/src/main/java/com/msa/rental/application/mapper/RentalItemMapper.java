package com.msa.rental.application.mapper;

import com.msa.rental.domain.model.RentalCard;
import com.msa.rental.framework.web.dto.RentalResultOutputDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RentalItemMapper {

    @Mapping(source = "rentalCard.member.id", target = "userId")
    @Mapping(source = "rentalCard.member.name", target = "userName")
    @Mapping(source = "rentalCard", target = "rentCount", qualifiedByName = "getRentCount")
    @Mapping(source = "rentalCard.lateFee.point", target = "totalLateFee")
    RentalResultOutputDto toRentalResultOutputDto(RentalCard rentalCard);

    @Named("getRentCount")
    default Integer getRentCount(RentalCard rentalCard) {
        return rentalCard.getRentalItemList().size();
    }
}
