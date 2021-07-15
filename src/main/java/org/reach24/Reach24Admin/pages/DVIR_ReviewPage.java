package org.reach24.Reach24Admin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.reach24.Reach24Admin.util.PropsReader;
import org.reach24.Reach24Admin.util.Wait;

public class DVIR_ReviewPage {

	WebDriver driver;
	PropsReader propsReader = new PropsReader();
	Wait wait;

	public DVIR_ReviewPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new Wait(driver);
	}

	public void changeStatusTo(String status) {
		String statusButton = null;
		if(status.equalsIgnoreCase("good")) {
			statusButton = "//button[@data-status = 'good']";
		} else if (status.equalsIgnoreCase("defer")) {
			statusButton = "//button[@data-status = 'deferred']";
		}else if (status.equalsIgnoreCase("defect")) {
			statusButton = "//button[@data-status = 'defect']";
		}
		WebElement statusButtonElement = driver.findElement(By.xpath(statusButton));
		wait.forElementToBeDisplayed(statusButtonElement);
		statusButtonElement.click();
		
	}
	
}
