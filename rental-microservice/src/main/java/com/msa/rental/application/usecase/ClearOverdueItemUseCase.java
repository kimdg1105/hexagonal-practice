package com.msa.rental.application.usecase;

import com.msa.rental.framework.web.dto.ClearOverdueInputDto;
import com.msa.rental.framework.web.dto.RentalCardOutputDto;

public interface ClearOverdueItemUseCase {
    RentalCardOutputDto clearOverdueItem(ClearOverdueInputDto inputDto);
}
