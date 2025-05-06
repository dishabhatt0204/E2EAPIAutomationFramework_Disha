package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.request.SignupRequest;
import com.api.models.response.LoginResponse;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UserCreationTest {

	@Test(description="Verify if UserSignup is successful")
	public void SignupTest()
	{
		
		SignupRequest signuprequest = new SignupRequest.Builder()
											.setUserName("DishaBha")
											.setPassword("DishaBha")
											.setFirstName("Disha")
											.setLastName("Disha")
											.setEmail("disha12345@gmail.com")
											.setmobileNumber("9897008162")
											.build();
				
		AuthService authservice=new AuthService();
		
		Response response = authservice.signup(signuprequest);
		System.out.println(response.asPrettyString());
		
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.asPrettyString(), "User registered successfully!");
	}
}
