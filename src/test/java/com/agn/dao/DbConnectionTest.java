package com.agn.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.hibernate.metamodel.source.annotations.xml.mocker.MockHelper;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class DbConnectionTest {

	private Connection connection;
	
	@Test
	public void test() {
		DBUtility junit = new DBUtility();
		//DBUtility junitMock = Mockito.mock(DBUtility.class);
		//Mockito.when(junitMock.getConnection(1)).thenReturn(true);
		
		int result = 1;
		
		if(!junit.getConnection(1)){
			try {
				connection = junit.getConnection();
				if(connection.isClosed()){
					result = 0;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		assertEquals(1, result);
	}
}
