package com.luizhf42.BookNook.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookByIdResponse {
    Object volumeInfo;
    Object saleInfo;
}
