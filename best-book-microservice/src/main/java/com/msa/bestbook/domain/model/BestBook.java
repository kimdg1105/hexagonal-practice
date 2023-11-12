package com.msa.bestbook.domain.model;

import com.msa.bestbook.domain.vo.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class BestBook {
    @Id
    private String id;
    private Item item;
    private Integer rentCount;

    public static BestBook create(Item item) {
        UUID uuid = UUID.randomUUID();
        BestBook bestBook = new BestBook();
        bestBook.id = uuid.toString();
        bestBook.item = item;
        bestBook.rentCount = 1;
        return bestBook;
    }

    public Integer increaseRentCount() {
        this.rentCount++;
        return this.rentCount;
    }
}
