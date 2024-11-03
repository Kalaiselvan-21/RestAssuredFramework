package parsingResponseBody;

import static io.restassured.RestAssured.*;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class getBookPrice {
	
	public void BookPrice() {
		
		Response response = 
				
		given()
		
		.when()
			.get("http://localhost:3001/store");
		
		List<Number> priceList = response.jsonPath().getList("book.price");
			
		System.out.println("PriceList: ");
		float totalPrice = 0;
		
		for(Number price : priceList) 
		{
			
			totalPrice = totalPrice+price.floatValue();
			
		}
		System.out.println(totalPrice);
		
	}
	
	@Test
	public void getFictionBookPrices() {
		
		Response response = 
		
		given()
				
		.when()
			.get("http://localhost:3001/store");
		
		List<Number> fictionBookPrice = response.jsonPath().getList("book.findAll {it.category == 'fiction'}.price");
		
		float fictiontotalPrice = 0;
		
		for (Number fictionPrice : fictionBookPrice) 
		{
			fictiontotalPrice = fictiontotalPrice + fictionPrice.floatValue();
			
		}
		
		System.out.println("Total FictionBook Price: " +fictiontotalPrice);
		
	}

}
