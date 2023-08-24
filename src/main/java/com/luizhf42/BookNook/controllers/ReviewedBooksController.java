package com.luizhf42.BookNook.controllers;
import com.luizhf42.BookNook.models.ReviewedBook;
import com.luizhf42.BookNook.repositories.ReviewedBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("reviews")
public class ReviewedBooksController {

    @Autowired
    private ReviewedBookRepository reviewedBookRepository;

    @GetMapping
    public List<ReviewedBook> getAllReviewedBooks() {
        return reviewedBookRepository.findAll();
    }

    @PostMapping
    public ReviewedBook addReviewedBook(@RequestBody ReviewedBook reviewedBook) {
        return reviewedBookRepository.save(reviewedBook);
    }
}

