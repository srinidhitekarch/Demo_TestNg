package Demo_TestNG.Demo_TestNg;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aspose.cells.Workbook;
import com.aspose.cells.Worksheet;

public class Demo_dataProvider {

	
/*	@BeforeSuite
	public void dependencyTriggering() {
	BrowserUtility.launchBrowser("ch");
	}
	
	
	@AfterMethod
	public void settingURL() {	
		if(BrowserUtility.driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).isDisplayed())
		{
			BrowserUtility.driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
			WebDriverWait wait = new WebDriverWait(BrowserUtility.driver, 30);
			wait.until(ExpectedConditions.visibilityOf(BrowserUtility.driver.findElement(By.id("email_field"))));	
		}
	
	}
	//100 sets of datas then its a problem -DataProvider
	
	@Test(dataProvider="Data_UsernameAndPassword")
	public void checkLoginSuccessOrNot(String username, String Password) throws Exception{
		System.out.println(username+"\t"+Password);
	BrowserUtility.loginToBrowser(username, Password);
	}

	@AfterSuite
	public void tearDownDependencies() {
		BrowserUtility.quitBrowser();
	}*/
	
	/*@Test(dataProvider="trainerInfo")
	public void validatingTrainerInfo(String name, String exp, String email) {
		System.out.println(name+"\t"+exp+"\t"+email);
	}*/
	
	
//Dataproviders we will pass it in an excel sheet.
	//It will read the excel file and then convert it into anmulti dimensional array
	//Reading the excelsheet --> Array
	@DataProvider(name="Data_UsernameAndPassword")
	public Object[][] usernamePassword_dp(){
		return new Object[][] {{"admin123@gmail.com","admin123"},{"admin@admin.com","admin"},{"a.gmail.com","a"}};
	}
	
	@DataProvider(name="trainerInfo")
	Object[][] trainerInfoFromExcel()throws Exception{
		String sFile = System.getProperty("user.dir")+"/testExcel.xls";
		 return readDataFromExcelSheet(sFile);
	}
	

	public Object[][] readDataFromExcelSheet(String sFile) throws Exception {
	File f = new File(System.getProperty("user.dir")+"/testExcel.xls");
	HSSFWorkbook myExcelBook = new HSSFWorkbook(new FileInputStream(sFile));
	HSSFSheet myExcleSheet = myExcelBook.getSheet("InsructorInfo");
	HSSFRow row1 = myExcleSheet.getRow(0);
	System.out.println(row1.getPhysicalNumberOfCells()); //To take total number of collumns
	System.out.println(myExcleSheet.getPhysicalNumberOfRows());//To take total number of Rows
	//System.out.println(row1.getLastCellNum());
	int iCountCol =row1.getLastCellNum();
	int iCountRow = myExcleSheet.getPhysicalNumberOfRows();
	Object[][] excelData= new Object[iCountRow][iCountCol]; //Creating multi dimensional array
	
	for(int countRow=0;countRow<iCountRow;countRow++) {
		for(int countCol = 0; countCol<iCountCol;countCol++) {
			HSSFRow tempRow=myExcleSheet.getRow(countRow);
			String sTemp;
			try {
			//System.out.println(tempRow.getCell(countCol).getStringCellValue());
			sTemp=tempRow.getCell(countCol).getStringCellValue();
			}catch(Exception e) {
				//System.out.println(tempRow.getCell(countCol).getNumericCellValue());
				sTemp=Double.toString(tempRow.getCell(countCol).getNumericCellValue());
			}
			excelData[countRow][countCol] = sTemp;
		}
	}	
	return excelData;
	}

	@Test(dataProvider="asposetrainerInfo")
	public void validatingTrainerInfo(String name, int exp, String email) {
		System.out.println(name+"\t"+exp+"\t"+email);
	}
	
	@DataProvider(name="asposetrainerInfo")
	Object[][] trainerInfoFromExcel_aspose()throws Exception{
		String sFile = System.getProperty("user.dir")+"/testExcel.xls";
		 return readDataFromExcelSheet_aspose(sFile);
	}
	//open source free tools can be used anywhere. 
	private Object[][] readDataFromExcelSheet_aspose(String sFile) throws Exception {
		//Creating a file stream containing the Excel file to be opened
				FileInputStream fstream = new FileInputStream(sFile);
				
				//Instantiating a Workbook object
				Workbook workbook = new Workbook(fstream);
				
				//Accessing the first worksheet in the Excel file
				Worksheet worksheet = workbook.getWorksheets().get(0);
				
				//Exporting the contents of 7 rows and 2 columns starting from 1st cell to Array.
				Object[][] dataTable = worksheet.getCells().exportArray(0,0,5,3);
				/*for (int i = 0 ; i < dataTable.length ; i++)
				{
					System.out.println("["+ i +"]: "+ Arrays.toString(dataTable[i]));
				}*/
				//Closing the file stream to free all resources
				fstream.close();
		return dataTable;
	}
	
	
	
	/*
	 Why TestNG
	 TestNG Annotations - Sequence of annotation
	 Priority
	 enable
	 when you have multiple same (@Test,@BeforeSuite)annotations how the execution will be - Sequesnce of Execution
	 One complete TestCase
	 
	 DataProviders
	 Suite
	 Methods
	 Groupings
	 suite in to --> Pom.xml 
	 * */
}
