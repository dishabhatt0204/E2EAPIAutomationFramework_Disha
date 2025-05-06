package com.api.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListeners implements ITestListener{
	
	public static final Logger logger = LogManager.getLogger(TestListeners.class);


	  
	  public void onStart(ITestContext context) {
		  	logger.info("TEST SUITE STARTED !!!!!");
	  }

	  
	  public void onFinish(ITestContext context) {
		  logger.info("TEST SUITE FINISHED !!!!!");
	  }
	
	public void onTestStart(ITestResult result) {
		 logger.info("TEST STARTED !!!" + result.getMethod().getMethodName());
		logger.info("DESCRIPTION !!!" + result.getMethod().getDescription());

	  }

	 public void onTestSuccess(ITestResult result) {
		 logger.info("TEST SUCCEED !!!" + result.getMethod().getMethodName());
		 
	  }

	 public void onTestFailure(ITestResult result) {
	 		 logger.error("TEST FAILED !!!" + result.getMethod().getMethodName());
	  }

	 public void onTestSkipped(ITestResult result) {
		 logger.info("TEST SKIPPED !!!" + result.getMethod().getMethodName());
		 
	  }


}
