package com.msa.rental.application.usecase;

import com.msa.rental.framework.web.dto.RentalCardCreateOutputDto;
import com.msa.rental.framework.web.dto.UserItemInputDto;

public interface MakeOverdueItemUseCase {
    RentalCardCreateOutputDto makeOverdueItem(UserItemInputDto inputDto);
}
