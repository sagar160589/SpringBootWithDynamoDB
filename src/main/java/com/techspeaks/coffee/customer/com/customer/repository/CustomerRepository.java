package com.techspeaks.coffee.customer.com.customer.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.techspeaks.coffee.customer.com.customer.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepository {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public Customer saveCustomer(Customer customer){
        dynamoDBMapper.save(customer);
        return customer;
    }

    public Customer getCustomer(String customerId){
        return dynamoDBMapper.load(Customer.class, customerId);
    }

    public String deleteCustomer(String customerId){
        Customer customer = dynamoDBMapper.load(Customer.class, customerId);
        dynamoDBMapper.delete(customer);

        return "Customer deleted successfully";
    }

    public String updateCustomer(String customerId, Customer customer){
        dynamoDBMapper.save(customer, new DynamoDBSaveExpression().withExpectedEntry("customerId",
                new ExpectedAttributeValue(new AttributeValue().withS(customerId))));
                return customerId;
    }


    public List<Customer> getCustomerDetails(){
        return dynamoDBMapper.scan(Customer.class, new DynamoDBScanExpression());
    }
}
