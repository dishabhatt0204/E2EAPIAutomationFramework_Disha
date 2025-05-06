package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserGetProfileResponse;

import io.restassured.response.Response;

public class GetUserProfileTest {
	
	@Test
	public void getUserProfile()
	{
		LoginRequest loginrequest = new LoginRequest("DishaBhatt", "DishaBhatt");
		AuthService authservice = new AuthService();
		Response response = authservice.login(loginrequest);
		LoginResponse loginresponse = response.as(LoginResponse.class);
		System.out.println(loginresponse.getToken());
		
		UserManagementService userprofile = new UserManagementService();
		response =userprofile.getUserProfile(loginresponse.getToken());
		UserGetProfileResponse getUserProfileResponse = response.as(UserGetProfileResponse.class);
		Assert.assertEquals(getUserProfileResponse.getId(), 912);
		Assert.assertEquals(getUserProfileResponse.getEmail(), "dishabhatt92@gmail.com");
		
		
		
 	}
	

}
