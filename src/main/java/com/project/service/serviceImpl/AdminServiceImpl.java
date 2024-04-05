package com.project.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.models.adminDetails;
import com.project.repository.IAdminRepository;
import com.project.service.serviceInterface.IAdminService;

@Service
public class AdminServiceImpl implements IAdminService {

	@Autowired
	private IAdminRepository adminRepo;
	@Override
	public adminDetails getAdminDetails() {
		return adminRepo.findById(1).get();
	}
	
	
	
//	public adminDetails getAdminDetails(String uname) {
//		// TODO Auto-generated method stub
//		adminDetails admin = adminRepo.getByUname(uname);
//		return admin;
//	}

}
