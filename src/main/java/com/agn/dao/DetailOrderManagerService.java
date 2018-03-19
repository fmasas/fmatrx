package com.agn.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.agn.model.DetailedOrder;

public class DetailOrderManagerService {

	private Connection connection; 
	
	public DetailOrderManagerService(){
		connection = DBUtility.getConnection();
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
