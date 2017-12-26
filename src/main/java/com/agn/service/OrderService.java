package com.agn.service;

import java.util.List;

import com.agn.model.Order;
import com.agn.model.OrderItem;
 
public interface OrderService {
     
    Order findById(long id);
     
    Order findByName(String name);
     
    void saveOrder(Order order);
     
    void updateOrder(long id, Order order);
     
    void deleteOrderById(long id);
    
    Order createOrderReport(long orderId, Order order, List<OrderItem> orderitems);
 
    List<Order> findAllOrders(); 
     
    void deleteAllOrders();
     
    public boolean isOrderExist(Order order);
    
    //New classes to database 
    
	//Order save(Order order);
     
}
