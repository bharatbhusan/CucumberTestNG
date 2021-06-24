package utils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.TestData;
import model.TestDatum;

public class TestDataLoader 
{
	private static TestData testData;
	
	public static TestData getTestCaseData() throws JsonParseException, JsonMappingException, IOException
	{
		ObjectMapper mapper = new ObjectMapper();
		File file = new File(".//config/TestData.json");
		testData = mapper.readValue(file,TestData.class);
		return testData;
	}
	
	@DataProvider
	public Object[][] readJSONData()
	{
		TestData data= new TestData();
		List<TestDatum> dataList;
		Object arr[][]=null;
		try {
			data = getTestCaseData();
			dataList = data.getTcData();
			arr = new Object[dataList.size()][2];
			for(int i=0;i<arr.length;i++)
			{
				arr[i][0]=dataList.get(i).getUserName();
				arr[i][1]=dataList.get(i).getJob();
			}
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arr;
	}
}
