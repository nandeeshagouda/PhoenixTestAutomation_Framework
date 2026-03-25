package com.api.test;

import static com.api.constant.Role.FD;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import java.io.IOException;

import org.testng.annotations.Test;

import static com.api.utils.SpecUtil.*;

public class UserDetailsAPITest {
	
	@Test(description = "Verify if the userdetails API response is shown correctly",groups = {"api","smoke","regresion"})
	public void userDetailsAPITest() throws IOException {
		
		given()
		.spec(RequestSpecWithAuth(FD))
		.when()
		.get("userdetails")
		.then()
		.spec(responseSpec_Ok())
		.and()
		.body(matchesJsonSchemaInClasspath("response-schema/UserDetailsResponseSchema.json"));
		
	}
	

}
