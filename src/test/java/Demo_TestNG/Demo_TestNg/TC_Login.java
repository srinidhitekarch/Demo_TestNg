package Demo_TestNG.Demo_TestNg;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TC_Login {

	Logger log = Logger.getLogger(getClass().getSimpleName());
	
	@BeforeSuite
	public void settingLog4J() throws Exception {
		propertiesLoader.loadLog4jPropertyFile(System.getProperty("user.dir")+"\\src\\test\\java\\properties\\log4j.properties");
	}
	@Test
	public void TC_Login_01() {
		log.debug("");
		System.out.println("TC_Login_01 Executed");
		log.info("TC_Login_01 Executed");
	}
	
	@Test
	public void TC_Login_02() {
		System.out.println("TC_Login_02 Executed");
		log.info("TC_Login_02 Executed");
		log.warn("");
		
	}
	@Test
	public void TC_Login_03() {
		System.out.println("TC_Login_03 Executed");
		log.error("TC_Login_03 Executed");
	}
	@Test
	public void TC_Login_04() {
		System.out.println("TC_Login_04 Executed");
		log.debug("TC_Login_04 Executed");
	}
}

//include and exclude method
// when you not given any include or exclude? 4
// when you include TC_Login_04? 1(TC_Login_04 will run)
// when you exclude TC_Login_04? 3(TC_Login_04 will be excluded and rest all will run)


