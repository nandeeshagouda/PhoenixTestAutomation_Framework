package com.api.test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.api.request.model.UserCredentials;
import static com.api.utils.SpecUtil.*;
 
public class LoginAPITest {
		
	private UserCredentials userCredential;
	
	@BeforeMethod(description ="Create the payload for the login API")
	public void setUp() {
		userCredential=new UserCredentials("iamfd", "password");
	}

	@Test (description = "Verifying if login api is working for FD user",groups= {"api","smoke","regresion"})
	public void LoginAPITest() {
		//Rest Assured code!
		
		given()
			.spec(requestSpec(userCredential))
			.when()
			.post("login")
			.then()
			.spec(responseSpec_Ok())
			.body("message", equalTo("Success"))
			.and()
			.body(matchesJsonSchemaInClasspath("response-schema/LoginResponseSchema.json"));
			
			
		
	}
	
	

}
