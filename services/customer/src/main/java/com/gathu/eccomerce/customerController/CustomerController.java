package com.gathu.eccomerce.customerController;


import com.gathu.eccomerce.dto.CustomerRequest;
//import com.gathu.eccomerce.dto.CustomerResponse;
import com.gathu.eccomerce.dto.CustomerResponse;
import com.gathu.eccomerce.model.Customer;
import com.gathu.eccomerce.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
//import lombok.var;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor

public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<String> createCustomer(
            @RequestBody @Valid CustomerRequest customerRequest
    ){
       var customer =customerService.createCustomer(customerRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(String.format("Customer created succesfully with ID:: %s",customer.getId()));

    }


    @PutMapping("/{id}")
    public ResponseEntity<String  > updateCustomer(@PathVariable String  id,
            @RequestBody @Valid CustomerRequest customerRequest){
//        if(!id.equals(customerRequest.id())){
//            return ResponseEntity.badRequest().body("the selected id does not match the customers ID");
//        }
        Customer customer= customerService.updateCUstomer(customerRequest,id);

        return ResponseEntity.ok("Customer with ID " + customer.getId() + " updated successfully");

    }


    @GetMapping
    public ResponseEntity<List<CustomerResponse>> getAllCustomers(){
        return ResponseEntity.ok(customerService
                .getAllCustomers());
    }
    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> getCustomerById(@PathVariable String id){
        return ResponseEntity.status(HttpStatus.OK).body(customerService.getCustomerById(id));

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id){
       customerService.deleteCustomerById(id);
        return ResponseEntity.status(HttpStatus.OK).body(String.format("Customer with ID:: %s was deleted succesfuly",id));
    }
}
