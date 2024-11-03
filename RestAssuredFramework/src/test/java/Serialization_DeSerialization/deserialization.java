package Serialization_DeSerialization;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class deserialization {
	
	//convert JSON (jsondata) to POJO (pojo object)
	
	@Test
	public void deserialize() throws JsonMappingException, JsonProcessingException {
		
		
		String jsondata = "{\n"
				+ "  \"firstname\" : \"Milli\",\n"
				+ "  \"lastname\" : \"Steve\",\n"
				+ "  \"email\" : \"milli.steve@gmail.com\",\n"
				+ "  \"skills\" : [ \"Manual\", \"Automation\" ]\n"
				+ "}";
		
		ObjectMapper objectMapper = new ObjectMapper();
		Student student = objectMapper.readValue(jsondata, Student.class);
		
		System.out.println("firstname: "+student.getFirstname());
		System.out.println("lastname: "+student.getLastname());
		System.out.println("email: " +student.getEmail());
		System.out.println("skills 1: "+student.getSkills()[0]);
		System.out.println("skills 2: "+student.getSkills()[1]);
		
	}

}
