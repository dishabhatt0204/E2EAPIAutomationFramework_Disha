package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserManagementService;
import com.api.models.request.EditProfileRequest;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserGetProfileResponse;

import io.restassured.response.Response;

public class UpdateProfileTest {

	
	@Test
	public void UpdateUserProfileTest()
	{
		LoginRequest loginrequest = new LoginRequest("DishaBhatt", "DishaBhatt");
		AuthService authService = new AuthService();
		Response response = authService.login(loginrequest);
		LoginResponse loginresponse = response.as(LoginResponse.class);
		System.out.println("Auth Token : "+ loginresponse.getToken());
		
		//Use Get API request First
		UserManagementService userprofile = new UserManagementService();
		response = userprofile.getUserProfile(loginresponse.getToken());
		System.out.println("Response from Get User Profile");
		UserGetProfileResponse getProfileResponse=response.as(UserGetProfileResponse.class);
		Assert.assertEquals(getProfileResponse.getUsername(), "DishaBhatt");
		
		
		//Calling Update Profile
		EditProfileRequest editProfile = new EditProfileRequest.Builder()
												.firstName("Disha")
												.lastName("Vyas")
												.email("bhattdisha92@gmail.com")
												.mobileNumber("9886753521")
												.build();
				
		response = userprofile.updateUserProfile(loginresponse.getToken(), editProfile);
		System.out.println("Response from Edit User Profile");
		System.out.println(response.asPrettyString());
		
		
	}
}


