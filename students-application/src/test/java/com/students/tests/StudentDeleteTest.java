package com.students.tests;

import java.util.ArrayList;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.student.base.TestBase;
import com.student.model.Student;

import static org.hamcrest.Matchers.*;
import static com.jayway.restassured.RestAssured.*;

public class StudentDeleteTest extends TestBase{

	@BeforeClass
	public static void setup(){
		RestAssured.baseURI="http://localhost";
		RestAssured.port=8085;
		RestAssured.basePath="/student";
	}
	
	
	@Test
	public void deleteStudent(){
		
		given()
		.when()
			.delete("/101")
		.then()
			.statusCode(204);
		
	}
	
}
