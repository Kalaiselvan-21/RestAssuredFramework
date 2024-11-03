package Serialization_DeSerialization;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class serialization {
	
	
	@Test
	//Convert POJO (object) to JSON (data)
	void serialize() throws JsonProcessingException
	{
		Student student = new Student();
		student.setFirstname("Milli");
		student.setLastname("Steve");
		student.setEmail("milli.steve@gmail.com");
		
		String skillset[] = {"Manual","Automation"};
		student.setSkills(skillset);
		
		ObjectMapper objectMapper = new ObjectMapper();
		String jsondata = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(student);
		System.out.println("JSONDATA" +jsondata);		
		
	}
	
}
