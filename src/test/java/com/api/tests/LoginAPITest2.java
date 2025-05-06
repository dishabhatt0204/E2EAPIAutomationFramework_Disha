package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@Listeners(com.api.listeners.TestListeners.class)

public class LoginAPITest2 {

	@Test(description="Verify if Login is successful")
	public void loginTest()
	{
		LoginRequest loginrequest = new LoginRequest("DishaBhatt", "DishaBhatt");
		AuthService authService = new AuthService();
		Response response = authService.login(loginrequest);
		//System.out.println(response.asPrettyString());
		
		LoginResponse loginResponse = response.as(LoginResponse.class);
		System.out.println(loginResponse.getToken());
		System.out.println(loginResponse.getEmail());
		
		Assert.assertTrue(loginResponse.getToken() != null);
		//Assert.assertEquals(loginResponse.getEmail(), "dishabhatt92@gmail.com");
	}
}
