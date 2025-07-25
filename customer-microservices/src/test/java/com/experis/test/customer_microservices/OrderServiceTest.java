package com.experis.test.customer_microservices;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.experis.test.dto.OrderRequest;
import com.experis.test.dto.OrderResponse;
import com.experis.test.dto.ProductRequest;
import com.experis.test.model.Order;
import com.experis.test.repository.OrderRepository;
import com.experis.test.service.OrderService;
import com.experis.test.util.OrderMapper;

public class OrderServiceTest {
	

    @InjectMocks
    private OrderService orderService;

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private OrderMapper mapper;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createOrder_shouldThrowException_whenQuantityIsZero() {
        OrderRequest request = new OrderRequest();
        ProductRequest product = new ProductRequest();
        product.setQuantity(0);
        product.setUnitPrice(10.0);
        request.setProducts(Collections.singletonList(product));

        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> orderService.createOrder(request)
        );

        assertEquals("Cantidad debe ser mayor a 0", exception.getMessage());
    }

    @Test
    void createOrder_shouldPersistOrder_whenValidInput() {
        ProductRequest product = new ProductRequest();
        product.setQuantity(2);
        product.setUnitPrice(20.0);

        OrderRequest request = new OrderRequest();
        request.setProducts(Collections.singletonList(product));

        Order mappedOrder = new Order();
        mappedOrder.setProducts(Collections.emptyList()); // simulación

        when(mapper.toEntity(any(OrderRequest.class))).thenReturn(mappedOrder);
        when(orderRepository.save(any(Order.class))).thenReturn(mappedOrder);
        when(mapper.toResponse(any(Order.class))).thenReturn(new OrderResponse(0, null));

        OrderResponse response = orderService.createOrder(request);

        assertNotNull(response);
        verify(orderRepository).save(any(Order.class));
    }

}
