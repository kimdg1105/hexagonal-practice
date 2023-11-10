package com.msa.rental.application.usecase;

import com.msa.rental.framework.web.dto.RentalCardCreateInputDto;
import com.msa.rental.framework.web.dto.RentalCardCreateOutputDto;

public interface CreateRentalCardUseCase {
    RentalCardCreateOutputDto createRentalCard(RentalCardCreateInputDto inputDto);
}
