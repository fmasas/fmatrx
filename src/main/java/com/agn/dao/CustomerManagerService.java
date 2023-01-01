package com.agn.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.agn.model.Customer;


public class CustomerManagerService {
	
	private Connection connection;
	
	public CustomerManagerService() {
		connection = DBUtility.getConnection();
	}
	
	public List<Customer> getAllCustomers(){
		List<Customer> customers = new ArrayList<Customer>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from CUSTOMERS");
			while (rs.next()){
				Customer customer = new Customer(); 
				customer.setCustomerId(rs.getLong("customer_id"));
				customer.setCustomerName(rs.getString("customer_name"));
				customers.add(customer); 
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		return customers;
	}

}
