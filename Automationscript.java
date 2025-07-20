package com.redBus;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RedBusAutomation {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("---start-maximized");
		
		WebDriver wd = new ChromeDriver(chromeOptions);
		WebDriverWait wait = new WebDriverWait(wd,Duration.ofSeconds(30));
		
	wd.get("https://www.redbus.in");
	
	
	
	By sourceButtonLocator=By.xpath("//div[contains(@class, \"srcDestWrapper\") and @role=\"button\"]");
	WebElement sourceButton =wait.until(ExpectedConditions.visibilityOfElementLocated(sourceButtonLocator));
	
	sourceButton.click();
		     
	 By searchSuggestionSectionLocator=By.xpath("//div[contains(@class,\"searchSuggestionWrapper\")]");
	 wait.until(ExpectedConditions.visibilityOfElementLocated(searchSuggestionSectionLocator));
	 
	 selectLocation(wd,wait,"Mumbai");
	 selectLocation(wd,wait,"Pune");
	 
	 By searchButtonLocator = By.xpath("//button[contains(@class,\"searchButtonWrapper\")]");
	 WebElement searchButton= wait.until(ExpectedConditions.elementToBeClickable(searchButtonLocator));
	 
	 searchButton.click();
	 
	
	 
	 
	 By primoButtonLocator = By.xpath("//div[contains(text(), \"Primo\")]");
	 WebElement primoButton= wait.until(ExpectedConditions.elementToBeClickable(primoButtonLocator));
	 primoButton.click();
	   // Thread.sleep(4000);
	    
	    
	    By tuppleWrapperLocator = By.xpath("//li[contains(@class,\"tupleWrapper\")]");// Found the row locator
		 
		 By busesNameLocator= By.xpath("//div[contains(@class,\"travelsName\")]");//found bus name locator
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(tuppleWrapperLocator));



	 
	 By eveningButtonLocator = By.xpath("//div[contains(text(), \"Evening\")]");
	 WebElement eveningButton= wait.until(ExpectedConditions.elementToBeClickable(eveningButtonLocator));
	 eveningButton.click();
	 
	 

	 By subTitleLocator= By.xpath("//span[contains(@class,\"subtitle\")]");
	 
	 WebElement subTitle =null;
	 

		 if(wait.until(ExpectedConditions.textToBePresentInElementLocated(subTitleLocator,"buses")));{
			 subTitle=  wait.until(ExpectedConditions.visibilityOfElementLocated(subTitleLocator));

		 }
		 
		 System.out.println(subTitle.getText());
		
	 
		 JavascriptExecutor js = (JavascriptExecutor) wd;		 
	 
		 while (true) { // Lazy Loading

				List<WebElement> rowList = wait
						.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(tuppleWrapperLocator));
				List<WebElement> endOfList = wd.findElements(By.xpath("//span[contains(text(),\"End of list\")]"));

				if (!endOfList.isEmpty()) {
					break; // exit condition for the while loop
				}

				js.executeScript("arguments[0].scrollIntoView({behavior:'smooth'})", rowList.get(rowList.size() - 3));

			}
		 
		 
	
		
     }
	

	public static void selectLocation(WebDriver wd, WebDriverWait wait, String locationData) {
		

	     WebElement searchTextBoxElement=wd.switchTo().activeElement();//gives the textbox
	     searchTextBoxElement.sendKeys("Mumbai");
	     
	     By searchCategoryLocator =By.xpath("//div[contains(@class,\"searchCategory\")]");
	     List<WebElement>searchList=wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(searchCategoryLocator,2));
	     System.out.println(searchList.size());
	     WebElement locationSearchResult= searchList.get(0);
	     //chaining of web elemnent:
	     
	     By locationNameLocator = By.xpath(".//div[@contains(@class,\"listHeader\")]");
	     List<WebElement>locationList=locationSearchResult.findElements(locationNameLocator);
	     System.out.println(locationList.size());
	     
	     for(WebElement location: locationList) {
	    	 String lName =location.getText();
	    	 if(lName.equalsIgnoreCase(locationData)) {
	    		 location.click();
	    		 break;

	    	 
	    		 
	    	 }
	     }
	     
	     
	     
	
		
	}

}
