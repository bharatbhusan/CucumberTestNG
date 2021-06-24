package apiTests;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;

import java.util.List;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;

import helpers.UserServiceHelper;
import model.Data;
import model.IRestResponse;
import model.User;
import utils.ConfigManager;

public class GetAllUsers extends BaseClass
{
	private UserServiceHelper userServiceHelper;

	@BeforeSuite
	public void beforeSuite(ITestContext result)
	{
		report = new ExtentReports(result.getName()+"_ExtentReportResults.html");

	}
	@BeforeMethod
	public void setup(ITestContext result)
	{
		userServiceHelper = new UserServiceHelper();
		test = report.startTest(result.getName()); 

	}

	@Test
	public void getListOfUsers()
	{
		IRestResponse<User> user = userServiceHelper.getListOfUsers(ConfigManager.getInstance().getString("USER_ID"));
		List<Data> userList= user.getBody().getData();
		userList.forEach(s->System.out.println(s.toString()));
		assertNotNull(user.getBody().getData(), "User List is not null");
		assertFalse(user.getBody().getData().isEmpty(), "User list is empty");
	}

	@Test
	public void verifyNoOfUsers()
	{
		IRestResponse<User> user = userServiceHelper.getListOfUsers(ConfigManager.getInstance().getString("USER_ID"));
		List<Data> userList= user.getBody().getData();
		//Verify page no should be displayed correctly
		Assert.assertEquals(Integer.parseInt(ConfigManager.getInstance().getString("USER_ID")), user.getBody().getPage().intValue());
		//Verify user size and per_page user should page
		int countOfUsers=userList.size();
		Assert.assertEquals(countOfUsers, (int)user.getBody().getPer_page());
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
