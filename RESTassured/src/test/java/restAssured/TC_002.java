package restAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_002 {

	
	
	@Test
	public void getEmployeeData() {
		
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1/employee";
		
RequestSpecification Httpreques=	RestAssured.given();
		

		
		
	}
}
