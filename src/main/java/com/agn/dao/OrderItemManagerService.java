package com.agn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.agn.model.Order;
import com.agn.model.OrderItem;

public class OrderItemManagerService {

	private Connection connection;
	
	public OrderItemManagerService(){
		connection = DBUtility.getConnection();
	}

	public List<OrderItem> getOrderItemsById(long idOrder){
		List<OrderItem> orderitems = new ArrayList<OrderItem>();
		try{
			//connection = DBUtility.getConnection(); 
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from ORDER_ITEMS WHERE id_order = "+idOrder);
			while (rs.next()){
				OrderItem orderitem = new OrderItem();
				orderitem.setId_order_item(rs.getLong("id_order_item"));
				orderitem.setId_order(rs.getLong("id_order"));
				orderitem.setProduct(rs.getString("product"));
				orderitem.setMaterial_type(rs.getString("material_type"));
				orderitem.setUnity_weight(rs.getDouble("unity_weight"));
				orderitem.setTotal_weight(rs.getDouble("total_weight"));
				orderitem.setQuantity(rs.getDouble("quantity"));
				orderitem.setUnity_value(rs.getDouble("unity_value"));
				orderitem.setTotal_value(rs.getDouble("total_value"));
				orderitem.setOrder_item_status(rs.getString("order_item_status"));
				orderitems.add(orderitem); 
			}
            //rs.close();			
			//statement.close();
			//connection.close();
			System.out.println("Retrieving orders with id " + idOrder);
			} catch (SQLException e){
				e.printStackTrace();
			}
		    return orderitems;
    }
	
	public OrderItem getOrderItemById(long idOrderItem){
		OrderItem orderItem = new OrderItem();
		try{
			//connection = DBUtility.getConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from ORDER_ITEMS WHERE id_order_item = "+idOrderItem);
			rs.next();
			orderItem.setId_order_item(rs.getLong("id_order_item"));
			orderItem.setId_order(rs.getLong("id_order"));
			orderItem.setProduct(rs.getString("product"));
			orderItem.setMaterial_type(rs.getString("material_type"));
			orderItem.setUnity_weight(rs.getDouble("unity_weight"));
			orderItem.setTotal_weight(rs.getDouble("total_weight"));
			orderItem.setQuantity(rs.getDouble("quantity"));
			orderItem.setUnity_value(rs.getDouble("unity_value"));
			orderItem.setTotal_value(rs.getDouble("total_value"));
			orderItem.setOrder_item_status(rs.getString("order_item_status"));			
			

		} catch (SQLException e){
				e.printStackTrace();
		}
		return orderItem;
    }	
	
	public void insertOrderItem(OrderItem orderItem){
		try {
			//connection = DBUtility.getConnection();
			 PreparedStatement preparedStatement = 
		            connection.prepareStatement("INSERT INTO ORDER_ITEMS("
		            		+ "id_order_item,id_order,product,material_type,unity_weight,"
		            		+ "total_weight,quantity,unity_value,total_value,order_item_status)"
		            		+ "  VALUES (?,?,?,?,?,?,?,?,?,?)");
			 preparedStatement.setLong(1,orderItem.getId_order_item());
			 preparedStatement.setLong(2, orderItem.getId_order());
			 preparedStatement.setString(3, orderItem.getProduct());
			 preparedStatement.setString(4, orderItem.getMaterial_type());
             preparedStatement.setDouble(5, orderItem.getUnity_weight());
             preparedStatement.setDouble(6, orderItem.getUnity_weight()*orderItem.getQuantity());
             preparedStatement.setDouble(7, orderItem.getQuantity());
             preparedStatement.setDouble(8, orderItem.getUnity_value());
             preparedStatement.setDouble(9, orderItem.getUnity_value()*orderItem.getQuantity()*orderItem.getUnity_weight());
             preparedStatement.setString(10, orderItem.getOrder_item_status());
			 
             preparedStatement.executeUpdate();
             preparedStatement.close();
   			 //connection.close();

		}catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public void updateOrderItem(long idOrderItem, OrderItem orderItem){
		try {
			//connection = DBUtility.getConnection();
			 PreparedStatement preparedStatement = 
		            connection.prepareStatement("UPDATE ORDER_ITEMS SET product = ?,material_type=?,unity_weight=?,total_weight=?,quantity=?,unity_value=?,total_value=?,order_item_status=? WHERE id_order_item = "+ idOrderItem);
			 preparedStatement.setString(1, orderItem.getProduct());
             preparedStatement.setString(2, orderItem.getMaterial_type());
             preparedStatement.setDouble(3, orderItem.getUnity_weight());
             preparedStatement.setDouble(4, orderItem.getUnity_weight()*orderItem.getQuantity());
             preparedStatement.setDouble(5, orderItem.getQuantity());
             preparedStatement.setDouble(6, orderItem.getUnity_value());
             preparedStatement.setDouble(7, orderItem.getUnity_value()*orderItem.getQuantity()*orderItem.getUnity_weight());
             preparedStatement.setString(8, orderItem.getOrder_item_status());
             preparedStatement.executeUpdate();
             preparedStatement.close();
   			 //connection.close();
             System.out.println("Updated order with id " + idOrderItem);

		}catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public int getMaxOrderItemId(){
		int maxId=0;
		try{
			//connection = DBUtility.getConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select MAX(id_order_item) MAXORDERITEM from ORDER_ITEMS");
			rs.next();
			maxId = rs.getInt("MAXORDERITEM");
 //           rs.close();
//			statement.close();
			//connection.close();

		} catch (SQLException e){
				e.printStackTrace();
		}
		return maxId;
	}	

}
