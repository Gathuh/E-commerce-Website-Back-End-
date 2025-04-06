package com.gathu.eccomerce.exception;


import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CustomerNotFound extends RuntimeException {
    private final String msg;
}
