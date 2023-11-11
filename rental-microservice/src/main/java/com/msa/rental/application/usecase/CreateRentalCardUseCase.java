package com.msa.rental.application.usecase;

import com.msa.rental.framework.web.dto.RentalCardCreateInputDto;
import com.msa.rental.framework.web.dto.RentalCardOutputDto;

public interface CreateRentalCardUseCase {
    RentalCardOutputDto createRentalCard(RentalCardCreateInputDto inputDto);
}
