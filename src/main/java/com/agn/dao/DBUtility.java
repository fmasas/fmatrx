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

				//Choose the driver
				String driver = "com.mysql.jdbc.Driver";
				String url = "";
				String user = "";
				String password = "";
				
				//Section to identify the current machine 
				InetAddress addr;
				try {
					String hostname = "Unknown"; 
					addr = InetAddress.getLocalHost();
					hostname = addr.getHostName();
					System.out.println("Hostname: " + hostname);
					
					if(hostname.equals("Pc")){
						url = "jdbc:mysql://localhost:3306/fma?autoReconnect=true";  //desa
						user = "msdefuser";    //desa
						password = "1234";    //desa
					}else{
						url = "jdbc:mysql://vps-b05032bc.vps.ovh.ca:3306/fma?autoReconnect=true";    //prod
						user = "fmauser";    //prod
						password = "Fma$1234";    // prod
					}
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
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
