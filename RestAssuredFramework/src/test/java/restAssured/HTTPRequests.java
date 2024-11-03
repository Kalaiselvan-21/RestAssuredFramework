package restAssured;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;

public class HTTPRequests {
	
	String id;
	
	@Test (priority=1)
	public void getUsers() {
		
		when()
			.get("http://localhost:3000/employees")
		
		.then()
			.statusCode(200).log().all();
	}
	
	@Test (priority=2)
	public void createUser() {
			
		HashMap<Object, Object> users = new HashMap<Object, Object>();
		users.put("firstname", "Harry");	
		users.put("lastname", "Dick");
		users.put("email", "Harry.Dick@gmail.com");
		
		String skills[]= {"Cucumber","json"};
		users.put("skills", skills);
		
		
		id = given()
			.contentType("application/json")
			.body(users)
		
		.when()
			.post("http://localhost:3000/employees").jsonPath().getString("id");
			System.out.println("ID is : " +id);

		//.then()
			
	}
	
	@Test (priority = 3)
	public void updateUser() {
		
		HashMap<Object, Object> users = new HashMap<Object, Object>();
		users.put("firstname", "Tom");	
		users.put("lastname", "Dick");
		users.put("email", "tom.dick@gmail.com");
		
		String skills[]= {"BDD","cypress"};
		users.put("skills", skills);
		
		given()
			.contentType("application/json")
			.body(users)
		
		.when()
			.put("http://localhost:3000/employees/"+id)
		
		.then()
			.statusCode(200).log().all();
	}
	
	@Test (priority = 4)
	public void deleteUser() {
		
		given()
		
		.when()
			.put("http://localhost:3000/employees/" +id)
		
		.then()
			.statusCode(200);
	}
	
	@Test (priority = 5)
	public void deleteUserswithNameTom() {
		
		List<String> userIDs = given()
		
		.when()
			.get("http://localhost:3000/employees")
			
		.then()
			.statusCode(200)
			.extract()
			.jsonPath()
			.getList("findAll {it.firstname == 'Tom'}.id");
		
		System.out.println("UserIDs are: "+userIDs);
		
		
		for (String userID :userIDs) {
			
			given()
			
			.when()
				.delete("http://localhost:3000/employees/" +userID)
			
			.then()
				.statusCode(200).log().all();
		}
		
	}
	
//	@Test()
//	public void deleteUsersWithoutFirstName() {
//	    // Step 1: Get all IDs of users without a firstname
//	    List<String> idsWithoutFirstName = given()
//	        .when()
//	            .get("http://localhost:3000/employees") // Adjust the endpoint as necessary
//	        .then()
//	            .statusCode(200)
//	            .extract()
//	            .jsonPath()
//	            .getList("findAll { it.firstname == null }.id"); // Select IDs where firstname is null
//
//	    System.out.println("IDs without firstname: " + idsWithoutFirstName);
//
//	    // Step 2: Delete each user by ID if they don’t have a firstname
//	    for (String userID : idsWithoutFirstName) {
//	        given()
//	            .log().all() // Log request details
//	            .when()
//	                .delete("http://localhost:3000/employees/" + userID)
//	            .then()
//	                .statusCode(200) // Expecting 204 No Content for successful deletion
//	                .log().all(); // Log response details
//	    }
//
//	    System.out.println("Deleted entries without a firstname: " + idsWithoutFirstName);
//	}
	
}


















