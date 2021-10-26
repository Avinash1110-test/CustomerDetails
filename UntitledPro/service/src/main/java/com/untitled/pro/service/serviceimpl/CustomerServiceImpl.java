package com.untitled.pro.service.serviceimpl;

import com.querydsl.core.types.Predicate;
import com.untitled.pro.domain.entity.Customer;
import com.untitled.pro.domain.repository.CustomerRepository;
import com.untitled.pro.service.exception.ServiceErrors;
import com.untitled.pro.service.exception.ServiceException;
import com.untitled.pro.service.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Page<Customer> getAllCustomers(Predicate predicate, Pageable pageRequest) {
        return customerRepository.findAll(predicate, pageRequest);
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new ServiceException(ServiceErrors.CUSTOMER_ID_NOT_EXIST.CODE, ServiceErrors.CUSTOMER_ID_NOT_EXIST.KEY));
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Customer customer) {
        customerRepository.delete(customer);
    }
}
