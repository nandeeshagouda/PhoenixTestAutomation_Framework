package com.api.test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.lessThan;

import java.io.IOException;

import org.testng.annotations.Test;

import com.api.utils.SpecUtil;

import static com.api.constant.Role.*;

import static com.api.utils.AuthTokenPravider.*;

import static com.api.utils.ConfigManager.*;

import io.restassured.http.ContentType;
import io.restassured.http.Header;

public class UserDetailsAPITest {
	
	@Test
	public void userDetailsAPITest() throws IOException {
		
		
		given()
		.spec(SpecUtil.RequestSpecWithAuth(FD))
		.when()
		.get("userdetails")
		.then()
		.spec(SpecUtil.responseSpec_Ok())
		.and()
		.body(matchesJsonSchemaInClasspath("response-schema/UserDetailsResponseSchema.json"));
		
	}
	

}
