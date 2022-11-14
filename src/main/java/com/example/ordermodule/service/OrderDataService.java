package com.example.ordermodule.service;

import com.example.ordermodule.dto.Book;
import com.example.ordermodule.dto.OrderDto;
import com.example.ordermodule.dto.User;
import com.example.ordermodule.exception.OrderDataException;
import com.example.ordermodule.model.OrderData;
import com.example.ordermodule.repository.OrderDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class OrderDataService{
    @Autowired
    OrderDataRepository dataRepository;
    @Autowired
    RestTemplate restTemplate;
    public OrderData createOrder(OrderDto orderDto){
        User userResponse=restTemplate.getForObject("http://localhost:8087/UserData/getById/"+orderDto.getUserid(),User.class);
        System.out.println(userResponse);
        Book bookResponse=restTemplate.getForObject("http://localhost:8088/BookData/getById/"+orderDto.getBookId(),Book.class);
        System.out.println(bookResponse);
        if(bookResponse.getBookId().equals(orderDto.bookId)){
            int totalQuantity=bookResponse.getQuantity()-orderDto.quantity;
            bookResponse.setQuantity(totalQuantity);
            System.out.println(totalQuantity);
            restTemplate.put("http://localhost:8088/BookData/quantity/"+bookResponse.getBookId()+"/"+totalQuantity,Book.class);
        }else
            throw new OrderDataException("book id is invalid");
        System.out.println(bookResponse);
        int totalPrice=orderDto.quantity*bookResponse.getPrice();
        orderDto.setPrice(totalPrice);
        OrderData orderData=new OrderData(userResponse.getUserid(),bookResponse.getBookId(),orderDto.address,orderDto.quantity,orderDto.getPrice());
        return dataRepository.save(orderData);
    }
    public OrderData updateOrder(Long orderId,OrderDto orderDto){
        OrderData orderData=dataRepository.findById(orderId).orElse(null);
        if (orderData!=null){
            orderData.setAddress(orderDto.address);
            orderData.setPrice(orderDto.price);
            orderData.setQuantity(orderDto.quantity);
            orderData.setUserid(orderDto.userid);
            orderData.setBookId(orderDto.bookId);
            return dataRepository.save(orderData);
        }else
            return null;
    }
    public List<OrderData> orderDataList(){
        return dataRepository.findAll();
    }
    public OrderData findById(Long orderId){
        return dataRepository.findById(orderId).orElse(null);
    }
    public OrderData cancelOrder(Long orderId){
        OrderData orderData=this.findById(orderId);
        orderData.setCancel(true);
        return dataRepository.save(orderData);
    }
}
