package com.msa.rental.domain.model;

import com.msa.rental.domain.model.vo.IDName;
import com.msa.rental.domain.model.vo.Item;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@Slf4j
@SpringBootTest
class RentalCardTest {

    private static void rentAndShowStatus(RentalCard card, Item item) {
        card.rentItem(item);
        System.out.println(" 도서명: " + item.getTitle() + " 대여됨");
        showCardStatus(card);
    }


    private static void returnAndShowStatus(RentalCard card, Item item) {
        card.returnItem(item, LocalDate.now());
        System.out.println(" 도서명: " + item.getTitle() + " 반납됨");
        showCardStatus(card);
    }


    private static void overdueAndShowStatus(RentalCard card, Item item) {
        card.overdueItem(item);
        System.out.println(" 도서명: " + item.getTitle() + " 강제 연체");
        showCardStatus(card);
    }

    private static void makeAvailableAndShowStatus(RentalCard card) {
        long minusPoint = card.makeRentalCardAvailable(card.getLateFee().getPoint());
        log.info(" 현재 남은 연체료는 " + card.getLateFee().getPoint());
        log.info(" 회원포인트에서 삭감될 포인트는 " + minusPoint);
        showCardStatus(card);
    }

    private static void showCardStatus(RentalCard card) {
        log.info("-----------");
        log.info(card.getMember().getName() + "'s 도서카드 ");
        log.info(" 대여도서 연체상태: " +
                card.getRentalItemList().stream()
                        .map(RentalItem::isOverdue)
                        .toList());
        log.info(" 총 연체료: " + card.getLateFee().getPoint());
        log.info(" 대여가능여부: " + card.getRentStatus().toString());
        log.info(" 대여목록: " + card.getRentalItemList().stream()
                .map(m -> m.getItem().getTitle()).toList());
        log.info(" 반납목록: " + card.getReturnItemList().stream()
                .map(m -> m.getRentalItem().getItem().getTitle()).toList());
        log.info("-----------");

    }

    /*
     * 도서샘플 1,2 생성
     * 도서 1 ,2 대여
     * 도서 1 반납
     * 도서2 강제연체 처리 -> 대여정지됨
     * 도서2 반납 -> 연체료 계산됨
     * 정지해제처리 -> 포인트로 연체료 삭감
     */
    @DisplayName("RentalCard 도메인 테스트")
    @Test
    void domainTest() {
        // given
        IDName idName = new IDName("testId", "testName");
        RentalCard sampleCard = RentalCard.create(idName);
        showCardStatus(sampleCard);
        Item sample1 = new Item(1, "도서1");
        Item sample2 = new Item(2, "도서2");

        // when
        rentAndShowStatus(sampleCard, sample1);
        rentAndShowStatus(sampleCard, sample2);

        returnAndShowStatus(sampleCard, sample1);

        overdueAndShowStatus(sampleCard, sample2);

        returnAndShowStatus(sampleCard, sample2);

        makeAvailableAndShowStatus(sampleCard);
    }

}
