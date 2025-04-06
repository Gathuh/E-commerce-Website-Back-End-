package com.gathu.eccomerce.mapper;


import com.gathu.eccomerce.dto.CustomerRequest;
import com.gathu.eccomerce.dto.CustomerResponse;
import com.gathu.eccomerce.model.Address;
import com.gathu.eccomerce.model.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {
    public Customer toCustomer(CustomerRequest customerRequest){

        if(customerRequest==null){
            return null;
        }
        return Customer.builder()

                .firstname(customerRequest.firstname())
                .lastname(customerRequest.lastname())
                .email(customerRequest.email())
                .address(customerRequest.address())
                .build();
    }

    public CustomerResponse toResponse(Customer customer){

        return new CustomerResponse(
                customer.getId(),
                customer.getFirstname(),
                customer.getLastname(),
                customer.getEmail(),
                customer.getAddress()
        );
    }

//   if (customer == null) {
//    return null;
//    }
//    String firstname = customer.getFirstname();
//    String lastname = customer.getLastname();
//    String email = customer.getEmail();
//    Address address = customer.getAddress();
//    CustomerResponse customerResponse = new CustomerResponse(firstname, lastname, email, address);
//        return customerResponse;
//}
}
