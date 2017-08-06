package com.agn.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.agn.dao.OrderItemManagerService;
import com.agn.model.Order;
import com.agn.model.OrderItem;

@Service("orderItemService")
@Transactional 
public class OrderItemServiceImpl implements OrderItemService {

	static OrderItemManagerService oims = new OrderItemManagerService();
	
    public OrderItem findOrderItemById(long idOrderItem) {
        return oims.getOrderItemById(idOrderItem);
    }
	
	public List<OrderItem> findOrderItemsById(long id) {
		return oims.getOrderItemsById(id);
	}
	
    public void saveOrderItem(OrderItem orderItem) {
        //order.setId(counter.incrementAndGet());
        //orders.add(order);
        oims.insertOrderItem(orderItem);
        orderItem.setId_order(oims.getMaxOrderItemId());
    }
    
    public void updateOrderItem(long idOrderItem, OrderItem orderItem){
        	oims.updateOrderItem(idOrderItem, orderItem);
    }
     
}
