package com.untitled.pro.dto.mapper;

import com.untitled.pro.domain.entity.Customer;
import com.untitled.pro.dto.request.CustomerRequestDTO;
import com.untitled.pro.dto.response.CustomerResponseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerMapper {

    @Autowired
    private ModelMapper modelMapper;

    public CustomerResponseDTO convertEntityToResponseDTO(Customer customer) {
        CustomerResponseDTO customerResponseDTO = modelMapper.map(customer, CustomerResponseDTO.class);
        customerResponseDTO.setId(customerResponseDTO.getId());
        return customerResponseDTO;
    }

    public Customer convertCreateRequestToEntity(CustomerRequestDTO customerRequestDTO) {
        return modelMapper.map(customerRequestDTO, Customer.class);
    }

    public void convertUpdateRequestToEntity(CustomerRequestDTO customerRequestDTO, Customer customer) {
        modelMapper.map(customerRequestDTO, customer);
    }

    public Page<CustomerResponseDTO> convertEntityPageToResponsePage(Pageable pageRequest, Page<Customer> customers) {
        List<CustomerResponseDTO> dtos = new ArrayList<>();
        customers.forEach(e -> dtos.add(convertEntityToResponseDTO(e)));
        return new PageImpl<>(dtos, pageRequest, customers.getTotalElements());
    }
}
