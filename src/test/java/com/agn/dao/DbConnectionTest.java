package com.agn.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

public class DbConnectionTest {

	private Connection connection;
	
	@Test
	public void test() {
		DBUtility junit = new DBUtility();
		int result = 1;
		connection = junit.getConnection();
		
		try {
			if(connection.isClosed()){
				result = 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		assertEquals(1, result);
		
	}

}
