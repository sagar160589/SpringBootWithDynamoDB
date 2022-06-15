package com.techspeaks.coffee.customer.com.customer.controller;

import com.techspeaks.coffee.customer.com.customer.entity.Customer;
import com.techspeaks.coffee.customer.com.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping(value = "/customerTest")
    public ResponseEntity<String> customerDetails(){
        return ResponseEntity.ok().body("Customer details returned successfully");
    }

    @PostMapping(value = "/customer")
    public Customer saveDetails(@RequestBody Customer customer){
        return customerRepository.saveCustomer(customer);
    }

    @GetMapping(value = "/customer/{customerId}")
    public Customer getDetails(@PathVariable("customerId") String customerId){
        return customerRepository.getCustomer(customerId);
    }

    @DeleteMapping(value = "/customer/{customerId}")
    public String deleteDetails(@PathVariable("customerId") String customerId){
        return customerRepository.deleteCustomer(customerId);
    }

    @PutMapping(value = "/customer/{customerId}")
    public String updateDetails(@PathVariable("customerId") String customerId, @RequestBody Customer customer){
        return customerRepository.updateCustomer(customerId,customer);
    }

    @GetMapping(value = "/customers")
    public List<Customer> getAllDetails(){
        return customerRepository.getCustomerDetails();
    }
}
