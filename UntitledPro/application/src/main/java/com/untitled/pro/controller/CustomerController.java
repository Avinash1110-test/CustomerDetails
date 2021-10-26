package com.untitled.pro.controller;

import com.querydsl.core.types.Predicate;
import com.untitled.pro.domain.entity.Customer;
import com.untitled.pro.dto.mapper.CustomerMapper;
import com.untitled.pro.dto.request.CustomerRequestDTO;
import com.untitled.pro.dto.response.CustomerResponseDTO;
import com.untitled.pro.dto.response.ResponseDTO;
import com.untitled.pro.service.service.CustomerService;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/atm")
public class CustomerController {

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/allCustomers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO> getAllCustomers(@QuerydslPredicate(root = Customer.class) Predicate predicate,
                                                       @PageableDefault(sort = {"id"}, direction = Sort.Direction.ASC, size = 20) @Parameter(hidden = true) Pageable pageRequest) {

        Page<Customer> agentAddressMasterPage = customerService.getAllCustomers(predicate, pageRequest);
        Page<CustomerResponseDTO> result = customerMapper.convertEntityPageToResponsePage(pageRequest, agentAddressMasterPage);
        ResponseDTO response = new ResponseDTO(HttpStatus.OK.value(), Boolean.TRUE, result, null);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO> getCustomerById(@PathVariable("id") Long id) {

        CustomerResponseDTO result = customerMapper.convertEntityToResponseDTO(customerService.getCustomerById(id));
        ResponseDTO response = new ResponseDTO(HttpStatus.OK.value(), Boolean.TRUE, result, null);
        return ResponseEntity.ok(response);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO> createCustomer(@RequestBody CustomerRequestDTO customerRequestDTO) {

        Customer customer = customerMapper.convertCreateRequestToEntity(customerRequestDTO);
        customer = customerService.createCustomer(customer);
        CustomerResponseDTO result = customerMapper.convertEntityToResponseDTO(customer);
        ResponseDTO response = new ResponseDTO(HttpStatus.OK.value(), Boolean.TRUE, result, null);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO> updateCustomer(@RequestBody CustomerRequestDTO customerRequestDTO, @PathVariable("id") Long id) {

        Customer customer = customerService.getCustomerById(id);
        customerMapper.convertUpdateRequestToEntity(customerRequestDTO, customer);
        customer = customerService.updateCustomer(customer);
        CustomerResponseDTO result = customerMapper.convertEntityToResponseDTO(customer);
        ResponseDTO response = new ResponseDTO(HttpStatus.OK.value(), Boolean.TRUE, result, null);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ResponseDTO> deleteCustomer(@PathVariable("id") Long id) {

        Customer customer = customerService.getCustomerById(id);
        customerService.deleteCustomer(customer);
        ResponseDTO response = new ResponseDTO(HttpStatus.OK.value(), Boolean.TRUE, null, null);
        return ResponseEntity.ok(response);
    }
}
