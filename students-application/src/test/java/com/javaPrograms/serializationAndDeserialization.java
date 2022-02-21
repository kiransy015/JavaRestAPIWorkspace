package com.javaPrograms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.testng.annotations.Test;
import com.student.base.TestBase;
import com.student.model.Student;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.internal.http.ContentTypeExtractor;
import com.jayway.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import static com.jayway.restassured.RestAssured.*;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.lang.reflect.Type;


public class serializationAndDeserialization extends TestBase {
	
	static ObjectMapper Mapper = new ObjectMapper();

	//@Test
	/*
	 * Serialization is a process of converting an object from its current state to a stream of bytes which can be written to a file or transported through a network or stored in a database.
	 */
	public static void serializefunc() throws JsonGenerationException, JsonMappingException, IOException{
		List lt = new ArrayList();
		lt.add("c++");
		lt.add("java");
		lt.add("phython");
		Student st = new Student();
		st.setFirstName("kiran");
		st.setLastName("kumar");
		st.setEmail("kiran015sy@gmail.com");
		st.setProgramme("Mechanical Engineering");
		st.setCourses(lt);
		
		String json = Mapper.writeValueAsString(st);
		
		given()
			.log().all()
			.contentType(ContentType.JSON)
		.when()
			.body(json)
			.post()
		.then()
			.statusCode(201);
	}
	
	
	@Test
	/*
	 * De-serialization is rebuilding the object from stream of bytes.
	   Deserialization in Rest Assured is converting Responsebody back to java object with the support of pojo classes.
       If the response is wrapped as java object, then it is easy to parse and extract response using getters methods.
	 */
	public static void deSerializeSingleObject() throws JsonGenerationException, JsonMappingException, IOException{

		String url1 = "http://localhost:8085/student/1";
		
		Student stddtl = given()
						   .when()
						    	.get(url1).as(Student.class);
		
		System.out.println("Student 1 details :"+"\n"+stddtl.getFirstName().toString());
		System.out.println("Student 1 details :"+"\n"+stddtl.getLastName().toString());
		System.out.println("Student 1 details :"+"\n"+stddtl.getEmail().toString());
		System.out.println("Student 1 details :"+"\n"+stddtl.getProgramme().toString());
		System.out.println("Student 1 details :"+"\n"+stddtl.getCourses().toString());
		
	}
	
	
	//@Test
	/*
	 * De-serialization is rebuilding the object from stream of bytes.
	   Deserialization in Rest Assured is converting Responsebody back to java object with the support of pojo classes.
	   If the response is wrapped as java object, then it is easy to parse and extract response using getters methods.
	 */
	public static void deSerializeCompleteObject() throws JsonGenerationException, JsonMappingException, IOException{

		String url3 = "http://localhost:8085/student/list";
		
		Student[] stddtl = given()
						   .when()
						    	.get(url3).as(Student[].class);
		
		for(int i=0;i<=stddtl.length-1;i++){
			System.out.println("Student "+i+1+" Details : ");
			System.out.println("Student Id :"+"\n"+stddtl[i].getId().toString());
			System.out.println("Student FirstName :"+"\n"+stddtl[i].getFirstName().toString());
			System.out.println("Student LastName :"+"\n"+stddtl[i].getLastName().toString());
			System.out.println("Student Email :"+"\n"+stddtl[i].getEmail().toString());
			System.out.println("Student Programme :"+"\n"+stddtl[i].getProgramme().toString());
			System.out.println("Student Courses :"+"\n"+stddtl[i].getCourses().toString());
		}
		
	}
	
}
