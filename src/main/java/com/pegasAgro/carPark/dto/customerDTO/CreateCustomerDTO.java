package com.pegasAgro.carPark.dto.customerDTO;

import com.pegasAgro.carPark.models.Customer;

import lombok.Data;

@Data
public class CreateCustomerDTO {
    private String FIO;
    private String phoneNumber;
    private String mailAddress;

    public static CreateCustomerDTO fromEntity (Customer customer) {
        CreateCustomerDTO dto = new CreateCustomerDTO();
        dto.setFIO(customer.getFIO());
        dto.setPhoneNumber(customer.getPhoneNumber());
        dto.setMailAddress(customer.getMailAddress());
        return dto;
    } 

    public static Customer toEntiy (CreateCustomerDTO dto) {
        Customer customer = new Customer();
        customer.setFIO(dto.getFIO());
        customer.setPhoneNumber(dto.getPhoneNumber());
        customer.setMailAddress(dto.getMailAddress());
        return customer;
    }
}
