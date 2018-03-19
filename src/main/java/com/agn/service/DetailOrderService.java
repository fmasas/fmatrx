package com.agn.service;

import java.util.List;

import com.agn.model.DetailedOrder;

public interface DetailOrderService {
	
    void createDetailedReportFile(List<DetailedOrder> detailedOrders);
	
	List<DetailedOrder> findDetailOrders();

}
