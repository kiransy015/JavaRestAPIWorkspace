package com.students.tests;

import org.testng.annotations.Test;

import com.student.base.TestBase;

import static org.hamcrest.Matchers.*;
import static com.jayway.restassured.RestAssured.*;

public class LoggingResponseValues extends TestBase {

	//@Test
	public void test001(){
		
		System.out.println("------------- Printing Response headers ----------------");
		
		given()
			.param("programme", "Computer Science")
			.param("limit", 1)
		.when()
			.get("/list")
		.then()
			.log().headers();
	}
	
	
	//@Test
	public void test002(){
		
		System.out.println("------------- Printing Response status ----------------");
		
		given()
			.param("programme", "Computer Science")
			.param("limit",1)
		.when()
			.get("/list")
		.then()
			.log().status();
	}
	
	
	//@Test
	public void test003(){
		
		System.out.println("------------- Printing Response Body ----------------");
		
		given()
			.param("programme", "Computer Science")
			.param("limit", 1)
		.when()
			.get("/list")
		.then()
			.log().body();
	}
	
	
	@Test
	public void test004(){
		
		System.out.println("------------- Printing Response Body incase of an error ----------------");
		
		given()
			.param("programme", "Computer Science")
			.param("limit", -1)
		.when()
			.get("/list")
		.then()
			.log().ifError();		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
