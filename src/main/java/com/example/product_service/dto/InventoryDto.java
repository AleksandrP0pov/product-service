package com.example.product_service.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventoryDto {

    private int quantity;
    private int reserve;
    private Long productId;
}
