package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginAPITest1 {

	@Test(description="Verify if Login is successful")
	public void loginTest1()
	{
		

		//chaining of Methods
		Response response=given()
							.baseUri("http://64.227.160.186:8080")
							.header("Content-Type","application/json")
							.body("{\r\n"
										+ "  \"username\": \"DishaBhatt\",\r\n"
										+ "  \"password\": \"DishaBhatt\"\r\n"
										+ "}")
							.post("/api/auth/login");
		
		
		System.out.println(response.asPrettyString());
		Assert.assertEquals(response.getStatusCode(), 200);
	}
}
