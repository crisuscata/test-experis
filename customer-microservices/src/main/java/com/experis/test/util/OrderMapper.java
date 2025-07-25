package com.experis.test.util;

import com.experis.test.dto.OrderRequest;
import com.experis.test.dto.OrderResponse;
import com.experis.test.dto.ProductRequest;
import com.experis.test.model.Order;
import com.experis.test.model.Product;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class OrderMapper {

    public Order toEntity(OrderRequest request) {
        Order order = new Order();
        order.setClientName(request.getClientName());
        order.setClientEmail(request.getClientEmail());
        order.setProducts(request.getProducts().stream().map(this::toProduct).collect(Collectors.toList()));
        return order;
    }

    private Product toProduct(ProductRequest pr) {
        Product p = new Product();
        p.setName(pr.getName());
        p.setQuantity(pr.getQuantity());
        p.setUnitPrice(pr.getUnitPrice());
        return p;
    }

    public OrderResponse toResponse(Order order) {
        return new OrderResponse(order.getTotal(), order.getCreatedAt());
    }
}