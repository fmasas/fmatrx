package com.agn.reports;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import org.springframework.core.io.FileSystemResource;

import com.agn.model.Order;
import com.agn.model.OrderItem;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;



public class OrderReport {

	public Integer generateOrderReport(Long orderId, Order order, List<OrderItem> orderitems) throws IOException, DocumentException {
    	
    	String dest = null;
    	//C:\Users\Usuario\workspace-smvc\FmaTransaccional\src\main\resources
    	///FmaTransaccional/src/main/resources
    	//String dest = "C:\\Users\\Usuario\\workspace-smvc\\FmaTransaccional\\src\\main\\resources\\reporte.pdf";
    	
		InetAddress addr;
		try {
			String hostname = "Unknown"; 
			addr = InetAddress.getLocalHost();
			hostname = addr.getHostName();
			System.out.println("Hostname: " + hostname);
			
			if(hostname.equals("Pc")){
				dest = "E:\\temp\\reporte.pdf";
			}else{
				dest = "/home/reporte.pdf";
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    	File file = new File(dest);
    	
    	System.out.println("About to generate the report on" + dest);
    	
    	Document document = new Document();
    	PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(dest));
    	
    	document.open();
    	
    	PdfContentByte cb = writer.getDirectContent();
    	
    	BaseFont bf = BaseFont.createFont(BaseFont.COURIER_BOLD, BaseFont.CP1252, BaseFont.EMBEDDED);
    	
    	cb.setFontAndSize(bf, 12);
    	
    	cb.beginText();
    	
    	cb.setTextMatrix(30,800);
    	cb.showText("FMA - Reporte de ordenes");
    	cb.setTextMatrix(30,780);
    	cb.showText("Orden ID: " + orderId.toString());
    	cb.setTextMatrix(30,760);
    	cb.showText("Cliente: " + order.getClientname());
    	cb.setTextMatrix(30,740);
    	cb.showText("Fecha de orden: " + order.getOrder_date());
    	cb.setTextMatrix(30,720);
    	cb.showText("Fecha de entrega: " + order.getDeliver_date());
    	cb.setTextMatrix(30,680);
    	cb.showText("Producto"); 
    	cb.setTextMatrix(290,680);
    	cb.showText("Material");
    	cb.setTextMatrix(380,680);
    	cb.showText("Cantidad");
    	cb.setTextMatrix(460,680);
    	cb.showText("Peso");
    	
    	int posY = 660;
    	
    	bf = BaseFont.createFont(BaseFont.COURIER, BaseFont.CP1252, BaseFont.EMBEDDED);
    	cb.setFontAndSize(bf, 11);
    	
    	for(OrderItem oi : orderitems){
    		cb.setTextMatrix(30,posY);
    		cb.showText(oi.getProduct());
    		cb.setTextMatrix(290,posY);
    		cb.showText(oi.getMaterial_type());    		
    		cb.setTextMatrix(380,posY);
    		cb.showText(String.valueOf(oi.getQuantity()));
    		cb.setTextMatrix(460,posY);
    		cb.showText(String.valueOf(oi.getTotal_weight()));
    		
    		posY = posY - 20;
    	}
    	
    	cb.setTextMatrix(30,330);
    	cb.showText("Entregado por: ");
    	
    	cb.endText();
    	
//    	PdfPTable table = new PdfPTable(8);
//    	for(int aw = 0; aw < 16; aw++){
//    		table.addCell("Hi");
//    	}
//    	PdfContentByte canvas = writer.getDirectContent();
//    	table.writeSelectedRows(1, 2, 80, 100, canvas);
//        
//    	document.add(table);
    	
    	document.close();
    	
    	return 1;
    }
	
}
