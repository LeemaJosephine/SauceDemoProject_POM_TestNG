package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class UtilityClass {
	
	public static WebDriver driver;
	public String sheetname;
	public static ExtentReports extent;
	public static ExtentTest test;
	public String testname, testdescription, testCategory, testAuthor; 
	
	public void browserLaunch(String browser) {
		
		if(browser.equals("chrome")) {
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
			
		} else if(browser.equals("edge")){
			
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--disable-notifications");
			driver = new EdgeDriver(options);
			
		} else if(browser.equals("firefox")){
			
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--disable-notifications");
			driver = new FirefoxDriver(options);
			
		} else{
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	public void loadURL(String url) {
		
		driver.get(url);
	}
	
	public Object[][] readExcel(String sheetname) throws IOException {
		
		XSSFWorkbook book = new XSSFWorkbook("C:\\Users\\Digital Suppliers\\personal_space\\SauceDemoProject\\src\\test\\resources\\data\\SwagLabsTestData.xlsx");
		XSSFSheet sheet = book.getSheet(sheetname);
		
		int rowCount = sheet.getPhysicalNumberOfRows();
		int columnCount = sheet.getRow(0).getPhysicalNumberOfCells();
		
		Object[][] data = new Object[rowCount - 1][columnCount];
		
		for(int i=1; i<rowCount; i++) {
			
			XSSFRow row = sheet.getRow(i);
			
			for(int j=0; j<columnCount; j++) {
				
				 XSSFCell cell = row.getCell(j, XSSFRow.MissingCellPolicy.RETURN_BLANK_AS_NULL);

	                if (cell == null) {
	                    data[i - 1][j] = "";
	                } else {
	                    switch (cell.getCellType()) {
	                        case STRING:
	                            String value = cell.getStringCellValue().trim();
	                            data[i - 1][j] = value.equalsIgnoreCase("null") ? null : value;
	                            break;
	                        case NUMERIC:
	                            data[i - 1][j] = cell.getNumericCellValue();
	                            break;
	                        case BOOLEAN:
	                            data[i - 1][j] = cell.getBooleanCellValue();
	                            break;
	                        default:
	                            data[i - 1][j] = null;
	                    }
				}	
			}
		}
		book.close();
		return data;
	}
	
	public String screenShot(String name) throws IOException {
		
		String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
		String path="C:\\Users\\Digital Suppliers\\personal_space\\SauceDemoProject\\src\\test\\resources\\testOutput\\screenShots\\"+name+timestamp+".png";
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File(path);
		FileUtils.copyFile(src, dest);
		return path;
	}
	
	public void closeBrowser() {
		
		driver.close();
	}

}
