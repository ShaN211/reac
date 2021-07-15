package org.reach24.Reach24Admin.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.reach24.Reach24Admin.util.Wait;

public class EventServicesPage extends EventCreationPage {
	Wait wait = new Wait(driver);

	public EventServicesPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = ".//*[contains(@id,'s2id_service_component')]")
	private List<WebElement> systemElement;
	@FindBy(xpath = "//div[@id='select2-drop']//input[@role='combobox']")
	private WebElement searchSystem;
	@FindBy(xpath = "//*[@class='select2-results']/li[1]/div")
	private WebElement clickSystem;

	public void selectSystem(String system, int elementPosition) {
		wait.forElementToBeDisplayed(systemElement.get(elementPosition));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		systemElement.get(elementPosition).click();
		searchSystem.sendKeys(system);
		wait.forElementToBeDisplayed(clickSystem);
		clickSystem.click();
	}

	@FindBy(xpath = ".//*[contains(@id, 's2id_sub_service_component')]")
	private List<WebElement> subSystemElement;
	@FindBy(xpath = "//div[@id='select2-drop']//input[@role='combobox']")
	private WebElement searchSubSystem;
	@FindBy(xpath = "//*[@class='select2-results']/li[1]/div")
	private WebElement clickSubSystem;

	public void selectSubSystem(String subSystem, int elementPosition) {
		wait.forElementToBeDisplayed(subSystemElement.get(elementPosition));
		subSystemElement.get(elementPosition).click();
		searchSubSystem.sendKeys(subSystem);
		wait.forElementToBeDisplayed(clickSubSystem);
		clickSubSystem.click();
	}

	@FindBy(xpath = "//*[@for = 'service']//following-sibling::div/a/span[1]")
	private List<WebElement> serviceElement;
	@FindBy(xpath = "//div[@id='select2-drop']//input[@role='combobox']")
	private WebElement searchService;
	@FindBy(xpath = "//*[@class='select2-results']/li[1]/div")
	private WebElement clickService;

	public void selectService(String services, int elementPosition) {
		wait.forElementToBeDisplayed(serviceElement.get(elementPosition));
		serviceElement.get(elementPosition).click();
		searchSubSystem.sendKeys(services);
		wait.forElementToBeDisplayed(clickService);
		clickService.click();
	}

	@FindBy(xpath = "//*[@for = 'defect']//following-sibling::div/a/span[1]")
	private List<WebElement> defectElement;
	@FindBy(xpath = "//input[@id='s2id_autogen4_search']")
	private WebElement searchDefect;
	@FindBy(xpath = "//*[@class='select2-results']/li[1]/div")
	private WebElement clickDefect;

	public void selectDefect(String defect, int elementPosition) {
		wait.forElementToBeDisplayed(defectElement.get(elementPosition));
		defectElement.get(elementPosition).click();
		searchSubSystem.sendKeys(defect);
		wait.forElementToBeDisplayed(clickDefect);
		clickDefect.click();
	}

	@FindBy(xpath = "//*[@for = 'location']//following-sibling::div/a/span[1]")
	private List<WebElement> locationElement;
	@FindBy(xpath = "//div[@id='select2-drop']//input[@role='combobox']")
	private WebElement searchLocation;
	@FindBy(xpath = "//*[@class='select2-results']/li[1]/div")
	private WebElement clickLocation;

	public void selectLocation(String location, int elementPosition) {
		wait.forElementToBeDisplayed(locationElement.get(elementPosition));
		locationElement.get(elementPosition).click();
		searchLocation.sendKeys(location);
		wait.forElementToBeDisplayed(clickLocation);
		clickLocation.click();
	}

	@FindBy(xpath = ".//*[contains(@id, 's2id_system_code')]")
	private List<WebElement> tractorSystemElement;
	@FindBy(xpath = "//div[@id='select2-drop']//input[@role='combobox']")
	private WebElement searchTractorSystem;
	@FindBy(xpath = "//*[@class='select2-results']/li[1]/div")
	private WebElement clickTractorSystem;

	public void selectTractorSystem(String tractorSystem, int elementPosition) {
		wait.forElementToBeDisplayed(tractorSystemElement.get(elementPosition));
		tractorSystemElement.get(elementPosition).click();
		searchTractorSystem.sendKeys(tractorSystem);
		wait.forElementToBeDisplayed(clickTractorSystem);
		clickLocation.click();
	}

	@FindBy(xpath = ".//*[contains(@id, 's2id_assembly')]")
	private List<WebElement> assemblyElement;
	@FindBy(xpath = "//div[@id='select2-drop']//input[@role='combobox']")
	private WebElement searchAssembly;
	@FindBy(xpath = "//*[@class='select2-results']/li[1]/div")
	private WebElement clickAssembly;

	public void selectAssembly(String tractorSubSystem, int elementPosition) {
		wait.forElementToBeDisplayed(assemblyElement.get(elementPosition));
		assemblyElement.get(elementPosition).click();
		searchAssembly.sendKeys(tractorSubSystem);
		wait.forElementToBeDisplayed(clickAssembly);
		clickAssembly.click();
	}
	@FindBy(xpath = ".//*[contains(@id, 's2id_componet_code')]")
	private List<WebElement> componentElement;
	@FindBy(xpath = "//div[@id='select2-drop']//input[@role='combobox']")
	private WebElement searchComponent;
	@FindBy(xpath = "//*[@class='select2-results']/li[1]/div")
	private WebElement clickComponent;

	public void selectComponent(String component, int elementPosition) {
		wait.forElementToBeDisplayed(componentElement.get(elementPosition));
		componentElement.get(elementPosition).click();
		searchComponent.sendKeys(component);
		wait.forElementToBeDisplayed(clickComponent);
		clickComponent.click();
	}
	@FindBy(xpath = ".//*[contains(@id, 's2id_position')]")
	private List<WebElement> positionElement;
	@FindBy(xpath = "//div[@id='select2-drop']//input[@role='combobox']")
	private WebElement searchPosition;
	@FindBy(xpath = "//*[@class='select2-results']/li[1]/div")
	private WebElement clickPosition;

	public void selectPosition(String position, int elementPosition) {
		wait.forElementToBeDisplayed(positionElement.get(elementPosition));

		positionElement.get(elementPosition).click();
		searchPosition.sendKeys(position);
		wait.forElementToBeDisplayed(clickPosition);
		clickPosition.click();
	}
	@FindBy(xpath = ".//*[contains(@id, 's2id_wa_code')]")
	private List<WebElement> workAccomplishedElement;
	@FindBy(xpath = "//div[@id='select2-drop']//input[@role='combobox']")
	private WebElement searchWorkAccomplished;
	@FindBy(xpath = "//*[@class='select2-results']/li[1]/div")
	private WebElement clickWorkAccomplished;

	public void selectWorkAccomplished(String workAccomplished, int elementPosition) {
		wait.forElementToBeDisplayed(positionElement.get(elementPosition));

		workAccomplishedElement.get(elementPosition).click();
		searchWorkAccomplished.sendKeys(workAccomplished);
		wait.forElementToBeDisplayed(clickPosition);
		clickWorkAccomplished.click();
	}
	@FindBy(xpath = ".//*[contains(@id, 's2id_failure_code')]")
	private List<WebElement> reasonElement;
	@FindBy(xpath = "//div[@id='select2-drop']//input[@role='combobox']")
	private WebElement searchReason;
	@FindBy(xpath = "//*[@class='select2-results']/li[1]/div")
	private WebElement clickReason;

	public void selectReasonforRepair(String reason , int elementPosition) {
		wait.forElementToBeDisplayed(positionElement.get(elementPosition));
		reasonElement.get(elementPosition).click();
		searchReason.sendKeys(reason );
		wait.forElementToBeDisplayed(clickPosition);
		clickReason.click();
	}
	@FindBy(id = "event-submit")
	private WebElement submitButton;

	public void clickSubmitButton() {
		submitButton.click();
	}
}
