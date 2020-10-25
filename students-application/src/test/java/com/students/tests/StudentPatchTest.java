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

public class StudentPatchTest extends TestBase{

	@Test
	public void updateStudentInfo(){
		
		ArrayList<String> courses = new ArrayList<String>();
		courses.add("C#");
		courses.add("C++");
		
		Student std = new Student();
		std.setFirstName("Kiran Kumar");
		std.setLastName("SY");
		std.setEmail("kiran015@gmail.com");
		std.setProgramme("Computer Science");
		std.setCourses(courses);
		
		given()
			.contentType(ContentType.JSON)
		.when()
			.body(std)
			.patch("/101")
		.then()
			.statusCode(200);
		
	}
}
