package com.students.tests;

import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.print.DocFlavor.STRING;

import org.openqa.selenium.json.Json;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.filter.Filter;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.internal.mapper.ObjectMapperType;
import com.jayway.restassured.mapper.ObjectMapper;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Cookie;
import com.jayway.restassured.response.Cookies;
import com.jayway.restassured.response.Header;
import com.jayway.restassured.response.Headers;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ValidatableResponse;
import com.student.base.TestBase;
import com.student.model.Student;
import com.sun.research.ws.wadl.Param;

import org.openqa.selenium.json.Json;
import org.openqa.selenium.support.FindAll;

import static org.hamcrest.Matchers.*;
import static com.jayway.restassured.RestAssured.*;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.builder.ResponseBuilder;
import com.jayway.restassured.builder.ResponseSpecBuilder;
import com.jayway.restassured.config.RestAssuredConfig;
import com.jayway.restassured.response.ValidatableResponse;
import com.jayway.restassured.specification.AuthenticationSpecification;
import com.jayway.restassured.specification.MultiPartSpecification;
import com.jayway.restassured.specification.ProxySpecification;
import com.jayway.restassured.specification.RedirectSpecification;
import com.jayway.restassured.specification.RequestLogSpecification;
import com.jayway.restassured.specification.RequestSpecification;
import com.jayway.restassured.specification.ResponseSpecification;
import com.student.base.TestBase;
import com.sun.jersey.api.client.RequestBuilder;



public class SampleTest{
	
	static RequestSpecification reqSpec;
	static RequestSpecBuilder reqBuilder;
	static ResponseSpecification resSpec;
	static ResponseSpecBuilder resBuilder;
	
	static HashMap<String,Object> respParameters = new HashMap<String,Object>();
	
	@BeforeClass
	public static void init(){
		RestAssured.baseURI="http://localhost";
		RestAssured.port=8085;
		RestAssured.basePath="/student";
		RestAssured.rootPath="courses";
		
		reqBuilder = new RequestSpecBuilder();
		reqBuilder.addParam("programme", "Financial Analysis");
		reqBuilder.addParam("limit", 2);
		
		reqSpec = reqBuilder.build();
		
		respParameters.put("Content-Type", "application/json;charset=UTF-8");
		respParameters.put("Transfer-Encoding", "chunked");
		
		resBuilder = new ResponseSpecBuilder();
		resBuilder.expectHeaders(respParameters);
		resBuilder.expectBody("courses.size()",equalTo(3));
		resBuilder.expectStatusCode(201);
		resSpec = resBuilder.build();
	}

	//@Test
	public void getAllStudentInformation(){
		Response res = given()
					   .when()
					   		.get("/list");
		System.out.println("Response :"+res.body().prettyPrint());
	}
	
	
	//@Test
	public void getStudentInfo(){
		Response res = given()
					   .when()
					   		.get("/1");
		System.out.println("Response :"+res.body().prettyPrint());
	}
	
	
	//@Test
	public void getStudentsFromFA(){
		Response res = given()		
					   		.param("programme", "Financial Analysis")
					   		.param("limit", "2")
					   .when()
					   		.get("/list");
		System.out.println("Response :"+res.body().prettyPrint());
	}
	
	
	//@Test
	public void createNewStudent(){
		Student std = new Student();
		std.setFirstName("Kiran");
		std.setLastName("Kumar");
		std.setEmail("kiran@gmail.com");
		std.setProgramme("Computer Science");
		
		List<String> courses = new ArrayList<String>();
		courses.add("Computer Science");
		courses.add("Electronics and Communication");
		
		std.setCourses(courses);
		
		Response res = given()
					   		.contentType(ContentType.JSON)
					   .when()
					   	    .body(std)
					   		.post();
		System.out.println("Response :"+res.body().prettyPrint());
	}
	
	
	
	//@Test
	public void updateStudentInfo(){
		
		List<String> courses = new ArrayList<String>();
		courses.add("Computer Science");
		courses.add("Electronics and Communication");
		
		Student std = new Student();
		std.setFirstName("Kiran");
		std.setLastName("Kumar");
		std.setEmail("kiransy@gmail.com");
		std.setProgramme("Computer Science");
		std.setCourses(courses);
		
		Response res = given()
					   		.contentType(ContentType.JSON)
					   .when()
					   	 	.body(std)
					   		.put("/103");
		System.out.println("Response :"+res.body().prettyPrint());
	}
	
	
	
	//@Test
	public void deleteStudent(){
		Response res =  given()
						.when()
							.delete("/103");
		System.out.println("Response :"+res.body().prettyPrint());
	}
	
	
	//@Test
	public void test001(){
		System.out.println("------------- Printing Request Headers ----------------");
		
		given()
			.log().headers()
		.when()
			.get("/list");
		
	}
	
	
	
