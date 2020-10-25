package com.filedownloads.example;

import java.io.File;

import org.testng.annotations.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.builder.ResponseSpecBuilder;
import com.jayway.restassured.config.RestAssuredConfig;
import com.jayway.restassured.config.SSLConfig;
import com.jayway.restassured.response.ValidatableResponse;
import com.jayway.restassured.specification.RequestSpecification;
import com.jayway.restassured.specification.ResponseSpecification;
import com.student.base.TestBase;
import com.sun.jersey.api.client.RequestBuilder;

import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertTrue;
import static com.jayway.restassured.RestAssured.*;

public class fileDownLoadExample {

	@Test
	public void test001(){
		File file = new File(System.getProperty("user.dir")+File.separator+"geckodriver-v0.24.0-win64.zip");
		
		int expectedsize = (int)file.length();
		System.out.println("Expected file size :"+expectedsize);
		
		RestAssuredConfig rac = RestAssured.config().sslConfig(new SSLConfig().allowAllHostnames().relaxedHTTPSValidation("TLSv1.2"));
		
		byte[] actualsize =   given()
						.when()
							.config(rac)
							.get("https://github.com/mozilla/geckodriver/releases/download/v0.24.0/geckodriver-v0.24.0-win64.zip")
						.then()
							.extract()
							.asByteArray();
		System.out.println("Actual file size :"+actualsize.length);
		
		assertTrue(expectedsize==actualsize.length, "Actual and Expected file size are not same");
	}

}
