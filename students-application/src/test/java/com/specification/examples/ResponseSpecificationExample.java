package com.specification.examples;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.builder.ResponseSpecBuilder;
import com.jayway.restassured.response.ValidatableResponse;
import com.jayway.restassured.specification.RequestSpecification;
import com.jayway.restassured.specification.ResponseSpecification;
import com.student.base.TestBase;
import com.sun.jersey.api.client.RequestBuilder;

import static org.hamcrest.Matchers.*;
import static com.jayway.restassured.RestAssured.*;


public class ResponseSpecificationExample {
	
	static RequestSpecBuilder builder;
	static RequestSpecification rspec;
	
	static ResponseSpecBuilder respBuilder;
	static ResponseSpecification respSpec;
	
	static HashMap<String,Object> respParameters = new HashMap<String,Object>();

	@BeforeClass
	public static void init(){
		RestAssured.baseURI="http://localhost";
		RestAssured.port=8085;
		RestAssured.basePath="/student";
		
		builder = new RequestSpecBuilder();
		builder.addParam("programme", "Computer Science");
		builder.addParam("limit", 3);		
		rspec = builder.build();		
		
		respParameters.put("Content-Type", "application/json;charset=UTF-8");
		respParameters.put("Transfer-Encoding", "chunked");
		
		respBuilder = new ResponseSpecBuilder();
		respBuilder.expectHeaders(respParameters);
		respBuilder.expectBody("courses.size()",equalTo(3));
		respBuilder.expectStatusCode(201);
		respSpec = respBuilder.build();
		
	}
	
	
	@Test
	public void test001(){
		given()
			.spec(rspec)
		.when()
			.get("/list")
		.then()
			.spec(respSpec);
	}
	
}
