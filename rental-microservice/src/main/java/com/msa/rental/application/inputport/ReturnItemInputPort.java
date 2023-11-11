package com.msa.rental.application.inputport;

import com.msa.rental.application.mapper.RentalCardMapper;
import com.msa.rental.application.outputport.RentalCardOutputPort;
import com.msa.rental.application.usecase.RentItemUseCase;
import com.msa.rental.domain.model.RentalCard;
import com.msa.rental.domain.model.vo.Item;
import com.msa.rental.framework.web.dto.RentalCardOutputDto;
import com.msa.rental.framework.web.dto.UserItemInputDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@Transactional
@RequiredArgsConstructor
public class ReturnItemInputPort implements RentItemUseCase {
    private final RentalCardOutputPort rentalCardOutputPort;

    private final RentalCardMapper rentalCardMapper;

    @Override
    public RentalCardOutputDto rentItem(UserItemInputDto inputDto) {
        RentalCard rentalCard = rentalCardOutputPort.getRentalCardByUserId(inputDto.userId());

        //TODO: Item 조회 usecase 필요
        Item item = Item.create(inputDto.itemId(), inputDto.itemName());

        rentalCard.returnItem(item, LocalDate.now());
        return rentalCardMapper.toRentalCardOutputDto(rentalCard);
    }
}
