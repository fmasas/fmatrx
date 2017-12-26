package com.agn.service;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.agn.dao.OrderManagerService;
import com.agn.model.Order;
import com.agn.model.OrderItem;
import com.agn.reports.OrderReport;
import com.itextpdf.text.DocumentException;
 
@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderService{
     
	static OrderManagerService oms = new OrderManagerService();
	
    private static final AtomicLong counter = new AtomicLong();
     
    private static List<Order> orders;
     
    static{
        orders= populateDummyOrders();
    }
 
    public List<Order> findAllOrders() {
        return oms.getAllOrders();
    }
    
    public Order findById(long id) {
       return oms.getOrderById(id);
    }
     
    public Order findByName(String name) {
        for(Order order : orders){
            if(order.getClientname().equalsIgnoreCase(name)){
                return order;
            }
        }
        return null;
    }
     
    public void saveOrder(Order order) {
        //order.setId(counter.incrementAndGet());
        //orders.add(order);
        oms.insertOrder(order);
        order.setId_order(oms.getMaxOrderId());
    }
 
    public void updateOrder(long id, Order order) {
        //int index = orders.indexOf(order);
        //orders.set(index, order);
        oms.updateOrder(id, order);
        
    }
 
    public void deleteOrderById(long id) {
         
        for (Iterator<Order> iterator = orders.iterator(); iterator.hasNext(); ) {
            Order order = iterator.next();
            if (order.getId_order() == id) {
                iterator.remove();
            }
        }
    }
 
    public boolean isOrderExist(Order order) {
        return findByName(order.getClientname())!=null;
    }
     
    public void deleteAllOrders(){
        orders.clear();
    }
 
    private static List<Order> populateDummyOrders(){
        //List<Order> orders = new ArrayList<Order>();
        //orders.add(new Order(counter.incrementAndGet(),"Manuel Garcia", "Platinas", "24"));
        //orders.add(new Order(counter.incrementAndGet(),"Roberto Gomez", "Punteras", "4"));
        //orders.add(new Order(counter.incrementAndGet(),"Ancelmos", "Llaves", "100"));
        //return orders;
    	return oms.getAllOrders();
    }
    
    public Order createOrderReport(long orderId, Order order, List<OrderItem> orderitems){

    	OrderReport orderReport = new OrderReport();
    	
    	try{
    		orderReport.generateOrderReport(orderId, order, orderitems);
    	}catch(DocumentException e){
    		System.out.println("DocumentException " + e.getMessage());
    	}catch(IOException e){
    		System.out.println("IOException " + e.getMessage());
    	}
    	
    	order = null; 
    	
    	return order;
    	
    }
 
}
