package com.students.tests;

import java.util.ArrayList;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import static org.hamcrest.Matchers.*;
import static com.jayway.restassured.RestAssured.*;

import com.student.base.TestBase;
import com.student.model.Student;

public class StudentPostTest extends TestBase{

	@Test
	public void createNewStudent(){
		
		ArrayList<String> courses = new ArrayList();
		courses.add("java");
		courses.add("python");
		
		Student std = new Student();
		std.setFirstName("Kiran");
		std.setLastName("Kumar");
		std.setEmail("kiran@gmail.com");
		std.setProgramme("Computer Science");
		std.setCourses(courses);
		
		given()
			.contentType(ContentType.JSON)
		.when()
			.body(std)
			.post()
		.then()
			.statusCode(201);
		
	}
}
