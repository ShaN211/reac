package org.reach24.Reach24Admin.pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.reach24.Reach24Admin.util.PropsReader;
import org.reach24.Reach24Admin.util.Wait;

public class DVIR_DashboardPage {

	WebDriver driver;
	PropsReader propsReader = new PropsReader();
	Wait wait;

	public DVIR_DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new Wait(driver);
	}
	
	public void dvirSwitchTabTo(String tabName) {
		String tabSwitch = "//*[@id='dvirs-tab']//h5[contains(text(), '" + tabName + "')]";
		driver.findElement(By.xpath(tabSwitch)).click();
	}
	
	@FindBy(xpath = "//*[@id='dvirs-datatable_filter']//input[@type='search']")
	private WebElement searchBoxElement;

	public void searchEvent(String eventId) {
		wait.forElementToBeDisplayed(searchBoxElement);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		searchBoxElement.clear();
		searchBoxElement.sendKeys(eventId);
	}
	
	public HashMap<String, String> getInfoFromDashboardPage() {
		HashMap<String, String> dashboardMap = new HashMap<String, String>();
		String tempKey;
		String tempValue;
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		for (int count = 1; count <= 50; count++) {
			try {
				String headerSearch = "//*[@id='dvirs-datatable_wrapper']//table[@role='grid']/thead/tr/th[" + count
						+ "]";
				String valueSearch = " //*[@id='dvirs-datatable']//tr[@class='odd' and @role='row']/td["
						+ count + "]";
				tempKey = driver.findElement(By.xpath(headerSearch)).getText();

				tempValue = driver.findElement(By.xpath(valueSearch)).getText();
				
				if (tempKey != null)
					dashboardMap.put(tempKey, tempValue);
			} catch (NoSuchElementException e) {
				break;
			}
		}

		return dashboardMap;

	}
	
	
}
