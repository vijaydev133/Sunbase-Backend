package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.models.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

	 public  Customer findByEmail(String email);

	    public void deleteByEmail(String email);

	    @Query("SELECT c FROM Customer c WHERE c.firstName LIKE %:searchTerm%")
	    List<Customer> findByFirstNameLike(String searchTerm);

	    @Query("SELECT c FROM Customer c WHERE c.phone LIKE %:searchTerm%")
	    List<Customer> findByPhoneLike(String searchTerm);

	    @Query("SELECT c FROM Customer c WHERE c.city LIKE %:searchTerm%")
	    List<Customer> findByCityLike(String searchTerm);

	    @Query("SELECT c FROM Customer c WHERE c.email LIKE %:searchTerm%")
	    List<Customer> findByEmailLike(String searchTerm);
}
