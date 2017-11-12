package com.agn.model;

import java.sql.Timestamp;


public class Order {
	
    private long id_order;
     
    private String clientname;
    
    private Timestamp order_date;
    
    private Timestamp deliver_date;
    
    private double order_total_value;
    
    private String order_status;
    
    public Order(){
    	id_order=0;
    }
    
    public Order(long id_order, String clientname, Timestamp order_date, Timestamp deliver_date, String product, String material_type, 
    		     double order_total_value, String order_status ){
        this.id_order = id_order;
        this.clientname = clientname;
        this.order_date = order_date;
        this.deliver_date = deliver_date;
        this.order_total_value = order_total_value;
        this.order_status = order_status;
    }
     
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Order))
            return false;
        Order other = (Order) obj;
        if (id_order != other.id_order)
            return false;
        return true;
    }

	public String getClientname() {
        return clientname;
    }

	public Timestamp getDeliver_date() {
		return deliver_date;
	}

	public long getId_order() {
		return id_order;
	}



	public Timestamp getOrder_date() {
		return order_date;
	}

 
    public String getOrder_status() {
		return order_status;
	}

	public double getOrder_total_value() {
		return order_total_value;
	}

	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id_order ^ (id_order >>> 32));
        return result;
    }

	public void setClientname(String clientname) {
		this.clientname = clientname;
	}

	public void setDeliver_date(Timestamp deliver_date) {
		this.deliver_date = deliver_date;
	}

	public void setId_order(long id_order) {
		this.id_order = id_order;
	}

	public void setOrder_date(Timestamp order_date) {
		this.order_date = order_date;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

	public void setOrder_total_value(double order_total_value) {
		this.order_total_value = order_total_value;
	}

	@Override
    public String toString() {
        return "Orden [id_order=" + id_order + ", Client=" + clientname + "]";
    }
     
 
     
}