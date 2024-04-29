package mytest.selenium;


//import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;


//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;


public class GmailTest {

	//<Access> class <ClassName> {
	// Class body where the actual logic lies.
	
		//<Access> <Return Type> <MethodName>(<MethodInput>, <MethodInput>, <MethodInput>) {
		// Method body where the actual logic lies.
		//}
	
	//}
	
	public static void main(String[] nikkiArgs) {
		System.out.println("I am Nikki");
		helloWorld();
		gmailTest();
	}
	
	public static void helloWorld() {
		System.out.println("Hello World, I now understand how to write a method and a class! :)");
	}
	
	public static void gmailTest() {
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.gmail.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("identifierId")).sendKeys("prasenjeetpaul14@gmail.com");
		driver.findElement(By.className("VfPpkd-vQzf8d")).click();
		String at = driver.getTitle();
		String et = "gmail";
		try {
			Thread.sleep(5000); // 5 seconds
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
		if(at.equalsIgnoreCase(et))
		{
			System.out.println("Test Susccesful");
		}
		else
		{
			System.out.println("Test Failure");
		}
	}
}

