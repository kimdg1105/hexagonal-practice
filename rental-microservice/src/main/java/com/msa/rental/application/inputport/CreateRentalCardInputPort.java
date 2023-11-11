package com.msa.rental.application.inputport;

import com.msa.rental.application.mapper.RentalCardMapper;
import com.msa.rental.application.outputport.RentalCardOutputPort;
import com.msa.rental.application.usecase.CreateRentalCardUseCase;
import com.msa.rental.domain.model.RentalCard;
import com.msa.rental.domain.model.vo.IDName;
import com.msa.rental.framework.web.dto.RentalCardCreateInputDto;
import com.msa.rental.framework.web.dto.RentalCardOutputDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CreateRentalCardInputPort implements CreateRentalCardUseCase {
    private final RentalCardOutputPort rentalCardOutputPort;

    private final RentalCardMapper rentalCardMapper;


    @Override
    public RentalCardOutputDto createRentalCard(RentalCardCreateInputDto inputDto) {
        RentalCard rentalCard = RentalCard.create(IDName.create(inputDto.userId(), inputDto.userName()));
        RentalCard result = rentalCardOutputPort.save(rentalCard);
        return rentalCardMapper.toRentalCardOutputDto(result);
    }
}
