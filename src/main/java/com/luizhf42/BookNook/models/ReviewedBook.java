package com.luizhf42.BookNook.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "reviewed_books")
public class ReviewedBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String user_id;
    private String book_id;

    @Enumerated(EnumType.STRING)
    private ReviewType review_type;

    public enum ReviewType {
        LIKE, DISLIKE
    }
}

