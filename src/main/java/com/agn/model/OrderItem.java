package com.agn.model;

public class OrderItem {
	
    private long id_order_item;
	
	private long id_order;
	
	private String product;
	
	private String material_type;

	private double unity_weight;

	private double total_weight;

	private double quantity;

	private double unity_value;

	private double total_value;

	private String order_item_status;

	public OrderItem(){
    	id_order_item=0;
    }

	public OrderItem(long id_det_order, long id_order ){
       this.id_order_item = id_det_order;
       this.id_order = id_order;
    }

	@Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof OrderItem))
            return false;
        OrderItem other = (OrderItem) obj;
        if (id_order != other.id_order_item)
            return false;
        return true;
    }

	public long getId_order() {
		return id_order;
	}

	public long getId_order_item() {
		return id_order_item;
	}

	public String getMaterial_type() {
		return material_type;
	}

	public String getOrder_item_status() {
		return order_item_status;
	}

	public String getProduct() {
		return product;
	}

	public double getQuantity() {
		return quantity;
	}

	public double getTotal_value() {
		return total_value;
	}
	
	public double getTotal_weight() {
		return total_weight;
	}
	
	public double getUnity_value() {
		return unity_value;
	}
	
	public double getUnity_weight() {
		return unity_weight;
	}
	
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id_order_item ^ (id_order_item >>> 32));
        return result;
    }
	
	public void setId_order(long id_order) {
		this.id_order = id_order;
	}
	
	public void setId_order_item(long id_det_order) {
		this.id_order_item = id_det_order;
	}
	
	public void setMaterial_type(String material_type) {
		this.material_type = material_type;
	}
    
    public void setOrder_item_status(String order_item_status) {
		this.order_item_status = order_item_status;
	}
	
	public void setProduct(String product) {
		this.product = product;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public void setTotal_value(double total_value) {
		this.total_value = total_value;
	}

	public void setTotal_weight(double total_weight) {
		this.total_weight = total_weight;
	}
    
	public void setUnity_value(double unity_value) {
		this.unity_value = unity_value;
	}
	
	public void setUnity_weight(double unity_weight) {
		this.unity_weight = unity_weight;
	}
	
	@Override
    public String toString() {
        return "OrdetDet [id_det_order=" + id_order_item + ", id_order=" + id_order + ", order_item_status " + order_item_status + "]";
    }

	
}