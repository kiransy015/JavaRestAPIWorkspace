package com.responseextraction.rootpath;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.ValidatableResponse;
import com.student.base.TestBase;

import static org.hamcrest.Matchers.*;
import static com.jayway.restassured.RestAssured.*;

public class RootPathExample1 {
	
	static HashMap<String,Object> parameters = new HashMap<String,Object>();

	@BeforeClass
	public static void init(){
		RestAssured.baseURI="http://localhost";
		RestAssured.port=8085;
		RestAssured.basePath="/student";
		
		parameters.put("programme", "Computer Science");
		parameters.put("limit", 3);
	}
	
	//Path set using root
	@Test
	public void test001(){
		given()
		.params(parameters)
	.when()
		.get("/list")
	.then()
		.root("corses")
		.body(".size()", equalTo(3))
		.body(".size()", greaterThan(2))
		.body(".size()", lessThan(5))
		
		.root("")
		.body("firstName", hasItem("Reece"))
		.body("firstName", hasItems("Reece","Orson"));
		
	}

}
