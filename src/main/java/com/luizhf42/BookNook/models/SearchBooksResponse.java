package com.luizhf42.BookNook.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SearchBooksResponse {
    Object items;
    int totalItems;

    public boolean hasItems() {
        return items != null;
    }
}
