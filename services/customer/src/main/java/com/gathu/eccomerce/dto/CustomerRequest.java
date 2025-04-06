package com.gathu.eccomerce.dto;

import com.gathu.eccomerce.model.Address;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record CustomerRequest(
//         String id,
         @NotNull(message = "Customer first Name is required ")
         String firstname,
         @NotNull(message = "Customer Last Name is required ")
         String lastname,
         @NotNull(message = "Customer email is required ")
         @Email(message = "customer email not vallid")
         String email,
         Address address) {
}
