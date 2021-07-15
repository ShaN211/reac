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

public class DashboardPage {

	WebDriver driver;
	PropsReader propsReader = new PropsReader();
	Wait wait;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new Wait(driver);
	}

	public void switchTabTo(String tabName) {
		if (tabName.equalsIgnoreCase("All")) {
			String tabSwitch = "//*[@id='incidents-tab']//h5[contains(text(), '" + tabName + "')]";
			driver.findElement(By.xpath(tabSwitch)).click();
		} else {
			String switchTo = "//*[@id='incidents-tab']//*[contains(@href,'" +tabName+ "')]";
			driver.findElement(By.xpath(switchTo)).click();
		}
	}

	@FindBy(xpath = "//*[@id='incidents-datatable_filter']//input[@type='search']")
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

	@FindBy(xpath = "//*[@id='event-snapshot-datatable_filter']//input[@type='search']")
	private WebElement searchBox;

	public void searchotherEvent(String eventId) {
		wait.forElementToBeDisplayed(searchBox);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		searchBox.clear();
		String[] splitId = eventId.split(" ");
		searchBox.sendKeys(splitId);
	}

	public HashMap<String, String> getInfoFromDashboardPage(String tabname) {
		HashMap<String, String> dashboardMap = new HashMap<String, String>();
		String tempKey;
		String tempValue;
		String headerSearch;
		String valueSearch;
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		for (int count = 1; count <= 50; count++) {
			try {
				if (tabname.equalsIgnoreCase("All")) {

					 headerSearch = "//*[@id='incidents-datatable_wrapper']//table[@role='grid']/thead/tr/th["
							+ count + "]";
					 valueSearch = "//div[@class='dataTables_scrollBody']//tr[@class='odd' and @role='row']/td["
							+ count + "]";
				} else {

					  headerSearch = " //*[@id='event-snapshot-datatable_wrapper']//table[@role='grid']/thead/tr/th["
							+ count + "]";
					  valueSearch = "//div[@class='dataTables_scrollBody']//*[@id='event-snapshot-datatable']//tr[@class='odd' and @role='row']/td["
							+ count + "]";
				}


				tempKey = driver.findElement(By.xpath(headerSearch)).getText();

				tempValue = driver.findElement(By.xpath(valueSearch)).getText();

				System.out.println(tempKey + " = " + tempValue);
				if (tempKey != null)
					dashboardMap.put(tempKey, tempValue);
			} catch (NoSuchElementException e) {
				break;
			}
		}

		return dashboardMap;

	}

}