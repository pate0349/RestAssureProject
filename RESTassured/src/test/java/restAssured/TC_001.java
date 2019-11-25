package restAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_001 {

	
	
	@Test
	public void getEmployeeData() {
		
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1/employee";
		
RequestSpecification Httpreques=	RestAssured.given();
		
		
 Response respo=Httpreques.request(Method.GET, "/1");
 System.out.println(respo);
 String requestbody=respo.body().asString();
		
		System.out.println(requestbody);
		int c=respo.getStatusCode();
		System.out.println(c);
		System.out.println(respo.jsonPath().get("employee_name"));
		Headers allheader=respo.getHeaders();
		for(Header header:allheader) {
			System.out.println(header.getName()+ "  "+ header.getValue());
		}
	}
}
