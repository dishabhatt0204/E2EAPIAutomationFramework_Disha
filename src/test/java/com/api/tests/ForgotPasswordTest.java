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

public class ForgotPasswordTest {

	@Test(description="Verify if UserSignup is successful")
	public void ForgotPassword()
	{
			AuthService authservice = new AuthService();
			Response response = authservice.forgotPassword("disha12345@gmail.com");
			System.out.println(response.asPrettyString());
			//Assert.assertEquals(response.asPrettyString(),"If your email exists in our system, you will receive reset instructions.");
		
	}
}
