package com.responseextraction.assertions;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.ss.formula.ptg.LessEqualPtg;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ValidatableResponse;
import com.student.base.TestBase;

import static org.hamcrest.Matchers.*;
import static com.jayway.restassured.RestAssured.*;

public class AddingAssertions {

	static HashMap<String,Object> parameters = new HashMap<String,Object>();
	
	@BeforeClass
	public static void init(){
		RestAssured.baseURI="http://localhost";
		RestAssured.port=8085;
		RestAssured.basePath="/student";
		
		parameters.put("programme", "Computer Science");
		parameters.put("limit", 3);
	}
	
	
	//Assert on count value
	//@Test
	public void test001(){
		
		given()
			.params(parameters)
		.when()
			.get("/list")
		.then()
			.body("courses.size()", equalTo(3));		
	}
	
	
	//Assert on Single Name
	//@Test
	public void test002(){
		given()
			.params(parameters)
		.when()
			.get("/list")
		.then()
			.body("firstName", hasItem("Reece"));
	}
	
	
	
	//Assert on multiple names
	//@Test
	public void test003(){
		given()
			.params(parameters)
		.when()
			.get("/list")
		.then()
			.body("firstName", hasItems("Reece","Orson"));
	}
	
	
	
	//Assert using logical function
	//@Test
	public void test004(){
		given()
			.params(parameters)
		.when()
			.get("/list")
		.then()
			.body("courses.size()", greaterThan(2))
			.body("courses.size()", lessThan(5));
	}
	
	
	//Adding multiple assertions in single test
	@Test
	public void test005(){
		given()
			.params(parameters)
		.when()
			.get("/list")
		.then()
			.body("courses.size()", equalTo(3))
			.body("firstName", hasItem("Reece"))
			.body("firstName", hasItems("Reece","Orson"))
			.body("courses.size()", greaterThan(2))
			.body("courses.size()", lessThan(5));
	}
	
	
	//Assert using TestNG method
	@Test
	public void test006(){
		ArrayList<String> courseCnt = 	given()
										.params(parameters)
									.when()
										.get("list")
									.then()
										.extract().path("courses");
		
		Assert.assertTrue(courseCnt.size()==3, "Not Matching");
	}
	
	
	
	
}
