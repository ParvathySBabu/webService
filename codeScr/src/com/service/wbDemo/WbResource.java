package com.service.wbDemo;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path ("/resources")
public class WbResource {
	private  String item="xxx"; 
	private   int  discount =30;
	private String expiryDate ="10-03-2019";
	private String currentDate;
	
	
   //http://localhost:8080/codeScr/app/resources/create
	@GET
	@Path("/create")
	@Produces("text/plain")
	public String createOffer() {
		String pattern = "{\"item\":\"%s\",\"discount\":\"%s\",\"expiryDate\":\"%s\"}";
		return String.format(pattern,item,discount,expiryDate);
				
	}
	//http://localhost:8080/codeScr/app/resources/days
	@Path("/days")
	private String offerDays() {
	
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date date = new Date();
		currentDate = sdf.format(new Date());
		return expiryDate;
		
	}
	
	//http://localhost:8080/codeScr/app/resources/update?item=xx&discount=30
	@GET
	@Path("/update")
	@Produces("application/json")
	public String addOffer(@QueryParam("item")String item,@QueryParam("discount")String discount) {
		offerDays();
		if(currentDate.compareTo(expiryDate) >1) {
			return("Offer not valid");
		}else {
		String pattern = "{\"item\":\"%s\",\"discount\":\"%s\"}";
		return String.format(pattern,item,discount);
		}
		
	}
	
	

}
