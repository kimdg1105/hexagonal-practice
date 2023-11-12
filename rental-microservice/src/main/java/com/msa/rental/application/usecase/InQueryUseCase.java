package com.msa.rental.application.usecase;

import com.msa.rental.framework.web.dto.RentalCardOutputDto;
import com.msa.rental.framework.web.dto.RentalItemOutputDto;
import com.msa.rental.framework.web.dto.ReturnItemOutputDto;
import com.msa.rental.framework.web.dto.UserInputDto;

import java.util.List;

public interface InQueryUseCase {

    RentalCardOutputDto getRentalCard(UserInputDto inputDto);

    List<RentalItemOutputDto> getAllRentalItem(UserInputDto inputDto);

    List<ReturnItemOutputDto> getAllReturnItem(UserInputDto inputDto);
}
