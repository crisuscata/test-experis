package com.experis.test.service;

import com.experis.test.dto.OrderRequest;
import com.experis.test.dto.OrderResponse;
import com.experis.test.model.Order;
import com.experis.test.repository.OrderRepository;
import com.experis.test.util.OrderMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper mapper;

    public OrderService(OrderRepository orderRepository, OrderMapper mapper) {
        this.orderRepository = orderRepository;
        this.mapper = mapper;
    }

    public OrderResponse createOrder(OrderRequest request) {
        request.getProducts().forEach(p -> {
            if (p.getQuantity() <= 0) {
                throw new IllegalArgumentException("Cantidad debe ser mayor a 0");
            }
        });

        Order order = mapper.toEntity(request);
        order.setCreatedAt(LocalDateTime.now());
        double total = order.getProducts().stream()
                .mapToDouble(p -> p.getQuantity() * p.getUnitPrice())
                .sum();
        order.setTotal(total);
        order.getProducts().forEach(p -> p.setOrder(order));
        return mapper.toResponse(orderRepository.save(order));
    }
}