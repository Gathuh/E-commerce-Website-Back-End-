package com.gathu.ecommerce.product;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.stream.Stream;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByIdInOrderById(List<Integer> productIds);
//    List<Product> findByOrderId(List<Integer> productIds);
}
