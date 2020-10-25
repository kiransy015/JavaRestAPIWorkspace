package com.students.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.student.base.TestBase;

import static org.hamcrest.Matchers.*;
import static com.jayway.restassured.RestAssured.*;

public class StudentGetTest extends TestBase{
	
	//@Test
	public void getAllStudentInformation(){
		
		/*Response response = given()
							.when()
								.get("/list");
		System.out.println(response.body().prettyPrint());*/
		
		//validate the status code
		given()
		.when()
			.get("/list")
		.then()
			.statusCode(200);
	}
	
	
	//@Test
	public void getStudentInfo(){
		Response response = given()
							.when()
								.get("/1");
		System.out.println(response.body().prettyPrint());
		
		given()
		.when()
			.get("/1")
		.then()
			.statusCode(200);
	}
	
	
	
	//@Test
	public void getStudentsFromFA(){
		/*Response response = given()
							.when()
								.get("/list?programme=Financial Analysis&limit=2");
		System.out.println(response.body().prettyPrint());*/
		
		Response response = given()
								.param("programme", "Financial Analysis")
								.param("limit", 2)
							.when()
								.get("/list");
								
		System.out.println(response.body().prettyPrint());
							
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
