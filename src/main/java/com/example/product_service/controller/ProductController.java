package com.example.product_service.controller;

import com.example.product_service.dto.ProductDto;
import com.example.product_service.entity.Product;
import com.example.product_service.service.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductServiceImpl productService;

    @PostMapping("/new")
    public ResponseEntity<Product> createProduct(@RequestBody ProductDto productDto){
        return new ResponseEntity<>(productService.addProduct(productDto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Product>> readAllProduct(){
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> readProduct(@PathVariable Long id){
        return new ResponseEntity<>(productService.getProduct(id), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
        return new ResponseEntity<>(productService.updateProduct(product), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public HttpStatus deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return HttpStatus.OK;
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<Product>> readByCategoryId(@PathVariable Long id){
        return new ResponseEntity<>(productService.getByCategoryId(id), HttpStatus.OK);
    }

    @GetMapping("/dto/{id}")
    public ResponseEntity<ProductDto> getProductDto(@PathVariable Long id){
        return new ResponseEntity<>(productService.getProductDto(id), HttpStatus.OK);
    }



}
