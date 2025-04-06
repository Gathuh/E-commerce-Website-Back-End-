package com.gathu.ecommerce.product;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Integer> createProduct(
            @RequestBody @Valid ProductRequest request
    ){
        return ResponseEntity.ok(productService.createProduct(request));

    }


    @PostMapping("/purchase")
    public ResponseEntity<List<ProductPurchaseResponse>> purchaseProduct(
            @RequestBody List<ProductPurchaseRequest> requests
    ){
        return ResponseEntity.ok(productService.purchase(requests));
    }


    @GetMapping("/{product-id}")

    public ResponseEntity<ProductResponse> getById(
            @PathVariable("product-id") Integer id
    ){
        return ResponseEntity.ok(productService.findById(id));
    }


    @GetMapping
    public ResponseEntity<List<ProductResponse>> getProdructs(){
        return ResponseEntity.ok(productService.findAll());
    }
}
