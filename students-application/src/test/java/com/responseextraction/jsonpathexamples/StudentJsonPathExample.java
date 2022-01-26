package com.responseextraction.jsonpathexamples;

import java.util.ArrayList;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.ValidatableResponse;
import com.student.base.TestBase;

import static org.hamcrest.Matchers.*;
import static com.jayway.restassured.RestAssured.*;

public class StudentJsonPathExample {

	@BeforeClass
	public static void init(){
		RestAssured.baseURI="http://localhost";		
		RestAssured.port=8085;
		RestAssured.basePath="/student";
	}
	
	
	//@Test
	public void test001(){
		
		System.out.println("-------Print first 3 Student ids---------");
		
		ArrayList<Integer> Studentids = 	given()
											//.param("programme", "Computer Science")
											.param("limit", 3)
									.when()
										.get("/list")
									.then()
										.extract().path("id");
		System.out.println("List of student ids :"+Studentids);
	    System.out.println("The id of first student :"+Studentids.get(0));
	    System.out.println("The id of second student :"+Studentids.get(1));
	    System.out.println("The id of third student :"+Studentids.get(2));
	}
	
	//@Test
	public void test002(){
		
		System.out.println("-------Print first 3 Student courses---------");
		ArrayList<Integer> courses = 	given()
											.param("programme", "Computer Science")
											.param("limit", 3)
										.when()
											.get("/list")
										.then().extract().path("courses");
		
		System.out.println("List of Courses :"+courses);
		System.out.println("Courses of First student :"+courses.get(0));
		System.out.println("Courses of Second student :"+courses.get(1));
		System.out.println("Courses of Third student :"+courses.get(2));
		
	}
	
	
	//@Test
	public void test003(){
		System.out.println("-------Print first Student first course name---------");
		
		ArrayList<Integer> res =    given()
									.when()
										.get("/list")
									.then()
										.extract().path("courses.get(0)");
		
		System.out.println("First Student courses  :"+res);
		System.out.println("First Course of First student :"+res.get(0));
	}
	
	
	//@Test
	public void test004(){
		System.out.println("-------Print all courses of all students---------");
		
		ArrayList<Integer> courses = given()
										//.param("programme", "Computer Science")
										//.param("limit", 3)
									.when()
										.get("/list")
									.then()
										.extract()
										.path("courses");
		
		System.out.println("Course of all students :"+courses);
		
	}
	
	
	//@Test
	public void test005(){
		System.out.println("-------Size of the courses---------");
		
		int sizeOfCourses = given()
								.param("programme", "Computer Science")
								.param("limit", 3)
							.when()
								.get("/list")
							.then()
								.extract()
								.path("courses.size()");
		System.out.println("Size of the courses :"+sizeOfCourses);
		
	}
	
	
	//@Test
	public void test006(){
		System.out.println("-------Get all the firstname from the response---------");
		
		ArrayList<String> firstnames = given()
											//.param("programme", "Computer Science")
											//.param("limit", 3)
										.when()
											.get("/list")
										.then()
											.extract()
											.path("firstName");
		
		System.out.println("All the firstnames from response :"+firstnames);
								
	}
	
	
	//@Test
	public void test007(){
		System.out.println("-------Find all values whose programme stated with 'Computer Science'---------");
		ArrayList<String> allvalues = 	given()
										//.param("programme", "Computer Science")
										.param("limit", 3)
									.when()
										.get("/list")
									.then()
										.extract()
										.path("findAll{it.programme=='Computer Science'}");
		
		System.out.println("All the values whose programme stated with 'Computer Science' :"+allvalues);
		
	}
	
	
	//@Test
	public void test008(){
		System.out.println("-------Get the lastname of all student whose programme stated with 'Computer Science'---------");
		
		ArrayList<String> allvalues = 	given()
											//.param("programme", "Computer Science")
											.param("limit", 3)
										.when()
											.get("/list")
										.then()
											.extract()
											.path("findAll{it.programme=='Computer Science'}.lastName");
		
		System.out.println("Lastname of all students whose programme stated with 'Computer Science' :"+allvalues);
										
	}
	
	
	//@Test
	public void test009(){
		System.out.println("-------Get the lastname of all student whose id is greater than 2---------");
		
		ArrayList<String> alllastnames = given()
											//.param("programme", "Computer Science")
											.param("limit", 3)
										.when()
											.get("/list")
										.then()
											.extract()
											.path("findAll{it.id>2}.lastName");
		
		System.out.println("Lastname of all students whose id is greater than 2 :"+alllastnames);		
	}
	
	
	
	//@Test
	public void test010(){
		System.out.println("-------Get all values whose programme starts with 'Computer'---------");
		
		ArrayList<String> allvalues = 	given()
											//.param("programme", "Computer Science")
											.param("limit", 3)
										.when()
											.get("/list")
										.then()
											.extract()
											.path("findAll{it.programme==~/Computer.*/}");
		System.out.println("All values whose programme starts with 'Computer' :"+allvalues);	
		
	}
	
	
	
	//@Test
	public void test011(){
		System.out.println("-------Get all values whose programme ends with 'Computer'---------");
		
		ArrayList<String> allvalues = 	given()
											//.param("programme", "Computer Science")
											.param("limit", 3)
										.when()
											.get("/list")
										.then()
											.extract()
											.path("findAll{it.programme==~/.*Science/}");
		
		System.out.println("All values whose programme ends with 'Science' :"+allvalues);
	}
	
	
	
	
	
	
	
	
}
