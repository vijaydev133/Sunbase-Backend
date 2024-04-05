package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.models.adminDetails;

public interface IAdminRepository extends JpaRepository<adminDetails, Integer> {

//	adminDetails getAdmin(String username);
}
