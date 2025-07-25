package com.experis.test.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.experis.test.dto.OrderRequest;
import com.experis.test.dto.OrderResponse;
import com.experis.test.service.OrderService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/orders")
@Tag(name = "Pedidos", description = "Gestión de pedidos de clientes")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(summary = "Crear un pedido")
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest request) {
        OrderResponse response = service.createOrder(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}