package com.kani.jenkins.Jenkins_BitBucket;

import org.testng.annotations.Test;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonPage {

	@Test
	public void fnVerifyPageTitle() {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		
		driver.get("https://www.amazon.in/");
		System.out.println("Amazon Home Page is opened.");
		
		String strHomeTitle1 = driver.getTitle();
		System.out.println("Title : " + strHomeTitle1);
		
		driver.findElement(By.linkText("Amazon Pay")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("span[class='onep-instrument-header-desktop']"))); 
		
		if(driver.findElement(By.cssSelector("span[class='onep-instrument-header-desktop']")).isDisplayed()) {
			System.out.println("Navigated to Amazon Pay Page.");
		}
		
		String strPayTitle = driver.getTitle();
		System.out.println("Title : " + strPayTitle);
		
		driver.navigate().back();
		 
		if(driver.findElements(By.cssSelector("span[class='onep-instrument-header-desktop']")).size() == 0) {
			System.out.println("Navigated back to Amazon Home Page.");
		}
		
		String strHomeTitle2 = driver.getTitle();
		System.out.println("Title : " + strHomeTitle2);
		
		if(strHomeTitle1.equalsIgnoreCase(strHomeTitle2)) {
			System.out.println("The title matches. " + strHomeTitle1);
		}
		
		driver.quit();
	}
}
