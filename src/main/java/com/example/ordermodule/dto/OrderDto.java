package com.example.ordermodule.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderDto {
    public long userid;
    public long bookId;
    public String address;
    public int quantity;
    public int price;
}
