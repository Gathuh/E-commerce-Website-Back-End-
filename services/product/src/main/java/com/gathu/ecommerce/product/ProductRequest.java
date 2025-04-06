package com.gathu.ecommerce.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProductRequest(

//            @NotBlank(message = "product should not be Blank")
        Integer id,
        @NotBlank(message = "name should not be Blank")
        String name,
        @NotBlank(message = "Descripton should not be Blank")
        String description,
        @NotBlank(message = "Available Quantity cannot be be Empty")
        @Positive(message = "Available Quantity can never be negative")
        double availableQuantity,
         @Positive(message = "Price can only be positive")
         BigDecimal price,
        @Positive(message = "Category Id is a positive unit")
        @NotBlank(message = "Please provide category Id")
        Integer categoryId
)  {
}