	//@Test
	public void test002(){
		System.out.println("------------- Printing Request Parameters ----------------");
		Response res  = given()
							.param("programme", "Financial Analysis")
							.param("limit", 2)
							.log().params()
						.when()
							.get("/list");
		System.out.println("Response :"+res.body().prettyPrint());
	}
	
	
	//@Test
	public void test003(){
		System.out.println("------------- Printing Request Body ----------------");
		
		List<String> courses = new ArrayList<String>();
		courses.add("Computer Science");
		courses.add("Electronics and Communication");
		
		Student std = new Student();
		std.setFirstName("Kiran");
		std.setLastName("Kumar");
		std.setEmail("kiran@gmail.com");
		std.setProgramme("Computer Science");
		std.setCourses(courses);
		
		Response res =  given()
							.contentType(ContentType.JSON)
							.log().body()
						.when()
							.body(std)
							.post();
		System.out.println("Response :"+res.body().prettyPrint());
	}
	
	
	
	//@Test
	public void test004(){
		System.out.println("------------- Printing All the Request Details ----------------");
		
		List<String> courses = new ArrayList<String>();
		courses.add("Computer Science");
		courses.add("Electronics and Communication");
		
		Student std = new Student();
		std.setFirstName("Kiran");
		std.setLastName("Kumar");
		std.setEmail("kiran@gmail.com");
		std.setProgramme("Computer Science");
		std.setCourses(courses);
		
		Response res =  given()
							.contentType(ContentType.JSON)
							.log().all()
						.when()
							.body(std)
							.post();
		System.out.println("Response :"+res.body().prettyPrint());
	}
	
	
	
	//@Test
	public void test005(){
		System.out.println("------------- Printing All the Request Details if the validation fails ----------------");
		
		List<String> courses = new ArrayList<String>();
		courses.add("Computer Science");
		courses.add("Electronics and Communication");
		
		Student std = new Student();
		std.setFirstName("Kiran");
		std.setLastName("Kumar");
		std.setEmail("kiran@gmail.com");
		std.setProgramme("Computer Science");
		std.setCourses(courses);
		
		given()
			.contentType(ContentType.JSON)
			.log().ifValidationFails()
		.when()
			.body(std)
			.post()
		.then()
			.statusCode(201);
		
	}
	
	
	//@Test
	public void test006(){
		System.out.println("------------- Printing Response headers ----------------");
		
		given()
		.when()
			.get("/list")
		.then()
			.log().headers();
		
	}
	
	
	//@Test
	public void test007(){
		System.out.println("------------- Printing Response status ----------------");
		given()
		.when()
			.get("/list")
		.then()
			.log().status();
	}
	
	
	//@Test
	public void test008(){
		System.out.println("------------- Printing Response Body ----------------");
		
		given()
		.when()
			.get("/list")
		.then()
			.log().body();
	}
	
	
	//@Test
	public void test009(){
		System.out.println("------------- Printing Response Body incase of an error ----------------");
		
		given()
			.param("programme", "Financial Analysis")
			.param("limit", "-1")
		.when()
			.get("/list")
		.then()
			.log().ifError();
	}
	
	
	
	//@Test
	public static void test010(){
		System.out.println("-------Print first 3 Student ids---------");
		
		ArrayList<Integer> res =    given()
									.when()
										.get("/list")
									.then()
										.extract().path("id");
		
		System.out.println("First student id :"+res.get(0));
		System.out.println("Second student id :"+res.get(1));
		System.out.println("Third student id :"+res.get(2));
	}
	
	
	//@Test
	public static void test011(){
		System.out.println("-------Print first 3 Student courses---------");
		
		ArrayList<Integer> res =    given()
									.when()
										.get("/list")
									.then()
										.extract().path("courses");
		
		System.out.println("First student courses :"+res.get(0));
		System.out.println("Second student courses :"+res.get(1));
		System.out.println("Third student courses :"+res.get(2));
	}
	
	
	//@Test
	public static void test012(){
		System.out.println("-------Print first Student first course name---------");
		
		ArrayList<Integer> res =    given()
									.when()
										.get("/list")
									.then()
										.extract().path("courses.get(0)");
		
		System.out.println("First Course of First student :"+res.get(0));
	}
	
	
	//@Test
	public static void test013(){
		System.out.println("-------Print all courses of all students---------");
		
		ArrayList<Integer> res =    given()
									.when()
										.get("/list")
									.then()
										.extract().path("courses");
		System.out.println(res.size());
		for(int i=0;i<=res.size()-1;i++){
			System.out.println("Student "+i+" courses :"+res.get(i));
		}
		
	}
	
	
	//@Test
	public static void test014(){
		System.out.println("-------Size of the courses---------");
		
		int res =    given()
									.when()
										.get("/list")
									.then()
										.extract().path("courses.size()");
		System.out.println("Size of the courses "+res);
	}
	
	
	
	//@Test
	public static void test015(){
		System.out.println("-------Get all the firstname from the response---------");
		
		ArrayList<Integer> res =    given()
									.when()
										.get("/list")
									.then()
										.extract().path("firstName");
		
		for(int i=0;i<res.size()-1;i++){
			System.out.println("Student "+i+" firstname is :"+res.get(i));
		}
	}
	
	
	
