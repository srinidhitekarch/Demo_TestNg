package Demo_TestNG.Demo_TestNg;

import org.testng.annotations.Test;

public class TC_Login_dependsOnMethod {

	//if login is passed then only i have to run home screen related test
	
		
	//TC_Login_01() --> success then only i have to run TC_Login_02
	@Test
	public void TC_Login_01()throws Exception { // Username and password field are present(Displayed) or not
		System.out.println("TC_Login_01 Executed");
		//throw new Exception("Intentionally");
	}
	
	@Test(dependsOnMethods="TC_Login_01")
	public void TC_Login_02() {//pass valid username and password and check whetherit is login or not
		System.out.println("TC_Login_02 Executed");
	
	}
	@Test
	public void TC_Login_03() {
		System.out.println("TC_Login_03 Executed");
	}
	@Test
	public void TC_Login_04() {
		System.out.println("TC_Login_04 Executed");
	}
}

//maven is installed on your system.. Not on your eclipse


//include and exclude method
// when you not given any include or exclude? 4
// when you include TC_Login_04? 1(TC_Login_04 will run)
// when you exclude TC_Login_04? 3(TC_Login_04 will be excluded and rest all will run)


