package com.msa.rental.framework.web;

import com.msa.rental.application.usecase.*;
import com.msa.rental.framework.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rentals")
@RequiredArgsConstructor
public class RentalController {
    private final RentItemUseCase rentItemUseCase;
    private final ReturnItemUseCase returnItemUseCase;
    private final CreateRentalCardUseCase createRentalCardUseCase;
    private final MakeOverdueItemUseCase makeOverdueItemUseCase;
    private final ClearOverdueItemUseCase clearOverdueItemUseCase;
    private final InQueryUseCase inQueryUseCase;


    @PostMapping("/cards")
    public ResponseEntity<RentalCardOutputDto> createRentalCard(@RequestBody RentalCardCreateInputDto inputDto) {
        RentalCardOutputDto responseDto = createRentalCardUseCase.createRentalCard(inputDto);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/cards/users/{userId}")
    public ResponseEntity<RentalCardOutputDto> getRentalCard(@PathVariable String userId) {
        // TODO : refactor
        return ResponseEntity.ok(inQueryUseCase.getRentalCard(new UserInputDto(userId, null)));
    }

    @GetMapping("/users/{userId}/rents")
    public ResponseEntity<List<RentalItemOutputDto>> getAllRentalItem(@PathVariable String userId) {
        return ResponseEntity.ok(inQueryUseCase.getAllRentalItem(new UserInputDto(userId, null)));
    }

    @GetMapping("/users/{userId}/returns")
    public ResponseEntity<List<ReturnItemOutputDto>> getAllReturnItem(@PathVariable String userId) {
        return ResponseEntity.ok(inQueryUseCase.getAllReturnItem(new UserInputDto(userId, null)));
    }

    @PostMapping("/rents")
    public ResponseEntity<RentalCardOutputDto> rentItem(@RequestBody UserItemInputDto inputDto) {
        RentalCardOutputDto responseDto = rentItemUseCase.rentItem(inputDto);
        return ResponseEntity.ok(responseDto);
    }

    @PostMapping("/returns")
    public ResponseEntity<RentalCardOutputDto> returnItem(@RequestBody UserItemInputDto inputDto) {
        RentalCardOutputDto responseDto = returnItemUseCase.returnItem(inputDto);
        return ResponseEntity.ok(responseDto);
    }

    @PostMapping("/overdue")
    public ResponseEntity<RentalCardOutputDto> makeOverdueItem(@RequestBody UserItemInputDto inputDto) {
        RentalCardOutputDto responseDto = makeOverdueItemUseCase.makeOverdueItem(inputDto);
        return ResponseEntity.ok(responseDto);
    }

    @PostMapping("/overdue/clear")
    public ResponseEntity<RentalCardOutputDto> clearOverdueItem(@RequestBody ClearOverdueInputDto inputDto) {
        RentalCardOutputDto responseDto = clearOverdueItemUseCase.clearOverdueItem(inputDto);
        return ResponseEntity.ok(responseDto);
    }
}
