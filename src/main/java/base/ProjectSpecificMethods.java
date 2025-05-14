package base;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utils.UtilityClass;

public class ProjectSpecificMethods extends UtilityClass{
	
	@BeforeSuite
	public void reportInitialization() {
		
		//To create report in the given location
		ExtentSparkReporter reporter = new ExtentSparkReporter("C:\\Users\\Digital Suppliers\\personal_space\\SauceDemoProject\\src\\test\\resources\\testOutput\\extentReport\\SwagLabAppReport.html");
		reporter.config().setReportName("Swag Lab App Report");
		
		//To capture the test data
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}
	
	@BeforeClass
	public void testDetails() {
		
		test=extent.createTest(testname,testdescription);
		test.assignCategory(testCategory);
		test.assignAuthor(testAuthor);
		
	}
	
	@DataProvider
	public Object[][] readData() throws IOException {
		
		return readExcel(sheetname);
		
	}
	
	@Parameters({"url","browser"})
	@BeforeMethod
	public void browserLaunchAndLoadUrl(String url, String browser) {
		
		browserLaunch(browser);
		loadURL(url);
	}
	
	@AfterMethod
	public void browserClose() {
		
		closeBrowser();
	}
	
	@AfterSuite
	public void closeReport() {
		
		extent.flush();
	}

}
