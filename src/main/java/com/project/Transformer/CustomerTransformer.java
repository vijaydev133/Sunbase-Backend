package com.project.Transformer;

import com.project.Dto.RequestDto.CustomerRequestDto;
import com.project.Dto.ResponseDto.CustomerResponseDto;
import com.project.models.Customer;

public class CustomerTransformer {

	 //    Transformer to convert customerRequestDto to customer object


    public static Customer customerRequestDtoToCustomer(CustomerRequestDto customerRequestDto){
        return Customer.builder()
                .firstName(customerRequestDto.getFirstName())
                .lastName(customerRequestDto.getLastName())
                .email(customerRequestDto.getEmail())
                .phone(customerRequestDto.getPhone())
                .city(customerRequestDto.getCity())
                .address(customerRequestDto.getAddress())
                .state(customerRequestDto.getState())
                .street(customerRequestDto.getStreet())
                .build();

    }

    public static CustomerResponseDto customerToCustomerResponseDto(Customer customer){
        return CustomerResponseDto.builder()
                .Uid(customer.getUid())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .email(customer.getEmail())
                .phone(customer.getPhone())
                .state(customer.getState())
                .street(customer.getStreet())
                .address(customer.getAddress())
                .joinedOn(customer.getJoinedOn())
                .phone(customer.getPhone())
                .city(customer.getCity())
                .build();
    }
}
