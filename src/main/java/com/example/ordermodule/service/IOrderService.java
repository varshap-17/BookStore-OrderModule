package com.example.ordermodule.service;

import com.example.ordermodule.dto.OrderDto;
import com.example.ordermodule.model.OrderData;

import java.util.List;

public interface IOrderService {
    public OrderData createOrder(OrderDto orderDto);
    public OrderData updateOrder(Long orderId,OrderDto orderDto);
    public List<OrderData> orderDataList();
    public OrderData findById(Long orderId);
    public OrderData cancelOrder(Long orderId);
}
