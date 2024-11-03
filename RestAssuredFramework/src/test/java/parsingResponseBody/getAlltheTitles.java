package parsingResponseBody;

import static io.restassured.RestAssured.*;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.response.Response;


public class getAlltheTitles {
	
	
	public void titles() {
		
		Response response = given()
		
		.when()
			.get("http://localhost:3001/store");
		
		List<String> bookTitles = response.jsonPath().getList("book.title");
		
		System.out.println("BookTitles: ");
		
		for (String bookTitle : bookTitles) 
		{		
			System.out.println(bookTitle);			
		}
		
	}
	
	@Test
	public void getTitlesBasedonFiction() {
		
		Response response = given()
				
				.when()
					.get("http://localhost:3001/store");
		
		List<String> FictionBooks = response.xmlPath().getList("book.findAll {it.category == 'fiction'}.title");
		System.out.println(FictionBooks);
		
		for (String fictionBook : FictionBooks) 
		{
			
			System.out.println(fictionBook);			
		}
		
	}
		
}

