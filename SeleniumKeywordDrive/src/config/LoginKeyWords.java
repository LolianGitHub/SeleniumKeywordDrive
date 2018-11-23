package config;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import StartEngine.StartEngine_Excel;
import utility.Contants;
import utility.OrpUtil;

public class LoginKeyWords {
	public static WebDriver driver=null;
	
//	Maximize the Browser
	public static void OpenBrowser (String OR){
			
		try {
			System.setProperty("webdriver.chrome.driver", Contants.driverUrl);
			driver= new ChromeDriver();
			driver.manage().window().maximize();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			StartEngine_Excel.bResult=false;
			
		}
	}

//	Open Website URL
	public static void Navigate (String OR){
		driver.get(Contants.url);
	}
	
	public static void ContactUsHoverLink(String OR) {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath(OrpUtil.readValue(OR)))).perform();
		
	}
	
	public static void TalktoExpertLink(String OR) {
		driver.findElement(By.xpath(OrpUtil.readValue(OR))).click();
	}
	
	public static void Input_FirstName (String OR){
		try {
			driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
			driver.findElement(By.xpath(OrpUtil.readValue(OR))).clear();
			driver.findElement(By.xpath(OrpUtil.readValue(OR))).sendKeys(Contants.userName);
//			driver.findElement(By.xpath(OrpUtil.readValue(OR))).wait(5000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			StartEngine_Excel.bResult=false;
		}
	}
	public static void Select_Country (String OR){
		try {
			WebElement droplist = driver.findElement(By.xpath(OrpUtil.readValue(OR)));
//			driver.findElement(By.xpath(OrpUtil.readValue(OR))).wait(5000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			StartEngine_Excel.bResult=false;
		}
	}
	
	public static void Set_Country_NZ (String OR){
		try {
			WebElement dropList = driver.findElement(By.xpath(OrpUtil.readValue(OR)));
			dropList.click();
//			driver.findElement(By.xpath(OrpUtil.readValue(OR))).wait(5000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			StartEngine_Excel.bResult=false;
		}
	}
	
	public static void TalktoExpertButton (String OR){
		try {
			driver.findElement(By.xpath(OrpUtil.readValue(OR))).click();
//			driver.findElement(By.xpath(OrpUtil.readValue(OR))).wait(5000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			StartEngine_Excel.bResult=false;
		}
	}
	
//	Login
	
	
	public static void Login_Click (String OR){
		try {
			
			driver.findElement(By.xpath(OrpUtil.readValue(OR))).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			StartEngine_Excel.bResult=false;
		}
	}
	
//	Input User Name
	public static void Input_Name (String OR){
		try {
			driver.findElement(By.xpath(OrpUtil.readValue(OR))).clear();
			driver.findElement(By.xpath(OrpUtil.readValue(OR))).sendKeys(Contants.userName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			StartEngine_Excel.bResult=false;
		}
	}
	
//	Input Password
	public static void Input_Password (String OR){
		try {
			driver.findElement(By.xpath(OrpUtil.readValue(OR))).click();
			driver.findElement(By.xpath(OrpUtil.readValue(OR))).sendKeys(Contants.userPassword);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			StartEngine_Excel.bResult=false;
		}
	}
	

	
	
//	Submit Button
	public static void Login_Button (String OR){
		try {
			driver.findElement(By.xpath(OrpUtil.readValue(OR))).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			StartEngine_Excel.bResult=false;
		}
	}

	//	Quit
	public static void Logout_Click (String OR){
		try {
			Thread.sleep(600);
			driver.findElement(By.xpath(OrpUtil.readValue(OR))).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			StartEngine_Excel.bResult=false;
		}
		
	}

//	Close Browser
	public static void CloseBrowser (String OR){
		driver.quit();
	}

}
