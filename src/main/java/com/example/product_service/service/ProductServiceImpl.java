package com.example.product_service.service;

import com.example.product_service.dto.ProductDto;
import com.example.product_service.entity.Product;
import com.example.product_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {


    private final ProductRepository productRepository;
    private final CategoryService categoryService;


    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public ProductDto getProductDto(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found - " + id));
        return ProductDto.builder()
                .name(product.getName())
                .price(product.getPrice())
                .categoryId(product.getCategory().getId())
                .build();
    }

    @Override
    public Product getProduct(Long id) {
        return productRepository.findById(id).orElseThrow(()-> new RuntimeException("Product not found - " + id));
    }

    @Override
    public Product addProduct(ProductDto productDto) {
        return productRepository.save(
                Product.builder()
                        .name(productDto.getName())
                        .price(productDto.getPrice())
                        .category(categoryService.readCategory(productDto.getCategoryId()))
                        .build());
    }


    @Override
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> getByCategoryId(Long id) {
        return productRepository.findByCategoryId(id);
    }

}
