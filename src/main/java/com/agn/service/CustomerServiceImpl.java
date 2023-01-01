package com.agn.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.agn.dao.CustomerManagerService;
import com.agn.model.Customer;

@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService{
	
	static CustomerManagerService cms = new CustomerManagerService(); 
	
	public List<Customer> getAllCustomers(){
		return cms.getAllCustomers();
	}

}
