package com.example.ordermodule.repository;

import com.example.ordermodule.model.OrderData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDataRepository extends JpaRepository<OrderData,Long> {
}
