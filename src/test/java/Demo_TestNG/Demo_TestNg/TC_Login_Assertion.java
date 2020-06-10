package Demo_TestNG.Demo_TestNg;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotSame;
import static org.testng.Assert.assertSame;

import org.testng.annotations.Test;

public class TC_Login_Assertion {

//Selenium Hackathon. You guys start adding testng  annotations wherever it is required
	
	//log4j //any one of the weekend -->
	//report --> test case pass(ext)-fail(exception,screen, log(extentReportObject))-skip  --- html format.
	@Test
	public void TC_Login_01() {
		System.out.println("TC_Login_01 Executed");
		//you have entered the credentials in a login screen and then you went to home screen and ther you are 
		//validating whether hme screen is dsplayed or not
		
		//assertEquals(false, true);
		//assertEquals(false, true, "Home screen is not displayed");
		//logged getting text of some element 
		//credentials -- admin / user 
		//admin -- User
		//assertNotSame("admin", "User", "Srinidhi is not displayed");
		assertSame("admin", "user","Logged in as an user im expecting user here");
		//assertno
		
	}
	/*
	@Test
	public void TC_Login_02() {
		System.out.println("TC_Login_02 Executed");
	}
	@Test
	public void TC_Login_03() {
		System.out.println("TC_Login_03 Executed");
	}
	@Test
	public void TC_Login_04() {
		System.out.println("TC_Login_04 Executed");
	}*/
}

//TestNg is aware of 
//which is passed , failed, skipped
//prerequisite needs to be run or not TestNG

// TestNG Listner --> When it starts it will be on listning mode 
//Srinidhi --> Doing some activity.
/// Server( <--> client
// you have so many online tutorial to say TestNG Listners
//test case name and then you will be taking class name .. 

//Framework

