package com.msa.rental.application.inputport;

import com.msa.rental.application.mapper.RentalCardMapper;
import com.msa.rental.application.mapper.RentalItemMapper;
import com.msa.rental.application.outputport.RentalCardOutputPort;
import com.msa.rental.application.usecase.InQueryUseCase;
import com.msa.rental.domain.model.RentalCard;
import com.msa.rental.framework.web.dto.RentalCardOutputDto;
import com.msa.rental.framework.web.dto.RentalItemOutputDto;
import com.msa.rental.framework.web.dto.ReturnItemOutputDto;
import com.msa.rental.framework.web.dto.UserInputDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class InQueryInputPort implements InQueryUseCase {
    private final RentalCardOutputPort rentalCardOutputPort;

    private final RentalCardMapper rentalCardMapper;
    private final RentalItemMapper rentalItemMapper;

    @Override
    public RentalCardOutputDto getRentalCard(UserInputDto inputDto) {
        RentalCard rentalCard = rentalCardOutputPort.getRentalCardByUserId(inputDto.userId());
        return rentalCardMapper.toRentalCardOutputDto(rentalCard);
    }

    @Override
    public List<RentalItemOutputDto> getAllRentalItem(UserInputDto inputDto) {
        RentalCard rentalCard = rentalCardOutputPort.getRentalCardByUserId(inputDto.userId());
        return rentalCard.getRentalItemList().stream().map(rentalItemMapper::toRentalItemOutputDto).toList();
    }

    @Override
    public List<ReturnItemOutputDto> getAllReturnItem(UserInputDto inputDto) {
        RentalCard rentalCard = rentalCardOutputPort.getRentalCardByUserId(inputDto.userId());
        return rentalCard.getReturnItemList().stream().map(rentalItemMapper::toReturnItemOutputDto).toList();
    }
}
