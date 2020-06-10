package Demo_TestNG.Demo_TestNg;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;

public class propertiesLoader {

	
	static void loadLog4jPropertyFile(String sPathLog4jPropertyFile) throws Exception{
	FileInputStream fi = new FileInputStream(sPathLog4jPropertyFile);
	Properties props = new Properties();
	props.load(fi);
	PropertyConfigurator.configure(props);
	}
	/*
	 * -- debug, info, error
	 debug --> more log
	 info  --> 
	 error
	 
	 
	 
#6 suits : 4-5hours
#2 - 2:30
#35 -40 minutes --> parallel : class -- parallel test data


class 1 -- 2 -- 3 testdata --> multiple users - 20(parallel test cases) - 21 -->
class 2 -- 20
class 3 -- 15
class 4
class 10


	 * 
	 * */
}
