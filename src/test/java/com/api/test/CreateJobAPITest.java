package com.api.test;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.api.constant.Role;
import com.api.pojo.CreateJobPayload;
import com.api.pojo.Customer;
import com.api.pojo.CustomerAddress;
import com.api.pojo.CustomerProduct;
import com.api.pojo.Problems;
import com.api.utils.AuthTokenPravider;
import com.api.utils.ConfigManager;
import com.api.utils.SpecUtil;

import io.restassured.http.ContentType;



public class CreateJobAPITest {
	
	
	@Test
	public void createJobAPITest() {
		
		//Creating the CreatePayload object 
		
		Customer customer=new Customer("nandish", "lk", "8217406456", "", "nandishlk@gmail.com", "");
		CustomerAddress customerAddress=new CustomerAddress("D 404", "Maruti nilaya", "Btm alayout", "near bus stop", "bangalore", "560076", "India", "Karnataka");
		CustomerProduct customerProduct=new CustomerProduct("2026-03-01T18:30:00.000", "19074140583775", "19074140583775", "19074140583775", "2026-03-01T18:30:00.000", 1, 1);
		Problems problems=new Problems(1, "Battary issue");
		Problems[] problemsArray=new Problems[1];
		problemsArray[0]=problems;
		CreateJobPayload createJobPayload=new CreateJobPayload(0, 2, 1, 1, customer, customerAddress, customerProduct, problemsArray);
		
		
		
		given()
		.spec(SpecUtil.RequestSpecWithAuth(Role.FD, createJobPayload))
				.when()
				.post("/job/create")
				.then()
				.spec(SpecUtil.responseSpec_Ok());
		
	}

}
