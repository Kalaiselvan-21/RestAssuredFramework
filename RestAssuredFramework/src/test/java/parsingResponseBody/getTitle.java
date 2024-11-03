package parsingResponseBody;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

import io.restassured.response.Response;

// This is to get the title of the 1st book

public class getTitle {
	
	@Test
	public void bookTitle() {
		
		Response res = given()
		
		.when()
			.get("http://localhost:3001/store");
		
		System.out.println("Response Status Code: " + res.getStatusCode());
		System.out.println("Response Body: " + res.asString());
		
		String bookname = res.jsonPath().getString("book[2].title");
		System.out.println("Bookname: " +bookname);		
	}

}
