package com.cms.cms.mapper;


import com.cms.cms.entity.Customer;
import com.cms.cms.model.CustomerDTO;

public class CustomerMapper {
    public CustomerDTO toCustomerDTO( Customer customer) {
        if (customer == null) {
            return null;
        }

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customer.getId());
        customerDTO.setName(customer.getName());
        customerDTO.setDateOfBirth(customer.getDateOfBirth());
        customerDTO.setNicNumber(customer.getNicNumber());
        customerDTO.setMobileNumbers(customer.getMobileNumbers());

        return customerDTO;
    }
}
