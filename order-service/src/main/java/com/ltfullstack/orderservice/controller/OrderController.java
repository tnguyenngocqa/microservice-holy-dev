package com.ltfullstack.orderservice.controller;

import com.ltfullstack.orderservice.UserClient;
import com.ltfullstack.orderservice.UserDto;
import com.ltfullstack.orderservice.model.Order;
import com.ltfullstack.orderservice.model.OrderResponse;
import com.ltfullstack.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderRepository orderRepository;

    // call feign client
    private final UserClient userClient;

    @GetMapping("/{id}")
    public OrderResponse getOrderById(@PathVariable Long id) {
        Order order = orderRepository.findById(id).orElseThrow();

        UserDto user = userClient.getUserById(id);

        return new OrderResponse(order.getId(), order.getProduct(), order.getPrice(), user);
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderRepository.save(order);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
