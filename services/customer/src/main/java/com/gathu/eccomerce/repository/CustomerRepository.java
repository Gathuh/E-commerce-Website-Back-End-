package com.gathu.eccomerce.repository;

import com.gathu.eccomerce.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CustomerRepository  extends MongoRepository<Customer,String> {


    Optional<Customer> findByEmail(String email);
}
