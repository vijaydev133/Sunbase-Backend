package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.Dto.RequestDto.CustomerRequestDto;
import com.project.Dto.ResponseDto.CustomerResponseDto;
import com.project.Exceptions.CustomerAldreadyExists;
import com.project.Exceptions.CustomerNotFound;
import com.project.models.adminDetails;
import com.project.repository.IAdminRepository;
import com.project.service.serviceImpl.ExternalApiCallImpl;
import com.project.service.serviceInterface.IAdminService;
import com.project.service.serviceInterface.ICustomerService;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {

	@Autowired
	private ICustomerService customerService;
	@Autowired
	private ExternalApiCallImpl externalApiCall;
	@Autowired
	private IAdminService adminService;
	
	
	 @PostMapping("/create")
	    public ResponseEntity<CustomerResponseDto> createCustomer(@RequestBody CustomerRequestDto customerRequestDto, @RequestParam boolean SyncDb ){

//		 System.out.println("came here");
	        try {
	            CustomerResponseDto customerResponseDto =customerService.createCustomer(customerRequestDto,SyncDb);
	            return new ResponseEntity<CustomerResponseDto>(customerResponseDto, HttpStatus.CREATED);
	        }
	        catch (CustomerAldreadyExists e){
	             return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
	        }
	    }

	    @PutMapping("/update/{email}")
	    public ResponseEntity<CustomerResponseDto> updateCustomer(@PathVariable String email,@RequestBody CustomerRequestDto customerRequestDto){
	        try{
	            CustomerResponseDto customerResponseDto = customerService.udapteCustomer(email,customerRequestDto);
	            return new ResponseEntity<>(customerResponseDto,HttpStatus.ACCEPTED);
	        }catch (CustomerNotFound e){
	            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
	        }
	    }

	    @GetMapping("/getCustomers")
	    public ResponseEntity<Page<CustomerResponseDto>> getAllCustomers(@RequestParam int pageNo, @RequestParam int rowsCount, @RequestParam(required = false)String sortBy, @RequestParam(required = false) String searchBy){

	        Page<CustomerResponseDto> customerList = customerService.getAllCustomers(pageNo, rowsCount, sortBy, searchBy);
	        return new ResponseEntity<>(customerList, HttpStatus.FOUND);

	    }
	    
	    @GetMapping("/get/{email}")
	    public ResponseEntity<CustomerResponseDto> getCustomerWithId(@PathVariable String email){

	        try{
	            CustomerResponseDto customerResponseDto = customerService.getCustomerWithId(email);
	            return new ResponseEntity<>(customerResponseDto, HttpStatus.FOUND);
	        }catch (CustomerNotFound e){
	            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
	        }
	    }
	    
	    @GetMapping("/searchBy")
	    public ResponseEntity<List<CustomerResponseDto>> searchBySpecificType(@RequestParam String searchBy,@RequestParam String searchQuery){
	        List<CustomerResponseDto>   searchedResult = customerService.searchBySpecificType(searchBy,searchQuery);
	        return new ResponseEntity<>(searchedResult,HttpStatus.FOUND);
	    }

	    @DeleteMapping("/delete")
	    public ResponseEntity<?> deleteCustomer(@RequestParam String email){
	          try{
	               String result =customerService.deleteCustomer(email);
	               return new ResponseEntity(result,HttpStatus.ACCEPTED);
	          }catch (CustomerNotFound e){
	             return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
	          }

	    }
	    
//	    @GetMapping("/getAdmin")
//	    public adminDetails getDetails(@RequestParam String uname) {
//	    	
//	    	adminDetails result =adminService.getAdminDetails(uname);
//	        return result;
//	    }
	    
	    
	    @GetMapping("/sync")
	    public ResponseEntity<Object[]> getTokenFromApi(){
	             Object[]   customerObject =externalApiCall.getTokenFromApi();
	             return new ResponseEntity<>(customerObject,HttpStatus.ACCEPTED);
	    }
}
