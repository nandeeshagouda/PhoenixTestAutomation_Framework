package com.api.test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

import org.testng.annotations.Test;

import com.api.request.model.UserCredentials;
import com.api.utils.SpecUtil;
 
public class LoginAPITest {
		
	@Test 
	public void LoginAPITest() {
		//Rest Assured code!
		
		
		UserCredentials userCredential=new UserCredentials("iamfd", "password");
		
		 
		
		given()
			.spec(SpecUtil.requestSpec(userCredential))
			.when()
			.post("login")
			.then()
			.spec(SpecUtil.responseSpec_Ok())
			.body("message", equalTo("Success"))
			.and()
			.body(matchesJsonSchemaInClasspath("response-schema/LoginResponseSchema.json"));
			
			
		
	}
	
	

}
