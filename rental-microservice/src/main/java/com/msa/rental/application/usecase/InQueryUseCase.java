package com.msa.rental.application.usecase;

import com.msa.rental.framework.web.dto.RentalCardOutputDto;
import com.msa.rental.framework.web.dto.RentalItemOutputDto;
import com.msa.rental.framework.web.dto.ReturnItemOutputDto;
import com.msa.rental.framework.web.dto.UserItemInputDto;

import java.util.List;

public interface InQueryUseCase {

    RentalCardOutputDto getRentalCard(UserItemInputDto inputDto);

    List<RentalItemOutputDto> getAllRentalItem(UserItemInputDto inputDto);

    List<ReturnItemOutputDto> getAllReturnItem(UserItemInputDto inputDto);
}
