package com.api.base;

import com.api.models.request.EditProfileRequest;

import io.restassured.response.Response;

public class UserManagementService extends BaseService{

	private static final String BASE_PATH="/api/users/";
	
	
	public Response getUserProfile(String token)
	{
		setAuthToken(token);
		return getRequest(BASE_PATH + "profile");
	}
	
	public Response updateUserProfile(String token, EditProfileRequest payload)
	{
		setAuthToken(token);
		return putRequest(payload, BASE_PATH + "profile");
	}
	
}
