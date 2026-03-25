package com.api.test;

import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.api.constant.Role;
import com.api.request.model.CreateJobPayload;
import com.api.request.model.Customer;
import com.api.request.model.CustomerAddress;
import com.api.request.model.CustomerProduct;
import com.api.request.model.Problems;
import com.api.utils.SpecUtil;

import static io.restassured.module.jsv.JsonSchemaValidator.*;



public class CreateJobAPITest {
	
	
	@Test
	public void createJobAPITest() {
		
		//Creating the CreatePayload object 
		
		Customer customer=new Customer("nandish", "lk", "8217406456", "", "nandishlk@gmail.com", "");
		CustomerAddress customerAddress=new CustomerAddress("D 404", "Maruti nilaya", "Btm alayout", "near bus stop", "bangalore", "560076", "India", "Karnataka");
		CustomerProduct customerProduct=new CustomerProduct("2026-03-01T18:30:00.000", "19174230583716", "19174230583716", "19174230583716", "2026-03-01T18:30:00.000", 1, 1);
		Problems problems=new Problems(1, "Battary issue");
		List<Problems> problemsList=new ArrayList<Problems>();
		problemsList.add(problems);
		CreateJobPayload createJobPayload=new CreateJobPayload(0, 2, 1, 1, customer, customerAddress, customerProduct, problemsList);
		
		
		
		given()
		.spec(SpecUtil.RequestSpecWithAuth(Role.FD, createJobPayload))
				.when()
				.post("/job/create")
				.then()
				.spec(SpecUtil.responseSpec_Ok())
				.body(matchesJsonSchemaInClasspath("response-schema/CreateJobAPIResponseSchema.json"))
				.body("message",equalTo("Job created successfully. "))
				.body("data.mst_service_location_id", equalTo(1))
				.body("data.job_number", startsWith("JOB_"));
		
	}

}
