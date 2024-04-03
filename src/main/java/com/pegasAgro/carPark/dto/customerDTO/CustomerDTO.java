package com.pegasAgro.carPark.dto.customerDTO;

import com.pegasAgro.carPark.models.Customer;

import lombok.Data;

@Data
public class CustomerDTO {
    private long id;
    private String FIO;
    private String phoneNumber;
    private String mailAddress;

    public static CustomerDTO fromEntity (Customer customer) {
        CustomerDTO dto = new CustomerDTO();
        dto.setId(customer.getId());
        dto.setFIO(customer.getFIO());
        dto.setPhoneNumber(customer.getPhoneNumber());
        dto.setMailAddress(customer.getMailAddress());
        return dto;
    } 

    public static Customer toEntiy (CustomerDTO dto) {
        Customer customer = new Customer();
        customer.setId(dto.getId());
        customer.setFIO(dto.getFIO());
        customer.setPhoneNumber(dto.getPhoneNumber());
        customer.setMailAddress(dto.getMailAddress());
        return customer;
    }
}
