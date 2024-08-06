package com.example.product_service.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private String name;
    private double price;
    private Long categoryId;

}
