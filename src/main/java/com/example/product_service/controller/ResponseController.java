package com.example.product_service.controller;

import com.example.product_service.dto.ProductResponse;
import com.example.product_service.service.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/response")
public class ResponseController {

    private final ResponseService responseService;

    @GetMapping("/{id}")
    public ProductResponse productResponse(@PathVariable Long id, @RequestParam int quantity){
        return responseService.response(id, quantity);
    }
}
