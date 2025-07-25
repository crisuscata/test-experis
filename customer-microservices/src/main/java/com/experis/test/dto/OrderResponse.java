package com.experis.test.dto;

import java.time.LocalDateTime;

public class OrderResponse {
    private double total;
    private LocalDateTime createdAt;

    public OrderResponse(double total, LocalDateTime createdAt) {
        this.total = total;
        this.createdAt = createdAt;
    }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}