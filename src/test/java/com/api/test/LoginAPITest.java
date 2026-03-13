package com.api.test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

import java.io.IOException;

import org.testng.annotations.Test;

import com.api.pojo.UserCredentials;
import static com.api.utils.ConfigManager.*;

import io.restassured.http.ContentType;
 
public class LoginAPITest {
		
	@Test 
	public void LoginAPITest() {
		//Rest Assured code!
		
		
		UserCredentials userCredential=new UserCredentials("iamfd", "password");
		
		 
		
		given()
			.baseUri(getProperty("BASE_URI"))
		.and()
			.contentType(ContentType.JSON)
		.and()
			.accept(ContentType.JSON)
		.and()
			.body(userCredential)
			.log().uri()
			.log().method()
			.log().headers()
			.log().body()
			.when()
			.post("login")
			.then()
			.log().all()
			.statusCode(200)
			.time(lessThan(1500L))
			.and()
			.body("message", equalTo("Success"))
			.and()
			.body(matchesJsonSchemaInClasspath("response-schema/LoginResponseSchema.json"));
			
			
		
	}
	
	

}
