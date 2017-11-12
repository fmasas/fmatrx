package com.agn.dao;

//import java.io.FileNotFoundException;
//import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtility {
	
	private static Connection connection = null;
	
	public static Connection getConnection() {
		if(connection != null)
			return connection;
		else {
			try{
				
				//Section to identify the current machine 
				InetAddress addr;
				try {
					String hostname = "Unknown"; 
					addr = InetAddress.getLocalHost();
					hostname = addr.getHostName();
					System.out.println("Hostname: " + hostname);
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//Choose the driver  
				String driver = "com.mysql.jdbc.Driver";
				String url = "jdbc:mysql://167.114.152.77:3306/fma?autoReconnect=true";    //prod
				String user = "root";    //prod
				String password = "123";    // prod
				//String url = "jdbc:mysql://localhost:3306/fma?autoReconnect=true";  //desa
				//String user = "msdefuser";    //desa
				//String password = "1234";    //desa
				Class.forName(driver);
				connection = DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
//            } catch (FileNotFoundException e) {
 //               e.printStackTrace();
//            } catch (IOException e) {
 //               e.printStackTrace();
            }
			
			
			return connection;	
		}
	}
	
	public boolean getConnection(int someValue) {
		return true; 
	}
}
