package restAssured;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

/* using HashMap
 * using JSONObject
 * using POJO Class
 * using external file
 * using Jackson library
 */


public class createPostRequestPayloads {
	
	
	public void usingHash() {
		
		HashMap<Object, Object> users = new HashMap <Object, Object>();
		
		users.put("firstname", "Mike");
		users.put("lastname", "John");
		users.put("email", "mike.john@gmail.com");
		
		String courses[] = {"GenAI", "GPT"};
		users.put("skills", courses);
		
		given()
			.contentType("application/json")
			.body(users)
			.log().all()
		
		.when()
			.post("http://localhost:3000/employees")
		
		.then()
			.statusCode(201).log();
					
	}
	
	
	public void usingJSONObject() {
		
		JSONObject users = new JSONObject();
		
		users.put("firstname", "Mark");
		users.put("lastname", "Steve");
		users.put("email", "mark.steve@gmail.com");
		
		String courses[] = {"GenAI", "GPT"};
		users.put("skills", courses);
		
		given()
			.contentType("application/json")
			.body(users.toString())
			.log().all()
		
		.when()
			.post("http://localhost:3000/employees")
		
		.then()
			.statusCode(201);
		
	}
	
	
	public void usingPOJO() {
		
		
		pojoRequest users = new pojoRequest();
		
		users.setFirstname("Scott");
		users.setLastname("Styris");
		users.setEmail("scott.styris@gmail.com");
		
		String skills[] = {"C#", "Python"};
		users.setSkills(skills);
		
		given()
		.contentType("application/json")
		.body(users)
		.log().all()
	
	.when()
		.post("http://localhost:3000/employees")
	
	.then()
		.statusCode(201).log();

	}
	
	
	@Test
	public void usingExternalFile() throws FileNotFoundException {
		
		File file = new File("/Users/kalai/Documents/workspace/RestAssuredFramework/datafile.json");
		FileReader fReader = new FileReader(file);
		JSONTokener jTokener = new JSONTokener(fReader);
		
		JSONObject users = new JSONObject(jTokener);
		
		given()
		.contentType("application/json")
		.body(users.toString())
		.log().all()
	
	.when()
		.post("http://localhost:3000/employees")
	
	.then()
		.statusCode(201).log();
		
	}
	
	
	
	
}

























