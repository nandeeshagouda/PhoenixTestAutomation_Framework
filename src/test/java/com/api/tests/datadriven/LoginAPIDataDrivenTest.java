package com.api.tests.datadriven;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.api.request.model.UserCredentials;
import com.dataproviders.api.bean.UserBean;

import static com.api.utils.SpecUtil.*;
 
public class LoginAPIDataDrivenTest {
		
	private UserCredentials userCredential;
	
	 

	@Test (description = "Verifying if login api is working for FD user",
			groups= {"api","datadriven","regresion"},
			dataProviderClass = com.dataproviders.DataProviderUtils.class,
			dataProvider = "LoginAPIDataProvider"
			 )
	public void LoginAPITest(UserBean userBean) {
		//Rest Assured code!
		
		given()
			.spec(requestSpec(userBean))
			.when()
			.post("login")
			.then()
			.spec(responseSpec_Ok())
			.body("message", equalTo("Success"))
			.and()
			.body(matchesJsonSchemaInClasspath("response-schema/LoginResponseSchema.json"));
			
			
		
	}
	
	

}
