package com.specification.examples;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.response.ValidatableResponse;
import com.jayway.restassured.specification.RequestSpecification;
import com.student.base.TestBase;
import com.sun.jersey.api.client.RequestBuilder;

import static org.hamcrest.Matchers.*;
import static com.jayway.restassured.RestAssured.*;

public class RequestSpecificationExample {

	static RequestSpecBuilder builder;
	static RequestSpecification rspec;
	
	@BeforeClass
	public static void init(){
		RestAssured.baseURI="http://localhost";
		RestAssured.port=8085;
		RestAssured.basePath="/student";
		
		builder = new RequestSpecBuilder();
		builder.addParam("programme", "Computer Science");
		builder.addParam("limit", 3);
		
		rspec = builder.build();
	}
	
	
	@Test
	public void test001(){
		given()
			.spec(rspec)
		.when()
			.get("/list")
		.then()
			.log().body()
			.statusCode(200);
	}
	
}
