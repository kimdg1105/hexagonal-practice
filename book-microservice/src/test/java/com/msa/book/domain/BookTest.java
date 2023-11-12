package com.msa.book.domain;

import com.msa.book.domain.vo.Classification;
import com.msa.book.domain.vo.Location;
import com.msa.book.domain.vo.Source;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@Slf4j
@SpringBootTest
class BookTest {

    @Test
    void domainTest() {
        log.info("------------도메인 모델 테스트 진행------------");

        log.info("도서1 입고");
        Book book = Book.enterBook("노인과바다", "훼밍웨이",
                "2312321",
                "주인공 노인과 바다",
                LocalDate.now(),
                Classification.LITERATURE,
                Source.SUPPLIED,
                Location.PANGYO);
        log.info(book.toString());

        log.info("도서1 입고 --> 대여가능 처리");
        book.makeAvailable();

        log.info(book.getStatus().toString());
    }

}
