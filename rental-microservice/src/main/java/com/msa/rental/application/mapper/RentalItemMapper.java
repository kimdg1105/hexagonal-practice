package com.msa.rental.application.mapper;

import com.msa.rental.domain.model.RentalCard;
import com.msa.rental.domain.model.RentalItem;
import com.msa.rental.domain.model.vo.ReturnItem;
import com.msa.rental.framework.web.dto.RentalItemOutputDto;
import com.msa.rental.framework.web.dto.RentalResultOutputDto;
import com.msa.rental.framework.web.dto.ReturnItemOutputDto;
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

    @Mapping(source = "rentalItem.item.no", target = "itemNo")
    @Mapping(source = "rentalItem.item.title", target = "itemTitle")
    @Mapping(source = "rentalItem.rentalDate", target = "rentDate")
    @Mapping(source = "rentalItem.overdue", target = "overdue")
    @Mapping(source = "rentalItem.overdueDate", target = "overdueDate")
    RentalItemOutputDto toRentalItemOutputDto(RentalItem rentalItem);

    @Mapping(source = "returnItem.rentalItem.item.no", target = "itemNo")
    @Mapping(source = "returnItem.rentalItem.item.title", target = "itemTitle")
    @Mapping(source = "returnItem.returnDate", target = "returnDate")
    ReturnItemOutputDto toReturnItemOutputDto(ReturnItem returnItem);

    @Named("getRentCount")
    default Integer getRentCount(RentalCard rentalCard) {
        return rentalCard.getRentalItemList().size();
    }
}
