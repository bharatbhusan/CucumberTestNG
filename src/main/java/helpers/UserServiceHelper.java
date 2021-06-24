package helpers;



import constants.EndPoints;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.IRestResponse;
import model.RestResponse;
import model.User;
import utils.ConfigManager;

public class UserServiceHelper 
{
	private static final String BASE_URL = ConfigManager.getInstance().getString("BASE_URL");
	private RequestSpecification request;
	public  UserServiceHelper()
	{
		RestAssured.baseURI = BASE_URL;
		request= RestAssured.given();
		request.contentType("application/json");
	}
	
	public IRestResponse<User> getListOfUsers(String user_id)
	{
		Response response = request.
				queryParam("page", user_id).
				get(EndPoints.LIST_OF_USERS);
		
//		final ObjectMapper objectMapper = new ObjectMapper();
		
//		List<User> userList=new ArrayList<User>();
//		try {
//			userList = objectMapper.readValue(response.getBody().asString().toString(), new TypeReference<List<User>>(){});
//		} catch (JsonMappingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (JsonProcessingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return new RestResponse<User>(User.class,response);
	}
}
