package com.msa.book.framework.jpaadapter.repository;

import com.msa.book.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookJpaRepository extends JpaRepository<Book, Long> {
}
