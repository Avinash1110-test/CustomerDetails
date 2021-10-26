package com.untitled.pro.service.service;

import com.querydsl.core.types.Predicate;
import com.untitled.pro.domain.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {

    Page<Customer> getAllCustomers(Predicate predicate, Pageable pageRequest);

    Customer getCustomerById(Long id);

    Customer createCustomer(Customer customer);

    Customer updateCustomer(Customer customer);

    void deleteCustomer(Customer customer);
}
