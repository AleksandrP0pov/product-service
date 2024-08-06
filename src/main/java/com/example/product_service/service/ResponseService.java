package com.example.product_service.service;

import com.example.product_service.dto.ProductResponse;

public interface ResponseService {
    public ProductResponse response(Long id, int count);
}
