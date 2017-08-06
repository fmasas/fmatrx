package com.agn.service;

import java.util.List;

import com.agn.model.Order;
import com.agn.model.OrderItem;

public interface OrderItemService {

	OrderItem findOrderItemById(long idOrderItem);
	
	List<OrderItem> findOrderItemsById(long id);
	
	void saveOrderItem(OrderItem orderItem);
	
	void updateOrderItem(long idOrderItem, OrderItem orderItem);
	
}
