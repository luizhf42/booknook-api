package com.luizhf42.BookNook.controllers;

import com.luizhf42.BookNook.models.BookByIdResponse;
import com.luizhf42.BookNook.models.SearchBooksResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/books")
public class BooksController {
    WebClient client = WebClient.create("https://www.googleapis.com/books/v1/volumes");
    String apiKey = System.getenv("API_KEY");

    @GetMapping
    public ResponseEntity<Object> searchBooks(@RequestParam String q) {
        SearchBooksResponse books = client.get().uri(uriBuilder -> uriBuilder
                        .queryParam("q", q)
                        .queryParam("key", apiKey)
                        .build())
                .retrieve().bodyToMono(SearchBooksResponse.class).block();

        return books.hasItems() ? ResponseEntity.notFound().build() : ResponseEntity.ok(books);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getBookById(@PathVariable String id) {
        BookByIdResponse book;
        try {
            book = client.get().uri(uriBuilder -> uriBuilder
                            .path("/" + id)
                            .queryParam("fields", "volumeInfo(title,authors,publisher,publishedDate,description,pageCount,categories,imageLinks,industryIdentifiers,infoLink),saleInfo(country,saleability,listPrice,buyLink)")
                            .build())
                    .retrieve().bodyToMono(BookByIdResponse.class).block();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(String.format("Book of ID %s not found", id));
        }

        return ResponseEntity.ok(book);
    }
}

