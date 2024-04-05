package com.project.service.serviceInterface;

import java.util.List;

import org.springframework.data.domain.Page;

import com.project.Dto.RequestDto.CustomerRequestDto;
import com.project.Dto.ResponseDto.CustomerResponseDto;

public interface ICustomerService {

	CustomerResponseDto createCustomer(CustomerRequestDto customerRequestDto , boolean SyncDb);

    CustomerResponseDto udapteCustomer(String email , CustomerRequestDto customerRequestDto);


    String deleteCustomer(String email);

    CustomerResponseDto getCustomerWithId(String email);

    List<CustomerResponseDto> searchBySpecificType(String searchBy, String searchQuery);

    Page<CustomerResponseDto> getAllCustomers(int pageNo, int rowsCount, String sortBy, String searchBy);
}
