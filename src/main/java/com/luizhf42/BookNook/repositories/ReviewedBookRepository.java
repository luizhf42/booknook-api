package com.luizhf42.BookNook.repositories;

import com.luizhf42.BookNook.models.ReviewedBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewedBookRepository extends JpaRepository<ReviewedBook, Long> {
}

