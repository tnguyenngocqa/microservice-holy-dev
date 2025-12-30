package com.ltfullstack.orderservice.repository;

import com.ltfullstack.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
