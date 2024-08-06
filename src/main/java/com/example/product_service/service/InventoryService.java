package com.example.product_service.service;

import com.example.product_service.dto.InventoryDto;
import com.example.product_service.entity.Inventory;

import java.util.List;

public interface InventoryService {

    public List<Inventory> getAllInventory();
    public InventoryDto getInventoryDto(Long id);

    public Inventory getInventory(Long id);

    public Inventory update(Inventory inventory);

    public void deleteInventory(Long id);

    void save(Inventory inventory);

    public Inventory addInventory(InventoryDto inventoryDto);

    public Inventory getByProductId(Long id);

}
