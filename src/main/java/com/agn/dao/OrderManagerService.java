package com.agn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.agn.model.DetailedOrder;
import com.agn.model.Order;

public class OrderManagerService {
    
	private Connection connection; 
	
	public OrderManagerService(){
		connection = DBUtility.getConnection();
	}
	
	public List<Order> getAllOrders(){
		List<Order> orders = new ArrayList<Order>();
		try{
			//connection = DBUtility.getConnection(); 
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from ORDERS WHERE order_status <> 'Entregado'");
			while (rs.next()){
				Order order = new Order();
				order.setId_order(rs.getLong("id_order"));
				order.setClientname(rs.getString("clientname"));
				order.setOrder_date(rs.getTimestamp("order_date"));
				order.setDeliver_date(rs.getTimestamp("deliver_date"));
				order.setOrder_total_value(rs.getDouble("order_total_value"));
				order.setOrder_status(rs.getString("order_status"));
				orders.add(order); 
			}
            //rs.close();			
			//statement.close();
			//connection.close();
			} catch (SQLException e){
				e.printStackTrace();
			}
		    return orders;
    }
	
	public Order getOrderById(long idOrder){
		Order order = new Order();
		try{
			//connection = DBUtility.getConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from ORDERS WHERE id_order = "+idOrder);
			rs.next();
			order.setId_order(rs.getLong("id_order"));
			order.setClientname(rs.getString("clientname"));
			order.setOrder_date(rs.getTimestamp("order_date"));
			order.setDeliver_date(rs.getTimestamp("deliver_date"));
			order.setOrder_total_value(rs.getDouble("order_total_value"));
			order.setOrder_status(rs.getString("order_status"));			
			
            //rs.close();
			//statement.close();
			//connection.close();

		} catch (SQLException e){
				e.printStackTrace();
		}
		return order;
    }	
	
	public void insertOrder(Order order){
		try {
			//connection = DBUtility.getConnection();
			 PreparedStatement preparedStatement = 
		            connection.prepareStatement("INSERT INTO ORDERS(id_order,clientname,order_date,deliver_date,order_status) VALUES (?,?,?,?,?)");
			 preparedStatement.setLong(1, order.getId_order());
			 preparedStatement.setString(2, order.getClientname());
			 preparedStatement.setTimestamp(3, order.getOrder_date());
             preparedStatement.setTimestamp(4, order.getDeliver_date());
             preparedStatement.setString(5, order.getOrder_status());
			 
             preparedStatement.executeUpdate();
             preparedStatement.close();
   			 //connection.close();

		}catch (SQLException e){
			e.printStackTrace();
		}
	}	
	
	public void updateOrder(long idOrder, Order order){
		try {
			//connection = DBUtility.getConnection();
			 PreparedStatement preparedStatement = 
		            connection.prepareStatement("UPDATE ORDERS SET clientname = ?,order_date=?,deliver_date=?,order_status=? WHERE id_order = "+ idOrder);
			 //preparedStatement.setLong(1, order.getId_order());
             preparedStatement.setString(1, order.getClientname());
             //preparedStatement.setString(3, order.getProduct());
             //preparedStatement.setString(4, order.getMaterial_type());
             //preparedStatement.setDouble(5, order.getQuantity());
             //preparedStatement.setDouble(6, order.getUnity_weight());
             //preparedStatement.setDouble(7, order.getQuantity()*order.getUnity_weight());
             //preparedStatement.setDouble(8, order.getUnity_value());
             //preparedStatement.setDouble(9, order.getQuantity()*order.getUnity_value());
             preparedStatement.setTimestamp(2, order.getOrder_date());
             preparedStatement.setTimestamp(3, order.getDeliver_date());
             preparedStatement.setString(4, order.getOrder_status());
             preparedStatement.executeUpdate();
             preparedStatement.close();
   			 //connection.close();

		}catch (SQLException e){
			e.printStackTrace();
		}
	}	
	
	
	
	public int getMaxOrderId(){
		int maxId=0;
		try{
			//connection = DBUtility.getConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select MAX(id_order) MAXORDER from ORDERS");
			rs.next();
			maxId = rs.getInt("MAXORDER");
 //           rs.close();
//			statement.close();
			//connection.close();

		} catch (SQLException e){
				e.printStackTrace();
		}
		return maxId;
	}
	
	public List<DetailedOrder> getDetailedOrders(){
		List<DetailedOrder> detailedOrders = new ArrayList<DetailedOrder>();
		
		try{
			//connection = DBUtility.getConnection(); 
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from DETAILEDREPORT");
			while (rs.next()){
				DetailedOrder deto = new DetailedOrder();
				deto.setIdOrder(rs.getLong("idOrden"));
				deto.setClientName(rs.getString("nombreCliente"));
				deto.setOrderDate(rs.getTimestamp("fechaEntrega"));
				deto.setOrderTotalValue(rs.getDouble("costoTotal"));
				deto.setOrderStatus(rs.getString("estadoOrden"));
				deto.setFinalDeliverDate(rs.getTimestamp("fechaEntegaFinal"));
				deto.setIdOrderItem(rs.getLong("idItemOrden"));
				deto.setProduct(rs.getString("producto"));
				deto.setMaterialType(rs.getString("tipoMaterial"));
				deto.setUnityWeight(rs.getDouble("pesoUnitario"));
				deto.setTotalWeight(rs.getDouble("pesoTotal"));
				deto.setQuantity(rs.getDouble("pesoTotal"));
				deto.setUnityValue(rs.getDouble("valorUnitario"));
				deto.setTotalValue(rs.getDouble("valorTotal"));
				deto.setOrderItemStatus(rs.getString("estadoItem"));
				detailedOrders.add(deto); 
			}
            //rs.close();			
			//statement.close();
			//connection.close();
			} catch (SQLException e){
				e.printStackTrace();
			}
		    return detailedOrders;
		
	}
}

