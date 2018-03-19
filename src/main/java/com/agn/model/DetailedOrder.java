package com.agn.model;

import java.sql.Timestamp;

public class DetailedOrder {
	
	private long idOrder;
	private String  clientName;
	private Timestamp orderDate;
	private Timestamp deliverDate;
	private double orderTotalValue;
	private String orderStatus;
	private Timestamp finalDeliverDate;
	private long idOrderItem;
	private String product;
	private String materialType;
	private double unityWeight;
	private double totalWeight;
	private double quantity;
	private double unityValue;
	private double totalValue;
	private String orderItemStatus;
	
	public long getIdOrder() {
		return idOrder;
	}
	public void setIdOrder(long idOrder) {
		this.idOrder = idOrder;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public Timestamp getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}
	public Timestamp getDeliverDate() {
		return deliverDate;
	}
	public void setDeliverDate(Timestamp deliverDate) {
		this.deliverDate = deliverDate;
	}
	public double getOrderTotalValue() {
		return orderTotalValue;
	}
	public void setOrderTotalValue(double orderTotalValue) {
		this.orderTotalValue = orderTotalValue;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public Timestamp getFinalDeliverDate() {
		return finalDeliverDate;
	}
	public void setFinalDeliverDate(Timestamp finalDeliverDate) {
		this.finalDeliverDate = finalDeliverDate;
	}
	public long getIdOrderItem() {
		return idOrderItem;
	}
	public void setIdOrderItem(long idOrderItem) {
		this.idOrderItem = idOrderItem;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getMaterialType() {
		return materialType;
	}
	public void setMaterialType(String materialType) {
		this.materialType = materialType;
	}
	public double getUnityWeight() {
		return unityWeight;
	}
	public void setUnityWeight(double unityWeight) {
		this.unityWeight = unityWeight;
	}
	public double getTotalWeight() {
		return totalWeight;
	}
	public void setTotalWeight(double totalWeight) {
		this.totalWeight = totalWeight;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public double getUnityValue() {
		return unityValue;
	}
	public void setUnityValue(double unityValue) {
		this.unityValue = unityValue;
	}
	public double getTotalValue() {
		return totalValue;
	}
	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}
	public String getOrderItemStatus() {
		return orderItemStatus;
	}
	public void setOrderItemStatus(String orderItemStatus) {
		this.orderItemStatus = orderItemStatus;
	} 

	
}
