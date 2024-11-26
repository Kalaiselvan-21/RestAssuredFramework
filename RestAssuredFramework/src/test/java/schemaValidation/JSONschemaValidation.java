package schemaValidation;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

public class JSONschemaValidation {
	
	@Test
	public void schemavalidate() {
		
		when()
			.get("http://localhost:3001/store")
		
		.then()
			.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonSchema.json"));
		
		
	}

}
