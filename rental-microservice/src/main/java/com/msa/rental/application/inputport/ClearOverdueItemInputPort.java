package com.msa.rental.application.inputport;

import com.msa.rental.application.mapper.RentalCardMapper;
import com.msa.rental.application.outputport.RentalCardOutputPort;
import com.msa.rental.application.usecase.ClearOverdueItemUseCase;
import com.msa.rental.domain.model.RentalCard;
import com.msa.rental.framework.web.dto.ClearOverdueInputDto;
import com.msa.rental.framework.web.dto.RentalCardOutputDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@RequiredArgsConstructor
public class ClearOverdueItemInputPort implements ClearOverdueItemUseCase {
    private final RentalCardOutputPort rentalCardOutputPort;

    private final RentalCardMapper rentalCardMapper;

    @Override
    public RentalCardOutputDto clearOverdueItem(ClearOverdueInputDto inputDto) {
        RentalCard rentalCard = rentalCardOutputPort.getRentalCardByUserId(inputDto.userId());

        rentalCard.makeRentalCardAvailable(inputDto.point());
        return rentalCardMapper.toRentalCardOutputDto(rentalCard);
    }
}
