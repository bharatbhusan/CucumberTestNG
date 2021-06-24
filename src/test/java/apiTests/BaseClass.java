package apiTests;

import java.lang.reflect.Method;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;


public class BaseClass {
	protected ExtentReports report;
	protected ExtentTest test;
	
	
	@BeforeSuite
	public void setup()
	{
		
	}

	@AfterSuite
	public void destroy()
	{
		
	}
}
