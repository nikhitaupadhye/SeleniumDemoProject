package mytest.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import java.util.Set;



public class PaulTest {

	public static void paulTest() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://prasenjeetpaul.github.io/");
		driver.manage().window().maximize();
		try {
			Thread.sleep(5000); // 5 seconds
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Find the element with CSS selector #intro-name
		WebElement introNameElement = driver.findElement(By.cssSelector("#intro-name"));

		// Get the text content of the element
		String introNameText = introNameElement.getText();

		// Check if the text content is "Prasenjeet Paul"
		if (introNameText.equals("Prasenjeet Paul")) {
			System.out.println("The text content of #intro-name is 'Prasenjeet Paul'. Test passed.");
		} else {
			System.out.println("The text content of #intro-name is not 'Prasenjeet Paul'. Test failed.");
		}

		 //- Find Paul in page
		 String pageSource = driver.getPageSource();
		 String wordToFind = "Nikki";
		 if (pageSource.contains(wordToFind)) {
		 System.out.printf("The word '%s' is present on the page. Test passed.",
		 wordToFind);
		 } else {
		 System.out.printf("The word '%s' is not present on the page. Test failed.",
		 wordToFind);
		 }
		
		 //Count the occurrences of "Paul"
		 int count = 0;
		 for (String word : pageSource.split("\\W+")) {
		 if (word.equals("Paul")) {
		 count++;
		 }
		 }

		// Print the number of times "Paul" is present
		System.out.println("The word 'Paul' is present " + count + " times on the page.");

		// - Scroll bottom of the page
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
   
		// - Open Linkedin
//		driver.findElement(By.cssSelector("#link-1 > h5 > a")).click();   
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.urlToBe("https://www.linkedin.com/in/prasenjeetpaul"));
		
		// Get the current window handle
		String currentWindowHandle = driver.getWindowHandle();

		// Locate and click the LinkedIn link
		driver.findElement(By.cssSelector("#link-1 > h5 > a")).click();   

		// Wait for a new window or tab to open
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.numberOfWindowsToBe(2)); // Assuming only two windows are expected

		// Get handles of all open windows
		Set<String> windowHandles = driver.getWindowHandles();

		// Identify the new window handle
		String newWindowHandle = null;
		for (String windowHandle : windowHandles) {
		    if (!windowHandle.equals(currentWindowHandle)) {
		        newWindowHandle = windowHandle;
		        break;
		    }
		}

		// Switch to the new window handle
		driver.switchTo().window(newWindowHandle);

		// Wait for the URL to contain "linkedin.com"
		new WebDriverWait(driver, Duration.ofSeconds(10))
		    .until(ExpectedConditions.urlContains("https://www.linkedin.com/in/prasenjeetpaul"));

		// Now you are switched to the new window
		// You can perform actions or validations on the LinkedIn page

		// Example: Print the current URL of the LinkedIn page
		System.out.println("Current URL: " + driver.getCurrentUrl());

		
		// - Test case for Linkedin validation
//	    String currentUrl = driver.getCurrentUrl();
//	    String expectedUrl = "https://www.linkedin.com/in/prasenjeetpaul";
//	    if (currentUrl.equals(expectedUrl)) {
//	        System.out.println("LinkedIn page opened successfully. Test successful.");
//	    } else {
//	        System.out.println("LinkedIn page did not open. Test failed.");
//	    }
		driver.quit();
	}
}
//    