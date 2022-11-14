package com.example.ordermodule.model;

import com.example.ordermodule.dto.OrderDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long orderId;
    private long userid;
    private long bookId;
    private int price;
    private int quantity;
    private String address;
    private LocalDate date=LocalDate.now();
    private boolean cancel;

    public OrderData(OrderDto orderDto){
        this.userid=orderDto.userid;
        this.bookId=orderDto.bookId;
        this.quantity=orderDto.quantity;
        this.address=orderDto.address;
        this.price=orderDto.price;
    }

    public OrderData(long userid, Long bookId, String address, int quantity, int price) {
        this.userid=userid;
        this.bookId=bookId;
        this.address=address;
        this.quantity=quantity;
        this.price=price;
    }
}
