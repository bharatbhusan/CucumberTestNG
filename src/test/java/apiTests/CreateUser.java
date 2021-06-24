package apiTests;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import helpers.CreateUserServiceHelper;
import model.UserResponse;
import utils.TestDataLoader;
public class CreateUser extends BaseClass
{
	private CreateUserServiceHelper userReq;
	private UserResponse userRes;
	
	@BeforeSuite
	public void beforeSuite(ITestContext result)
	{
		report = new ExtentReports(result.getName()+"_ExtentReportResults.html");

	}
	@BeforeMethod
	public void setup(ITestContext result)
	{
		userReq = new CreateUserServiceHelper();
		test = report.startTest(result.getName()); 
	}
	
	@Test(dataProvider="readJSONData",dataProviderClass = TestDataLoader.class)
	public void createUser(String username,String job)
	{
		test.log(LogStatus.INFO,username+" passed successfully");
		test.log(LogStatus.INFO,job+" passed successfully");

		userRes = userReq.createUser(username, job);
		Assert.assertEquals(userRes.getName(),username);
		Assert.assertEquals(userRes.getJob(),job);	
		test.log(LogStatus.PASS,userRes.getId()+" generated successfully");
		test.log(LogStatus.PASS,"User Created Successfully");

	}
	
	@AfterMethod
	public void destory()
	{
		report.endTest(test); 
	}
	@AfterSuite
	public void afterSuite()
	{
		report.flush();

	}
	
}
