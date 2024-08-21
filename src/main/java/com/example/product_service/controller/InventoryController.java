package com.example.product_service.controller;

import com.example.product_service.dto.InventoryDto;
import com.example.product_service.entity.Inventory;
import com.example.product_service.service.InventoryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/inventory")
public class InventoryController {


    private final InventoryServiceImpl inventoryService;

    @GetMapping
    public ResponseEntity<List<Inventory>> getAllInventory() {
        return new ResponseEntity<>(inventoryService.getAllInventory(), HttpStatus.OK);
    }

    @GetMapping("product/{productId}")
    public ResponseEntity<Inventory> getInventoryByProductId(@PathVariable Long productId) {
        return new ResponseEntity<>(inventoryService.getByProductId(productId), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InventoryDto> getInventoryDto(@PathVariable Long id) {
        return new ResponseEntity<>(inventoryService.getInventoryDto(id), HttpStatus.OK);
    }


    @PreAuthorize("hasRole('admin')")
    @PostMapping("/new")
    public ResponseEntity<Inventory> addInventory(@RequestBody InventoryDto inventory){
        return new ResponseEntity<>(inventoryService.addInventory(inventory), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('admin')")
    @PutMapping("/update")
    public ResponseEntity<Inventory> updateInventory(@RequestBody Inventory inventory){
        return new ResponseEntity<>(inventoryService.update(inventory), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('admin')")
    @DeleteMapping("delete/{productId}")
    public HttpStatus deleteInventory(@PathVariable Long productId){
        inventoryService.deleteInventory(productId);
        return HttpStatus.OK;
    }


}
