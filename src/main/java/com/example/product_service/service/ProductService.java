package com.example.product_service.service;

import com.example.product_service.dto.ProductDto;
import com.example.product_service.entity.Product;

import java.util.List;

public interface ProductService {

    public ProductDto getProductDto(Long id);
    public Product getProduct(Long id);
    public List<Product> getAllProducts();
    public Product addProduct(ProductDto productDto);
    public Product updateProduct(Product product);
    public void deleteProduct(Long id);
    public List<Product> getByCategoryId(Long id);
}
