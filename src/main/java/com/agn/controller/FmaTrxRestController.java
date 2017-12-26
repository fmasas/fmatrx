package com.agn.controller;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
 









import com.agn.model.Order;
import com.agn.model.OrderItem;
import com.agn.service.OrderItemService;
import com.agn.service.OrderService;

  
@RestController
public class FmaTrxRestController {
  
    @Autowired
    OrderService orderService;  //Service which will do all data retrieval/manipulation work
    
    @Autowired
    OrderItemService orderItemService;
  
     
    //-------------------Retrieve All Orders--------------------------------------------------------
      
    @RequestMapping(value = "/order/", method = RequestMethod.GET)
    public ResponseEntity<List<Order>> listAllOrders() {
    	System.out.println("Retrieving all orders");
        List<Order> orders = orderService.findAllOrders();
        if(orders.isEmpty()){
            return new ResponseEntity<List<Order>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        System.out.println(orders.toString());
        return new ResponseEntity<List<Order>>(orders, HttpStatus.OK);
    }
  
  //-------------------Retrieve All Orders Details--------------------------------------------------------
     
    @RequestMapping(value = "/orderitems/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<OrderItem>> getOrderDetails(@PathVariable("id") long id) {
    	System.out.println("Retrieving order: " + id);
    	List<OrderItem> orderitems = orderItemService.findOrderItemsById(id);
    	if(orderitems.isEmpty()){
    		return new ResponseEntity<List<OrderItem>>(HttpStatus.NO_CONTENT); 
    	}
    	System.out.println(orderitems.toString());
    	return new ResponseEntity<List<OrderItem>>(orderitems,HttpStatus.OK); 
    }
    
    //-------------------Retrieve Single Order--------------------------------------------------------
      
    @RequestMapping(value = "/order/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Order> getOrder(@PathVariable("id") long id) {
        System.out.println("Fetching Order with id " + id);
        Order order = orderService.findById(id);
        if (order == null) {
            System.out.println("Order with id " + id + " not found");
            return new ResponseEntity<Order>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Order>(order, HttpStatus.OK);
    }
  
    //-------------------Retrieve Single Order Item--------------------------------------------------------
    //@RequestMapping(value = "/orderitems/{idDetail}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    //public ResponseEntity<OrderItem> getOrderDetail(@PathVariable("idDetail") long idDetail){
    //	System.out.println("Fetching Order Detail with id " + idDetail);
    //	OrderItem orderItem = orderItemService.findOrderItemsById(idDetail);
    //}
      
    //-------------------Create a Order--------------------------------------------------------
      
    @RequestMapping(value = "/order/", method = RequestMethod.POST)
    public ResponseEntity<Void> createOrder(@RequestBody Order order,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Order " + order.getClientname() + " and id "+ order.getId_order());
        
        //comment on 20160820 bc is not need for orders 
        //if (orderService.isOrderExist(order)) {
        //    System.out.println("A Order with name " + order.getOrdername() + " already exist");
        //    return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        //}
  
        orderService.saveOrder(order);
       
        HttpHeaders headers = new HttpHeaders();
        System.out.println("Id Created Order " + order.getId_order());
        headers.setLocation(ucBuilder.path("/order/{id}").buildAndExpand(order.getId_order()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
  
    //-------------------Create a Order Item--------------------------------------------------------
    
    @RequestMapping(value = "/orderitems/", method = RequestMethod.POST)
    public ResponseEntity<Void> createOrderItem(@RequestBody OrderItem orderItem, UriComponentsBuilder ucBuilder){
    	
    	orderItemService.saveOrderItem(orderItem);
    	
    	HttpHeaders headers = new HttpHeaders();
    	headers.setLocation(ucBuilder.path("/orderitems/{id}").buildAndExpand(orderItem.getId_order()).toUri());
    	return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    
    
      
    //------------------- Update a Order --------------------------------------------------------
      
    @RequestMapping(value = "/order/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Order> updateOrder(@PathVariable("id") long id, @RequestBody Order order) {
        System.out.println("Updating Order " + id);
          
        Order currentOrder = orderService.findById(id);
          
        if (currentOrder==null) {
            System.out.println("Order with id " + id + " not found");
            return new ResponseEntity<Order>(HttpStatus.NOT_FOUND);
        }
  
        currentOrder.setClientname(order.getClientname());
        //currentOrder.setProduct(order.getProduct());
        //currentOrder.setMaterial_type(order.getMaterial_type());
        //currentOrder.setQuantity(order.getQuantity());
        //currentOrder.setUnity_weight(order.getUnity_weight());
        //currentOrder.setTotal_weight(order.getTotal_weight());
        //currentOrder.setUnity_value(order.getUnity_value());
        //currentOrder.setTotal_value(order.getTotal_value());
        currentOrder.setOrder_date(order.getOrder_date());
        currentOrder.setDeliver_date(order.getDeliver_date());
        currentOrder.setOrder_status(order.getOrder_status());
        
           
        orderService.updateOrder(id, currentOrder);
        return new ResponseEntity<Order>(currentOrder, HttpStatus.OK);
    }
  
    //------------------- Update a Order --------------------------------------------------------
    
    @RequestMapping(value = "/orderitems/{idorderitem}", method = RequestMethod.PUT)
    public ResponseEntity<OrderItem> updateOrderItem(@PathVariable("idorderitem") long idOrderItem, @RequestBody OrderItem orderItem) {
        System.out.println("Updating OrderItem " + idOrderItem);
          
        OrderItem currentOrderItem = orderItemService.findOrderItemById(idOrderItem);
          
        if (currentOrderItem==null) {
            System.out.println("OrderItem with id " + idOrderItem + " not found");
            return new ResponseEntity<OrderItem>(HttpStatus.NOT_FOUND);
        }
  
        currentOrderItem.setMaterial_type(orderItem.getMaterial_type());
        currentOrderItem.setProduct(orderItem.getProduct());
        currentOrderItem.setOrder_item_status(orderItem.getOrder_item_status());
        currentOrderItem.setQuantity(orderItem.getQuantity());
        currentOrderItem.setUnity_value(orderItem.getUnity_value());
        currentOrderItem.setUnity_weight(orderItem.getUnity_weight());
        
        orderItemService.updateOrderItem(idOrderItem, currentOrderItem);
        return new ResponseEntity<OrderItem>(currentOrderItem, HttpStatus.OK);
    }
     
     
    //------------------- Delete a Order --------------------------------------------------------
      
    @RequestMapping(value = "/order/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Order> deleteOrder(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting Order with id " + id);
  
        Order order = orderService.findById(id);
        if (order == null) {
            System.out.println("Unable to delete. Order with id " + id + " not found");
            return new ResponseEntity<Order>(HttpStatus.NOT_FOUND);
        }
  
        orderService.deleteOrderById(id);
        return new ResponseEntity<Order>(HttpStatus.NO_CONTENT);
    }
  
      
     
    //------------------- Generate report --------------------------------------------------------
      
    @RequestMapping(value = "/orderreport/{orderid}", method = RequestMethod.GET, produces = "application/pdf")
    public ResponseEntity<InputStreamResource> getOrderReport(@PathVariable("orderid") Long orderId) throws IOException {
        System.out.println("Generate order report " + orderId);
  
        Order order = orderService.findById(orderId);
        List<OrderItem> orderitems = orderItemService.findOrderItemsById(orderId);
        
        Order order2 = orderService.createOrderReport(orderId, order, orderitems);
        
        //ClassPathResource pdfFile = new ClassPathResource("reporte.pdf");
        //Resource pdfFile = new getResource("file:c:\\testing.txt");
        FileSystemResource pdfFile = null; 
        
		InetAddress addr;
		try {
			String hostname = "Unknown"; 
			addr = InetAddress.getLocalHost();
			hostname = addr.getHostName();
			System.out.println("Hostname: " + hostname);
			
			if(hostname.equals("Pc")){
				pdfFile = new FileSystemResource("E:\\temp\\reporte.pdf");
			}else{
				pdfFile = new FileSystemResource("home/reporte.pdf");
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        
        return ResponseEntity
        		.ok()
        		.contentLength(pdfFile.contentLength())
        		.contentType(
        				MediaType.parseMediaType("application/octet-stream"))
        		.body(new InputStreamResource(pdfFile.getInputStream()));
        
        
    }
    
    
  
}
