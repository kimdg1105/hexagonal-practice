package com.msa.rental.application.usecase;

import com.msa.rental.framework.web.dto.RentalCardOutputDto;
import com.msa.rental.framework.web.dto.UserItemInputDto;

public interface RentItemUseCase {
    RentalCardOutputDto rentItem(UserItemInputDto inputDto);
}