	//@Test
	public static void test016(){
		System.out.println("-------Find all values whose programme stated with 'Computer Science'---------");
		
		ArrayList<Integer> res =    given()
									.when()
										.get("/list")
									.then()
										.extract().path("findAll{it.programme=='Computer Science'}");
		
		for(int i=0;i<=res.size()-1;i++){
			System.out.println("Student "+i+" details :"+res.get(i));
		}
	}
	
	
	//@Test
	public static void test017(){
		System.out.println("-------Get the lastname of all student whose programme stated with 'Computer Science'---------");
		
		ArrayList<Integer> res =    given()
									.when()
										.get("/list")
									.then()
										.extract().path("findAll{it.programme=='Computer Science'}.lastName");
		for(int i=0;i<=res.size()-1;i++){
			System.out.println("Student "+i+" details :"+res.get(i));
		}
		
	}
	
	
	//@Test
	public static void test018(){
		System.out.println("-------Get the lastname of all student whose id is greater than 2---------");
		
		ArrayList<Integer> res =    given()
									.when()
										.get("/list")
									.then()
										.extract().path("findAll{it.id>2}.lastName");
		
		for(int i=0;i<=res.size()-1;i++){
			System.out.println("Student "+i+" details :"+res.get(i));
		}
	}

	
	//@Test
	public static void test020(){
		System.out.println("-------Get all values whose programme starts with 'Computer'---------");
		
		ArrayList<Integer> res =    given()
									.when()
										.get("/list")
									.then()
										.extract().path("findAll{it.programme==~/Computer.*/}");
		
		for(int i=0;i<=res.size()-1;i++){
			System.out.println("Student "+i+" details :"+res.get(i));
		}
	}
	
	
	//@Test
	public static void test021(){
		System.out.println("-------Get all values whose programme ends with 'Computer'---------");
		
		ArrayList<Integer> res =    given()
									.when()
										.get("/list")
									.then().extract().path("findAll{it.programme==~/.*Science/}");
		
		for(int i=0;i<=res.size()-1;i++){
			System.out.println("Student "+i+" details :"+res.get(i));
		}
	}
	
	
	//Assert on count value
	//@Test
	public static void test022(){
		System.out.println("Assert on count value");
		
		given()
		.when()
		.get("/list")
		.then()
			.body("courses.size()", equalTo(100));
	}
	
	
	
	//Assert on Single Name
	//@Test
	public static void test023(){
		System.out.println("Assert on Single Name");
		
		given()
		.when()
		.get("/list")
		.then()
			.body("firstName", hasItem("Vernon"));
	}
	
	
	//Assert on multiple names
	//@Test
	public static void test024(){
		System.out.println("Assert on multiple names");
		
		given()
		.when()
			.get("/list")
		.then()
			.body("firstName", hasItems("Vernon","Murphy"));
	}
	
	
	
	//Assert using logical function
	//@Test
	public static void test025(){
		System.out.println("Assert using logical function");
		
		given()
		.when()
			.get("/list")
		.then()
			.body("courses.size()", greaterThan(5))
			.body("courses.size()", lessThan(500));
	}
	
	
	
	//Adding multiple assertions in single test
	//@Test
	public static void test026(){
		System.out.println("Adding multiple assertions in single test");
		
		given()
		.when()
			.get("/list")
		.then()
			.body("courses.size()", equalTo(100))
			.body("firstName", hasItem("Vernon"))
			.body("firstName", hasItems("Vernon","Murphy"))
			.body("courses.size()", greaterThan(5))
			.body("courses.size()", lessThan(500));
	}
	
	
	
	//Assert using TestNG method
	//@Test
	public static void test027(){
		System.out.println("Assert using TestNG method");
		
		ArrayList<Integer> res =    given()
									.when()
										.get("/list")
									.then()
										.extract().path("courses");
		
		Assert.assertTrue(res.size()==100, "Expected and Actual values are not matching");
	}
	
	
	
	//RootPath example1
	//@Test
	public static void test028(){
		System.out.println("RootPath example1");
		
		
		given()
		.when()
			.get("/list")
		.then()
			.root("courses")
			.body(".size()", equalTo(100))
			.body(".size()", greaterThan(5))
			.body(".size()", lessThan(500))
			
			.root("")
			.body("firstName", hasItem("Vernon"))
			.body("firstName", hasItems("Vernon","Murphy"));
			
	}
	
	
	//RootPath example2
	//@Test
	public static void test029(){
		System.out.println("RootPath example2");
		
		
		given()
		.when()
			.get("/list")
		.then()
			.body(".size()", equalTo(100))
			.body(".size()", greaterThan(5))
			.body(".size()", lessThan(500))
			
			.root("")
			.body("firstName", hasItem("Vernon"))
			.body("firstName", hasItems("Vernon","Murphy"));
			
	}
	
	
	//Request specification
	//@Test
	public static void test030(){
		
		Response res =   given()
							.spec(reqSpec)
						.when()
						.get("/list");
		
		System.out.println(res.prettyPrint());
		
	}
	
	
	
	//Response specification
	@Test
	public static void test031(){

		given()
			.spec(reqSpec)
		.when()
			.get("/list")
		.then()
			.spec(resSpec);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
