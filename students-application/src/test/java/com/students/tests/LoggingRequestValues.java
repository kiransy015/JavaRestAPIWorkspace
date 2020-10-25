package com.students.tests;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.jayway.restassured.http.ContentType;
import com.student.base.TestBase;
import com.student.model.Student;

import static org.hamcrest.Matchers.*;
import static com.jayway.restassured.RestAssured.*;

public class LoggingRequestValues extends TestBase{

	
	//@Test
	public void test001(){
		System.out.println("------------- Printing Request Headers ----------------");
		given()
			.log().headers()
		.when()
			.get("1")
		.then()
			.statusCode(200);
		
	}
	
	
	//@Test
	public void test002(){
		System.out.println("------------- Printing Request Parameters ----------------");
		given()
			.param("programme", "Computer Science")
			.param("limit", 1)
			.log().params()
		.when()
			.get("list")
		.then()
			.statusCode(200);
		
	}
	
	
	//@Test
	public void test003(){
		System.out.println("------------- Printing Request Body ----------------");
		
		ArrayList<String> courses = new ArrayList();
		courses.add("Java");
		courses.add("Python");
		
		Student std = new Student();
		std.setFirstName("Kiran");
		std.setLastName("Kumar");
		std.setEmail("Kiran@gmail.com");
		std.setProgramme("Computer Science");
		std.setCourses(courses);
		
		given()
			.log().body()
			.contentType(ContentType.JSON)
		.when()
			.body(std)
			.post();
			
	}
	
	
	
	//@Test
	public void test004(){
		System.out.println("------------- Printing All the Request Details ----------------");
		
		ArrayList<String> courses = new ArrayList();
		courses.add("Java");
		courses.add("Python");
		
		Student std = new Student();
		std.setFirstName("Kiran");
		std.setLastName("Kumar");
		std.setEmail("Kiran@gmail.com");
		std.setProgramme("Computer Science");
		std.setCourses(courses);
		
		given()
			.log().all()
			.contentType(ContentType.JSON)
		.when()
			.body(std)
			.post();		
		
	}
	
	
	
	@Test
	public void test005(){
		System.out.println("------------- Printing All the Request Details if the validation fails ----------------");
		
		ArrayList<String> courses = new ArrayList();
		courses.add("Java");
		courses.add("Python");
		
		Student std = new Student();
		std.setFirstName("Kiran1");
		std.setLastName("Kumar1");
		std.setEmail("Kiran1@gmail.com");
		std.setProgramme("Computer Science");
		std.setCourses(courses);
		
		given()
			.log().ifValidationFails()
			.contentType(ContentType.JSON)
		.when()
			.body(std)
			.post()
		.then()
			.statusCode(201);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
