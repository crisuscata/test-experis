package com.experis.test.dto;

import java.util.List;

public class OrderRequest {
    private String clientName;
    private String clientEmail;
    private List<ProductRequest> products;

    // Getters and Setters
    public String getClientName() { return clientName; }
    public void setClientName(String clientName) { this.clientName = clientName; }

    public String getClientEmail() { return clientEmail; }
    public void setClientEmail(String clientEmail) { this.clientEmail = clientEmail; }

    public List<ProductRequest> getProducts() { return products; }
    public void setProducts(List<ProductRequest> products) { this.products = products; }
}