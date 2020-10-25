package com.oAuthentication;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.UploadImage.UploadImage;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.builder.ResponseSpecBuilder;
import com.jayway.restassured.config.RestAssuredConfig;
import com.jayway.restassured.config.SSLConfig;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.internal.mapper.ObjectMapperType;
import com.jayway.restassured.response.ValidatableResponse;
import com.jayway.restassured.specification.RequestSpecification;
import com.jayway.restassured.specification.ResponseSpecification;
import com.student.base.TestBase;
import com.sun.jersey.api.client.RequestBuilder;

import static org.hamcrest.Matchers.*;
import static com.jayway.restassured.RestAssured.*;

public class oAuthentication {

	static RequestSpecification reqspec;
	static RequestSpecBuilder reqspecbuilder;
	static ResponseSpecification resspec;
	static ResponseSpecBuilder resspecbuilder;
	static String token;
	
	
	
	@Test(priority=1)
	public static void test001(){
		
		Map reqhdr = new HashMap();		
		reqhdr.put("Content-Type", "application/x-www-form-urlencoded");
		
		//Map bdy = new HashMap();
		reqhdr.put("client_id", "aor-service");
		reqhdr.put("grant_type", "client_credentials");
		reqhdr.put("client_secret", "05242eda-d6b3-4e90-a1f9-08e892a12354");
		
		
		RestAssuredConfig rac = RestAssured.config().sslConfig(new SSLConfig().allowAllHostnames().relaxedHTTPSValidation("TLSv1.2"));
		
		token = given()
			.config(rac)
			//.headers(reqhdr)
		.when()
			.formParams(reqhdr)
			//.body(bdy)
			.post("https://135.250.138.235:8666/auth/realms/AOR/protocol/openid-connect/token")
		.then()
			.extract().path("access_token");
		
		System.out.println("Token :"+token);

	}
	
	
	@Test(priority=2)
	public static void Test002(){
		
		UploadImage UpImg = new UploadImage();
		UpImg.setIconName("MickyMouse.png");
		UpImg.setCategory("Branding");
		UpImg.setIconBase64Image("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");
		
		String newtoken = "Bearer "+token;
		System.out.println("New Token :"+newtoken);
		Map Updparams = new HashMap();
		Updparams.put("Accept", "application/json");
		Updparams.put("authorization", newtoken);
		Updparams.put("Content-Type", "application/json");
		
		
		RestAssuredConfig rac = RestAssured.config().sslConfig(new SSLConfig().allowAllHostnames().relaxedHTTPSValidation("TLSv1.2"));
		
		int iconId = given()
			.config(rac)
			.headers(Updparams)
		.when()
			.body(UpImg)
			.post("https://135.250.138.235:9443/aor-service/iconlibrary/add")
		.then()
			.log().body()
			.extract().path("iconId");
		
		System.out.println("iconId :"+iconId);		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
