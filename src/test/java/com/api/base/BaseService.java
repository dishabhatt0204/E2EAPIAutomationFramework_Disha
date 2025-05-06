package com.api.base;

import static io.restassured.RestAssured.*;

import com.api.filters.LoggingFilters;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {
	//BaseService acts like a wrapper for RestAssured
	//Creates BaseURI
	//Creating Request
	//Handling Response
	
	private static final String BASE_URL="http://64.227.160.186:8080/";
	RequestSpecification requestSpecification;
	
	static
	{
		RestAssured.filters(new LoggingFilters());
	}
	
	
	public BaseService()
	{
		requestSpecification=given().baseUri(BASE_URL);
	}
	
	protected void setAuthToken(String token)
	{
		requestSpecification.header("Authorization", "Bearer " + token);
	}
	
	
	protected Response postRequest(Object payload, String endpoints)
	{
		return requestSpecification.contentType(ContentType.JSON).body(payload).post(endpoints);
	}
	

	protected Response getRequest(String endpoints)
	{
		return requestSpecification.get(endpoints);
	}
	
	protected Response putRequest(Object payload,String endpoints)
	{
		return requestSpecification.contentType(ContentType.JSON).body(payload).put(endpoints);
	}
	
}
