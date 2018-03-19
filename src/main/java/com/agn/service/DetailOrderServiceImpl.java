package com.agn.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.agn.dao.DetailOrderManagerService;
import com.agn.model.DetailedOrder;
import com.agn.reports.OrderReport;

@Service("detailOrderService")
@Transactional
public class DetailOrderServiceImpl implements DetailOrderService {

	static DetailOrderManagerService doms = new DetailOrderManagerService();
	
    public void createDetailedReportFile(List<DetailedOrder> detailedOrders){
    	
    	OrderReport orderReport = new OrderReport();
    	
    	try{
    		orderReport.generateDetailedReportFile(detailedOrders);
    	}catch(Exception e){
    		System.out.println("Exception " + e.getMessage());
    	}
    	
    }
 
    public List<DetailedOrder> findDetailOrders() {
        return doms.getDetailedOrders();
    }

}
