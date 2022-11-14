package com.example.ordermodule.controller;

import com.example.ordermodule.dto.OrderDto;
import com.example.ordermodule.dto.ResponseDto;
import com.example.ordermodule.model.OrderData;
import com.example.ordermodule.service.OrderDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/OrderData")
public class OrderDataController {
    @Autowired
    OrderDataService orderDataService;
    @PostMapping("/placeOrder")
    public OrderData placeOrder(@RequestBody OrderDto orderDto){
       return orderDataService.createOrder(orderDto);
    }
    @PutMapping("/updateOrder/{orderId}")
    public ResponseEntity<ResponseDto> updateOrder(@PathVariable long orderId,@RequestBody OrderDto orderDto){
        OrderData orderData=orderDataService.updateOrder(orderId,orderDto);
        ResponseDto responseDto=new ResponseDto("order data updated",orderData);
        return new ResponseEntity<>(responseDto,HttpStatus.OK);
    }
    @GetMapping("/getAllOrders")
    public List<OrderData> retrieveOrders(){
        return orderDataService.orderDataList();
    }
    @GetMapping("/ById/{orderId}")
    public OrderData getByOrderId(@PathVariable long orderId){
        OrderData orderData=orderDataService.findById(orderId);
        return orderData;
//        ResponseDto responseDto=new ResponseDto("get orders by id:"+orderId,orderData);
//        return new ResponseEntity<>(responseDto,HttpStatus.OK);
    }
    @PutMapping("/cancel/{orderId}")
    public ResponseEntity<ResponseDto> orderCancel(@PathVariable Long orderId){
        OrderData order=orderDataService.cancelOrder(orderId);
        ResponseDto responseDto=new ResponseDto("order cancelled id: "+orderId+" done",order);
        return new ResponseEntity<>(responseDto,HttpStatus.OK);
    }
}
