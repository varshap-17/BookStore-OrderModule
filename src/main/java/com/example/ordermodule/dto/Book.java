package com.example.ordermodule.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private Long bookId;
    private String bookName;
    private String authorName;
    private String bookDescription;
    private String bookImage;
    private Integer price;
    private Integer quantity;
}
