package com.example.product_service.service;

import com.example.product_service.dto.InventoryDto;
import com.example.product_service.entity.Inventory;
import com.example.product_service.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {


    private final InventoryRepository inventoryRepository;

    private final ProductService productService;


    @Override
    public List<Inventory> getAllInventory() {
        return inventoryRepository.findAll();
    }
    @Override
    public Inventory getInventory(Long id){
        return inventoryRepository.findById(id).orElseThrow(()-> new RuntimeException("product not found - " + id));
    }

    @Override
    public Inventory getByProductId(Long id){
        return inventoryRepository.findByProductId(id);
    }

    @Override
    public Inventory update(Inventory inventory){
        return inventoryRepository.save(inventory);
    }

    @Override
    public void deleteInventory(Long id){
        inventoryRepository.deleteById(id);
    }

    @Override
    public void save(Inventory inventory){
        inventoryRepository.save(inventory);
    }

    @Override
    public Inventory addInventory(InventoryDto inventoryDto) {
        return inventoryRepository.save(Inventory.builder()
                .quantity(inventoryDto.getQuantity())
                .reserve(inventoryDto.getReserve())
                .product(productService.getProduct(inventoryDto.getProductId()))
                .build());
    }

    @Override
    public InventoryDto getInventoryDto(Long id) {
        Inventory inventory = inventoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found - " + id));
        return InventoryDto.builder()
                .quantity(inventory.getQuantity())
                .reserve(inventory.getReserve())
                .productId(inventory.getProduct().getId())
                .build();
    }

}
