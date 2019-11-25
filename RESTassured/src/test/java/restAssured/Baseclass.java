package restAssured;

import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

public class Baseclass {

	
	
	public Logger logger;
	
	
	@BeforeClass
	public void Setup() {
		
		 logger = logger.getLogger("restAssured");
		PropertyConfigurator.configure("Log4j.properties")	;	
		
	}
	
	
	
	
	
	
}
