package com.example.product_service.service;

import com.example.product_service.dto.ProductResponse;
import com.example.product_service.entity.Inventory;
import com.example.product_service.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ResponseServiceImpl implements ResponseService {
    private final ProductService productService;
    private final InventoryService inventoryService;

    @Override
    public ProductResponse response(Long id, int count){
        var productDto = productService.getProductDto(id);
        Product product = productService.getProduct(id);
        if(productDto == null){
            return new ProductResponse(productDto, "Product not found");
        }
        Inventory inventory = inventoryService.getByProductId(product.getId());

        if (count > inventory.getQuantity()){
            return new ProductResponse(productDto,"Product not enough" );
        }
        inventory.setQuantity(inventory.getQuantity() - count);
        inventory.setReserve(inventory.getReserve() + count);
        inventoryService.save(inventory);
        return new ProductResponse(productDto, "The request was successfully completed");
    }
}
