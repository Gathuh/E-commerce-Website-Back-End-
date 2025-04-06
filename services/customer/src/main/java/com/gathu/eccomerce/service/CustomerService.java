package com.gathu.eccomerce.service;


import com.gathu.eccomerce.dto.CustomerRequest;
import com.gathu.eccomerce.dto.CustomerResponse;
import com.gathu.eccomerce.exception.CustomerNotFound;
import com.gathu.eccomerce.mapper.CustomerMapper;
import com.gathu.eccomerce.model.Customer;
import com.gathu.eccomerce.repository.CustomerRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {


    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    public Customer createCustomer(CustomerRequest customerRequest
    ){
        var customer=customerRepository.save(customerMapper.toCustomer(customerRequest));
        return customer;
    }


    public Customer  updateCUstomer(@Valid CustomerRequest customerRequest,String id) {
    var customer =customerRepository.findById(id)
            .orElseThrow(()->new CustomerNotFound(String.format("Cannot update customer with the ID:: %s, No customer was found",id)));
    mergeCustomer(customer,customerRequest);
    customerRepository.save(customer);
    return customer;




        //        Customer updateCustomer= customerRepository.findByEmail(email).orElseThrow(()->new RuntimeException("Customer Not Found"));
//        updateCustomer.setFirstname(customerRequest.firstname());
//        updateCustomer.setLastname(customerRequest.lastname());
//        updateCustomer.setAddress(customerRequest.address());
//        updateCustomer.setEmail(customerRequest.email());
//        return "Customer "+customerRequest.email()+" updated";
    }

    private void mergeCustomer(Customer customer,
                               @Valid CustomerRequest customerRequest) {

        if(customerRequest.firstname()!=null){
            customer.setFirstname(customerRequest.firstname());
        }

        if(customerRequest.lastname()!=null){
            customer.setLastname(customerRequest.lastname());
        }

        if(customerRequest.email()!=null){
            customer.setEmail(customerRequest.email());
        }
        if(customerRequest.address()!=null){
            customer.setAddress(customerRequest.address());
        }

    }

    public List<CustomerResponse> getAllCustomers() {

       List<Customer>  customerResponseToBe=customerRepository.findAll();
       List<CustomerResponse> customerResponses= customerResponseToBe.stream().map(customerMapper::toResponse).collect(Collectors.toList());


       return customerResponses;



//      return  customerRepository.findAll()
//              .stream()
//              .map(customerMapper::toResponse).
//              collect(Collectors.toList());
    }



    public CustomerResponse getCustomerById(String id){
        Customer customer= customerRepository.findById(id)
                .orElseThrow(()->new CustomerNotFound(String
                        .format("Customer with ID:: %s could not be fund try a different ID",id)));
        return customerMapper.toResponse(customer);

    }
    public void deleteCustomerById(String id){
        Customer customer=customerRepository.findById(id).orElseThrow(()->new CustomerNotFound(String.format("Customer with ID:: %s Not Found, Delete Failed",id)));
        customerRepository.deleteById(customer.getId());
//        customerRepository.save(customer) // No need to save a customer it will save the reload the customer again, right?
    }


}



