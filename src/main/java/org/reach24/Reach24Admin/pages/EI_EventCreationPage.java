package org.reach24.Reach24Admin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.reach24.Reach24Admin.util.PropsReader;
import org.reach24.Reach24Admin.util.Wait;

public class EI_EventCreationPage {

	WebDriver driver;
	PropsReader propsReader = new PropsReader();
	Wait wait;

	public EI_EventCreationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new Wait(driver);
	}

	@FindBy(xpath = "//strong[text()= 'Inspection Type' ]//following::div//span[1]")
	private WebElement inspectionType;
	@FindBy(xpath = "//div[@id='select2-drop']//input[@role='combobox']")
	private WebElement searchInspectionType;
	@FindBy(xpath = "//*[@class='select2-results']/li[1]/div")
	private WebElement clickInspectionType;

	public void selectInspectionType(String inspectionTypeStr) {
		wait.forElementToBeDisplayed(inspectionType);
		inspectionType.click();
		searchInspectionType.sendKeys(inspectionTypeStr);
		wait.forElementToBeDisplayed(clickInspectionType);
		clickInspectionType.click();
	}

	@FindBy(id = "equipment_inspection_reference_work_order_number")
	private WebElement referenceNumElement;

	public void referenceNumber(String reference) {
		wait.forElementToBeDisplayed(referenceNumElement);
		referenceNumElement.sendKeys(reference);
	}

	public void selectInspectionCategoriesStatus(String inspectionCategories, String status) {
		String inspectionCategoriesElement = null;
		
		if(status.equalsIgnoreCase("good")) {
			inspectionCategoriesElement= "//*[@id=\"inspection-categories-section\"]//label[contains(text(),'" + inspectionCategories
					+ "')]//following-sibling::div/div/label[2]";
		} else if (status.equalsIgnoreCase("defect")) {
			inspectionCategoriesElement= "//*[@id=\"inspection-categories-section\"]//label[contains(text(),'" + inspectionCategories
					+ "')]//following-sibling::div/div/label";
		}
		
		 driver.findElement(By.xpath(inspectionCategoriesElement)).click();
	}
	
	public void popupHandle(String option) {
		String popupElement = null;
		
		if(option.equalsIgnoreCase("yes")) {
			popupElement= "//*[@class='confirm']";
		} else if (option.equalsIgnoreCase("no")) {
			popupElement= "//*[@class='cancel']";
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 driver.findElement(By.xpath(popupElement)).click();
	}

	@FindBy(xpath = "//*[@id='show_actions']/a[1]")
	private WebElement createServiceEvent;

	public void clickCreateServiceEventButton() {
		wait.forElementToBeDisplayed(createServiceEvent);
		createServiceEvent.click();
	}
	
	@FindBy(xpath = "//strong[text()= 'Equipment Type' ]//following::div//span[1]")
	private WebElement equipmentType;

	public String getEquipmentType() {
		wait.forElementToBeDisplayed(equipmentType);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return equipmentType.getText();
	}
	
	@FindBy(xpath = "//*[@id='equipment_number']")
	private WebElement equipmentNumber;

	public String getEquipmentNumber() {
		wait.forElementToBeDisplayed(equipmentNumber);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return equipmentNumber.getAttribute("value");
	}
	
	@FindBy(xpath = "//*[@for='incident_iep_id']//following::div//div//span[1]")
	private WebElement equipmentProvider ;

	public String getEquipmentProvider() {
		wait.forElementToBeDisplayed(equipmentProvider);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return equipmentProvider.getText();
	}
	
	
	@FindBy(xpath = "//*[@id='incident_reference_work_order_number']")
	private WebElement referenceNumber ;

	public String getReferenceNumber() {
		wait.forElementToBeDisplayed(referenceNumber);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return referenceNumber.getAttribute("value");
	}
	
	
}
