package com.api.test;

import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.*;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.api.constant.Model;
import com.api.constant.OEM;
import com.api.constant.Platform;
import com.api.constant.Problem;
import com.api.constant.Product;
import com.api.constant.Role;
import com.api.constant.ServiceLocation;
import com.api.constant.Warranty_Status;
import com.api.request.model.CreateJobPayload;
import com.api.request.model.Customer;
import com.api.request.model.CustomerAddress;
import com.api.request.model.CustomerProduct;
import com.api.request.model.Problems;
import static com.api.utils.DateTimeUtils.*;
import static com.api.utils.SpecUtil.*;

import static io.restassured.module.jsv.JsonSchemaValidator.*;



public class CreateJobAPITest {
	
	private CreateJobPayload createJobPayload;
	
	@BeforeMethod(description = "Creating createjob api request payload")
	public void setUp() {
		// Creating the CreatePayload object

		System.out.println(Instant.now().minus(10, ChronoUnit.DAYS));

		Customer customer = new Customer("nandish", "lk", "8217406456", "", "nandishlk@gmail.com", "");
		CustomerAddress customerAddress = new CustomerAddress("D 404", "Maruti nilaya", "Btm alayout", "near bus stop",
				"bangalore", "560076", "India", "Karnataka");
		CustomerProduct customerProduct = new CustomerProduct(getTimeWithDaysAgo(10), "19173231583716",
				"19173231583716", "19173231583716", getTimeWithDaysAgo(10), Product.NEXS_2.getCode(),
				Model.NEXUS_2_BLUE.getCode());
		Problems problems = new Problems(Problem.SMARTPHONE_IS_RUNING_SLOW.getCode(), "Battary issue");
		List<Problems> problemsList = new ArrayList<Problems>();
		problemsList.add(problems);
		createJobPayload = new CreateJobPayload(ServiceLocation.SERVICE_LOCATION_A.getCode(),
				Platform.FRENT_DESK.getCode(), Warranty_Status.IN_WARRANTY.getCode(), OEM.GOOGLE.getCode(), customer,
				customerAddress, customerProduct, problemsList);

	}
	
	@Test(description = "Verify if the create job api is able to create Inwarranty jobs",groups = {"api","smoke","regresion"})
	public void createJobAPITest() {
		
		given()
		.spec(RequestSpecWithAuth(Role.FD, createJobPayload))
				.when()
				.post("/job/create")
				.then()
				.spec(responseSpec_Ok())
				.body(matchesJsonSchemaInClasspath("response-schema/CreateJobAPIResponseSchema.json"))
				.body("message",equalTo("Job created successfully. "))
				.body("data.mst_service_location_id", equalTo(1))
				.body("data.job_number", startsWith("JOB_"));
		
	}

}
