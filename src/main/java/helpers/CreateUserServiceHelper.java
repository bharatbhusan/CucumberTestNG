package helpers;

import constants.EndPoints;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.UserRequest;
import model.UserResponse;
import utils.ConfigManager;

public class CreateUserServiceHelper
{
	private static final String baseURL = ConfigManager.getInstance().getString("BASE_URL");
	private RequestSpecification request;
	public CreateUserServiceHelper()
	{
		RestAssured.baseURI=baseURL;
		request= RestAssured.given();
		request.contentType("application/json");
		
	}
	
	public UserResponse createUser(String name,String job)
	{
		UserRequest cuReq = new UserRequest();
		cuReq.setName(name);
		cuReq.setJob(job);
		
		Response response = request.
							body(cuReq).
							post(EndPoints.CREATE_USER);
		
		return response.getBody().as(UserResponse.class);
							
	}
}
