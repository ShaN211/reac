package org.reach24.Reach24Admin.pages;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.reach24.Reach24Admin.util.PropsReader;
import org.reach24.Reach24Admin.util.Wait;

import com.sun.glass.events.KeyEvent;

public class WebformPage {

	WebDriver driver;
	PropsReader propsReader = new PropsReader();
	Wait wait;

	public WebformPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new Wait(driver);
	}

	@FindBy(xpath = "//*[text()='Select Environment']//parent::div")
	private WebElement dropDown;
	@FindBy(xpath = "//*[@id='react-select-2-option-1']")
	private WebElement selectTesting;

	public void selectEnvironment() throws AWTException {
		wait.forElementToBeDisplayed(dropDown);
		dropDown.click();
		System.out.println(driver.getPageSource());
		wait.forElementToBeDisplayed(selectTesting);
	/*	Robot r = new Robot();		
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);	*/
		selectTesting.click();
		wait.forLoading();
	}

	@FindBy(xpath = "//*[text()='I don’t have a Customer Account #']")
	private WebElement dontHaveCusAcc;

	public void selectCusAccOption() {
		wait.forElementToBeDisplayed(dontHaveCusAcc);
		dontHaveCusAcc.click();
	}
	
	@FindBy(xpath = "//*[@class='fluid ui button bs-btn bs-primary']")
	private WebElement gettingStarted;

	public void selectStart() {
		wait.forElementToBeDisplayed(gettingStarted);
		gettingStarted.click();
	}

	@FindBy(xpath = "//*[@name='fleetName']")
	private WebElement fleetName;

	@FindBy(xpath = "//*[@type='submit']")
	private WebElement continueFlow;

	public void enterFleetName(String fleetNameStr) {
		wait.forElementToBeDisplayed(fleetName);
		fleetName.sendKeys(fleetNameStr);

		wait.forElementToBeDisplayed(continueFlow);
		continueFlow.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	//	wait.forElementToBeDisplayed(continueFlow);
	//	continueFlow.click();

	}
	
	@FindBy(xpath = "(//button[@class='fluid ui button bs-btn bs-primary'])[1]")
	public WebElement Selectfleet;
	
	public void enterNewFleetName() {
		wait.forElementToBeDisplayed(Selectfleet);
		Selectfleet.click();
	}
	
	
	@FindBy(xpath = " //*[text() = 'Yes, this is my fleet']")
	private WebElement acceptfleet;
	
	public void confirmfleet() {
		wait.forElementToBeDisplayed(acceptfleet);
		acceptfleet.click();
	}
	
	
	@FindBy(xpath = "//*[@name='newFleetName']")
	private WebElement newFleetName;

	public void enterNewFleetName(String fleetNameStr) {
		wait.forElementToBeDisplayed(newFleetName);
		newFleetName.sendKeys(fleetNameStr);
	}
	
	@FindBy(xpath = "//*[@name='newFleetAddress']")
	private WebElement newFleetAdd;

	public void enterNewFleetAdd(String fleetAddStr) {
		wait.forElementToBeDisplayed(newFleetAdd);
		newFleetAdd.sendKeys(fleetAddStr);
	}
	
	@FindBy(xpath = "//input[@name='newFleetScacCode' and contains(text( ), SCAC)]")
	private WebElement dclinewFleetScacCode;

	public void enterNewdcliFleetSAC(String fleetSACStr) {
		wait.forElementToBeDisplayed(dclinewFleetScacCode);
		dclinewFleetScacCode.sendKeys(fleetSACStr);		
	}
	
	@FindBy(xpath = "//input[@name='scacCode' and contains(text( ), SCAC)]")
	private WebElement bsnewFleetScacCode;
	
	public void enternewbsfleetsac(String bsfleetsac) {
		wait.forElementToBeDisplayed(bsnewFleetScacCode);
		bsnewFleetScacCode.sendKeys(bsfleetsac);
	}
	
	
	@FindBy(xpath = "//*[@name='newFleetPhone']")
	private WebElement newFleetPhone;

	public void enterNewFleetPH(String fleetPHStr) {
		wait.forElementToBeDisplayed(newFleetPhone);
		newFleetPhone.sendKeys(fleetPHStr);
	}

	@FindBy(xpath = "//*[@type='submit' and text()='Submit']")
	private WebElement submit;

	public void clickSubmit() {
		wait.forElementToBeDisplayed(submit);
		submit.click();
	}

	@FindBy(xpath = "//*[text()='Your request has been submitted']")
	private WebElement text;

	public boolean verifyMsg() {
		wait.forElementToBeDisplayed(text);
		return text.isDisplayed();
	}

	public void selectEquipmentType(String equipmentTypeStr) {
		String equipmentType = "//*[text()='" + equipmentTypeStr + "']//parent::div";
		WebElement equipmentTypeEle = driver.findElement(By.xpath(equipmentType));
		wait.forElementToBeDisplayed(equipmentTypeEle);
		equipmentTypeEle.click();
	}

	@FindBy(xpath = "//*[@type='submit' and text()='Next']")
	private WebElement next;

	public void clickNext() {
		wait.forElementToBeDisplayed(next);
		next.click();
	}

	@FindBy(xpath = "//*[@name='equipmentNo']")
	private WebElement EquipmentNum;

	public void selectEquipmentNum(String equipmentNumStr) {
		wait.forElementToBeDisplayed(EquipmentNum);
		EquipmentNum.sendKeys(equipmentNumStr);
	}

	@FindBy(xpath = "//*[@name='assContainer']")
	private WebElement associatedContainer;

	public void selectAssociatedContainer(String associatedContainerStr) {
		wait.forElementToBeDisplayed(associatedContainer);
		associatedContainer.sendKeys(associatedContainerStr);
	}

	@FindBy(xpath = "//*[@name='assTrailer']")
	private WebElement associatedTrailer;

	public void selectAssociatedTrailer(String associatedTrailerStr) {
		wait.forElementToBeDisplayed(associatedTrailer);
		associatedTrailer.sendKeys(associatedTrailerStr);
	}

	@FindBy(xpath = "//*[@name='assChassis']")
	private WebElement associatedChassis;

	public void selectAssociatedChassis(String associatedChassisStr) {
		wait.forElementToBeDisplayed(associatedChassis);
		associatedChassis.sendKeys(associatedChassisStr);
	}

	@FindBy(xpath = "//*[@name='assTractor']")
	private WebElement associatedPowerUnit;

	public void selectAssociatedPowerUnit(String associatedPUStr) {
		wait.forElementToBeDisplayed(associatedPowerUnit);
		associatedPowerUnit.sendKeys(associatedPUStr);
	}

	@FindBy(xpath = "//*[@name='reportedLocation']")
	private WebElement reportedLocation;
	@FindBy(xpath = "(//div[@class='Demo__suggestion-item'])[1]")
	private WebElement location;
	

	public void selectLocation() throws AWTException {
		wait.forElementToBeDisplayed(reportedLocation);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", reportedLocation);
		js.executeScript("arguments[0].click()", reportedLocation);
		reportedLocation.sendKeys("San Francisco");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wait.forLoading();
		Robot r = new Robot();
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);
		//	r.keyPress(KeyEvent.VK_ENTER);
			//r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	@FindBy(xpath = "//*[@class=' css-tlfecz-indicatorContainer' and @aria-hidden='true']")
	private WebElement serviceprovider;
	@FindBy(xpath = "//input[@name='breakdownNotes']")
	private WebElement breaknote;

	public void chooseserviceprovider() throws AWTException {
		wait.forElementToBeDisplayed(serviceprovider);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", breaknote);
		js.executeScript("arguments[0].click()", serviceprovider);
		serviceprovider.click();
		wait.forLoading();
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	
	@FindBy(xpath = "//*[@name='driverName']")
	private WebElement enterDriverName;

	public void selectEnterDriverName(String driverName) {
		wait.forElementToBeDisplayed(enterDriverName);
		enterDriverName.sendKeys(driverName);
	}

	@FindBy(xpath = "//*[@name='driverPhone']")
	private WebElement driverPhone;

	public void selectEnterDriverPhone(String phoneStr) {
		wait.forElementToBeDisplayed(driverPhone);
		driverPhone.sendKeys(phoneStr);
	}

	@FindBy(xpath = "//*[text()='System']//following::input[1]")
	private WebElement system;

	public void selectSystem(String serviceStr) {

		wait.forElementToBeDisplayed(system);
		system.sendKeys(serviceStr.split(" ")[0]);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String s;
		if (serviceStr.contains(" - ")) {
			s = "//*[text()='System']//following::input[1]//following::div[text()='" + serviceStr
					+ "' and contains(@id, option-0)]";
		} else {
			s = "//*[text()='System']//following::input[1]//following::div[text()='" + serviceStr
					+ "' and contains(@id, option-0)][2]";
		}

		System.out.println(driver.getPageSource());

		WebElement serviceList = driver.findElement(By.xpath(s));

		wait.forElementToBeDisplayed(serviceList);
		serviceList.click();
	}

	@FindBy(xpath = "//*[text()='Subsystem']//following::input[1]")
	private WebElement subSystem;

	public void selectSubSystem(String subSystemStr) {

		wait.forElementToBeDisplayed(subSystem);
		subSystem.sendKeys(subSystemStr);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String s = "//*[text()='Subsystem']//following::input[1]//following::div[text()='" + subSystemStr
				+ "' and contains(@id, option-0)][2]";
		
		// System.out.println(driver.getPageSource());

		WebElement serviceList = driver.findElement(By.xpath(s));

		wait.forElementToBeDisplayed(serviceList);
		serviceList.click();
	}

	@FindBy(xpath = "//*[text()='Service']//following::input[1]")
	private WebElement service;

	public void selectService(String serviceStr) {

		wait.forElementToBeDisplayed(service);
		service.sendKeys(serviceStr);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String s = "//*[text()='Service']//following::input[1]//following::div[text()='" + serviceStr
				+ "' and contains(@id, option-0)][2]";
		// System.out.println(driver.getPageSource());

		WebElement serviceList = driver.findElement(By.xpath(s));

		wait.forElementToBeDisplayed(serviceList);
		serviceList.click();
	}

	@FindBy(xpath = "//*[text()='Payment Method']//following::input[1]")
	private WebElement payment;

	public void enterPayment(String paymentStr) {

		wait.forElementToBeDisplayed(payment);
		payment.sendKeys(paymentStr);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String s = "//*[text()='Payment Method']//following::input[1]//following::div[text()='" + paymentStr
				+ "' and contains(@id, option-0-0)][2]";
		System.out.println(driver.getPageSource());

		WebElement serviceList = driver.findElement(By.xpath(s));

		wait.forElementToBeDisplayed(serviceList);
		serviceList.click();
	}

	@FindBy(xpath = "//*[text()='Driver Notification Method']//following::input[1]")
	private WebElement notification;

	public void enterNotification() {

		wait.forElementToBeDisplayed(notification);
		notification.sendKeys("No Notification Needed");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String s = "//*[text()='Driver Notification Method']//following::input[1]//following::div[text()='No Notification Needed' and contains(@id, option-0-0)][2]";
		System.out.println(driver.getPageSource());

		WebElement serviceList = driver.findElement(By.xpath(s));

		wait.forElementToBeDisplayed(serviceList);
		serviceList.click();
	}

	@FindBy(xpath = "//*[text()='Assembly']//following::input[1]")
	private WebElement assembly;

	public void selectAssembly(String assemblyStr) {

		wait.forElementToBeDisplayed(assembly);
		assembly.sendKeys(assemblyStr.split(" ")[0]);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String s = "//*[text()='Assembly']//following::input[1]//following::div[text()='" + assemblyStr
				+ "' and contains(@id, option-0)]";
		// System.out.println(driver.getPageSource());

		WebElement serviceList = driver.findElement(By.xpath(s));

		wait.forElementToBeDisplayed(serviceList);
		serviceList.click();
	}
		
	@FindBy(xpath = "//*[@type='button' and text()='Done']")
	private WebElement donebtn;

	public void Done() {

		wait.forElementToBeDisplayed(donebtn);
		donebtn.click();		
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
