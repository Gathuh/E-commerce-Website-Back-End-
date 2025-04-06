package com.gathu.ecommerce.product;

import jakarta.validation.constraints.NotBlank;

public record ProductPurchaseRequest(
        @NotBlank(message = "Product id id required")
        Integer productId,
        @NotBlank(message = "The quantity is required!")
        double quantity
) {
}
