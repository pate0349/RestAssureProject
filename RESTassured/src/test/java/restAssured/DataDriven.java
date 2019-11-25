package restAssured;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilitis.xlutils;

public class DataDriven {

	@Test(dataProvider="impo")
	
	public void addCustomer(String uname, String salr, String age) {
		
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		
	RequestSpecification httprequest=	RestAssured.given();
	
	JSONObject requestpara = new JSONObject();
	
	requestpara.put("name", uname);
	requestpara.put("salry", salr);
	requestpara.put("age", age);
	httprequest.header("content-type", "Application/json");
	httprequest.body(requestpara.toJSONString());
	     Response response =httprequest.request(Method.POST,"/create");
	     
	   String body=  response.getBody().asString();
	   
	   System.out.println("resonse body"  +body );
	   
	Assert.assertEquals(body.contains(uname), true);
	Assert.assertEquals(body.contains(salr), true);
	Assert.assertEquals(body.contains(age), true);
	}
	
	@DataProvider(name="impo")
String[][]	getdata() throws IOException{
		
		
		
	//String	data[][]= { {"guii","7000","41"} ,{"hgrdee","45000","20"}  ,{"fdfd","254000","23"}  };                                          
		String path=System.getProperty("user.dir") +"/Book1.xlsx";
	int rowcount=	xlutils.getRowCount(path, "Sheet1");
int colunum=		xlutils.getCellCount(path, "Sheet1", 1);

String data[][]=new String[rowcount][colunum];
		for(int i=1;i<=rowcount;i++) {
			
			for(int j=0;j<colunum;j++) {
	data[i-1][j]	=		xlutils.getCellData(path, "Sheet1", i, j);
				
				
			}
			
			
	}
		
		return data;
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	
	
}
