package org.reach24.Reach24Admin.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.reach24.Reach24Admin.util.PropsReader;
import org.reach24.Reach24Admin.util.Reach24AutomationCustomException;
import org.reach24.Reach24Admin.util.Wait;

public class EventCreationPage {

	WebDriver driver;
	PropsReader propsReader = new PropsReader();
	Wait wait;

	public EventCreationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new Wait(driver);
	}

	public void getDesiredOptionFromList(String optionToSelect) throws Reach24AutomationCustomException {
		List<WebElement> options = driver.findElements(By.xpath("//*[@class='select2-results']/li/div"));
		Boolean isSelected = false;
		for (WebElement option : options) {
			if (optionToSelect.equalsIgnoreCase(option.getText())) {
				option.click();
				isSelected = true;
				break; 
			}
		}

		if (!isSelected)
			throw new Reach24AutomationCustomException("Options not selected");
	}

	@FindBy(xpath = "//strong[text()= 'Equipment Type' ]//following::div//span[1]")
	private WebElement equipmentTypeElement;
	@FindBy(xpath = "//div[@id='select2-drop']//input[@role='combobox']")
	private WebElement searchEquipmentType;
	@FindBy(xpath = "//*[@class='select2-results']/li[1]/div")
	private WebElement clickEquipmentType;

	public void selectEquipmentType(String equipmentType) {
		wait.forElementToBeDisplayed(equipmentTypeElement);
		equipmentTypeElement.click();
		searchEquipmentType.sendKeys(equipmentType);
		wait.forElementToBeDisplayed(clickEquipmentType);
		clickEquipmentType.click();
	}

	@FindBy(xpath = "//*[@id='s2id_incident_responsible_payer']/a/span")
	private WebElement responsiblePayerElement;
	@FindBy(xpath = "//div[@id='select2-drop']//input[@role='combobox']")
	private WebElement searchResponsiblePayer;
	@FindBy(xpath = "//*[@class='select2-results']/li[1]/div")
	private WebElement clickResponsiblePayer;

	public void selectResponsiblePayer(String payer) {
		wait.forElementToBeDisplayed(responsiblePayerElement);
		responsiblePayerElement.click();
		searchResponsiblePayer.sendKeys(payer);
		wait.forElementToBeDisplayed(clickResponsiblePayer);
		clickResponsiblePayer.click();
	}

	@FindBy(xpath = "//*[@id='s2id_payment_method']/a/span")
	private WebElement paymentMethodElement;
	@FindBy(xpath = "//div[@id='select2-drop']//input[@role='combobox']")
	private WebElement searchPaymentMethodCreate;
	@FindBy(xpath = "//*[@class='select2-results']/li[1]/ul/li/div")
	private WebElement clickPaymentMethodCreate;
	@FindBy(xpath = "//*[@class='select2-results']/li[2]/ul/li/div")
	private WebElement clickBSPaymentMethodCreate;

	public void selectPaymentMethod(String paymentMethod) {
		wait.forElementToBeDisplayed(paymentMethodElement);
		paymentMethodElement.click();
		searchPaymentMethodCreate.sendKeys(paymentMethod);
		if (paymentMethod.contains("Bridgestone")) {
			wait.forElementToBeDisplayed(clickBSPaymentMethodCreate);
			clickBSPaymentMethodCreate.click();
		} else {
			wait.forElementToBeDisplayed(clickPaymentMethodCreate);
			clickPaymentMethodCreate.click();
		}
	}

	@FindBy(xpath = "//*[@id='s2id_payment_account_no']/a/span")
	private WebElement paymentAccountElement;
	@FindBy(xpath = "//div[@id='select2-drop']//input[@role='combobox']")
	private WebElement searchPaymentAccountCreate;
	@FindBy(xpath = "//*[@class='select2-results']/li[1]/div")
	private WebElement clickPaymentAccountCreate;

	public void selectPaymentAccount(String paymentAccount) {
		wait.forElementToBeDisplayed(paymentAccountElement);
		paymentAccountElement.click();
		searchPaymentAccountCreate.sendKeys(paymentAccount);
		wait.forElementToBeDisplayed(clickPaymentAccountCreate);
		clickPaymentAccountCreate.click();

	}

	@FindBy(id = "chassis_number")
	private WebElement chassisNumberElement;

	public void enterChassisNumber(String chassisNumber) {
		wait.forElementToBeDisplayed(chassisNumberElement);
		chassisNumberElement.sendKeys(chassisNumber);
	}

	@FindBy(id = "container_number")
	private WebElement containerNumberElement;

	public void enterContainerNumber(String containerNumber) {
		wait.forElementToBeDisplayed(containerNumberElement);
		containerNumberElement.sendKeys(containerNumber);
	}

	@FindBy(id = "tractor_number")
	private WebElement tractorNumberElement;

	public void enterTractorNumber(String tractorNumber) {
		wait.forElementToBeDisplayed(tractorNumberElement);
		tractorNumberElement.sendKeys(tractorNumber);
	}

	@FindBy(id = "trailer_number")
	private WebElement trailerNumberElement;

	public void enterTrailerNumber(String trailerNumber) {
		wait.forElementToBeDisplayed(trailerNumberElement);
		trailerNumberElement.sendKeys(trailerNumber);
	}

	@FindBy(xpath = "//*[@id='s2id_event_iep_id']/a")
	private WebElement openequipmentProvider;
	@FindBy(xpath = "//div[@id='select2-drop']//input[@role='combobox']")
	private WebElement equipmentProviderSearchBox;
	@FindBy(xpath = "//*[@class='select2-results']/li[1]/div")
	private WebElement clickEquipmentProvider;

	public void selectEquipmentProvider(String equipmentProvider) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		wait.forElementToBeDisplayed(openequipmentProvider);
		openequipmentProvider.click();
		wait.forElementToBeDisplayed(equipmentProviderSearchBox);
		equipmentProviderSearchBox.sendKeys(equipmentProvider);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wait.forElementToBeDisplayed(clickEquipmentProvider);
		clickEquipmentProvider.click();
	}

	@FindBy(id = "incident_associated_trailer_number")
	private WebElement associatedTrailerNumber;

	public void associatedTrailerNumber(String associateTrailerNumber) {
		wait.forElementToBeDisplayed(associatedTrailerNumber);
		associatedTrailerNumber.sendKeys(associateTrailerNumber);
	}

	@FindBy(id = "vehicle_type_color")
	private WebElement vehicleTypeColor;

	public void enterVehicleTypeColor(String vehicleTypeColorStr) {
		wait.forElementToBeDisplayed(vehicleTypeColor);
		vehicleTypeColor.sendKeys(vehicleTypeColorStr);
	}

	@FindBy(id = "incident_associated_chassis_number")
	private WebElement associatedChassisNumber;

	public void associatedChassisNumber(String associateChassisNumber) {
		wait.forElementToBeDisplayed(associatedChassisNumber);
		associatedChassisNumber.sendKeys(associateChassisNumber);
	}

	@FindBy(id = "incident_associated_tractor_number")
	private WebElement associatedTractorNumber;

	public void associatedTractorNumber(String associateTractorNumber) {
		wait.forElementToBeDisplayed(associatedTractorNumber);
		associatedTractorNumber.sendKeys(associateTractorNumber);
	}

	@FindBy(id = "incident_associated_container_number")
	private WebElement associatedContainerNumber;

	public void associatedContainerNumber(String associateContainerNumber) {
		wait.forElementToBeDisplayed(associatedContainerNumber);
		associatedContainerNumber.sendKeys(associateContainerNumber);
	}

	@FindBy(xpath = "//*[@id='s2id_event_driver_id']/a")
	private WebElement driverElement;
	@FindBy(xpath = "//div[@id='select2-drop']//input[@role='combobox']")
	private WebElement searchDriver;
	@FindBy(xpath = "//*[@class='select2-results']/li[1]/div")
	private WebElement clickDriver;

	public void selectDriver(String driver) {
		wait.forElementToBeDisplayed(driverElement);
		driverElement.click();
		searchDriver.sendKeys(driver);
		wait.forElementToBeDisplayed(clickDriver);
		clickDriver.click();
	}

	@FindBy(id = "event_driver_name")
	private WebElement driverName;

	public void enterDriverName(String driverNameStr) {
		wait.forElementToBeDisplayed(driverName);
		driverName.sendKeys(driverNameStr);
	}

	@FindBy(id = "event-save-as-draft")
	private WebElement saveDraft;

	public void clickSaveDraftButton() {
		wait.forElementToBeDisplayed(saveDraft);
		saveDraft.click();
	}

	@FindBy(id = "event_driver_phone")
	private WebElement driverPhone;

	public void enterDriverPhoneNumber(String driverPhoneNum) {
		wait.forElementToBeDisplayed(driverPhone);
		driverPhone.clear();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driverPhone.sendKeys(driverPhoneNum);
	}

	@FindBy(xpath = "//*[@id=\"header_info_tab\"]//label[@for=\"incident_loaded\"]//following::div[2]/div/label[1]")
	private WebElement eventLoadedTrue;
	@FindBy(xpath = "//*[@id=\\\"header_info_tab\\\"]//label[@for=\\\"incident_loaded\\\"]//following::div[2]/div/label[2]")
	private WebElement eventLoadedFalse;

	public void selectLoadedRadioButton(Boolean isLoaded) {

		if (isLoaded)
			eventLoadedTrue.click();
		else
			eventLoadedFalse.click();
	}

	@FindBy(xpath = "//*[@id=\"header_info_tab\"]/div/div[2]/div[2]/div/div[1]/div/label[1]")
	private WebElement driverWithUnitTrue;
	@FindBy(xpath = "(//label[@class='btn btn-blue btn-sm btn-outlined '])[4]")
	private WebElement driverWithUnitFalse;

	public void selectDriverWithUnitRadioButton(Boolean isDriverWithUnit) {

		if (isDriverWithUnit)
			driverWithUnitTrue.click();
		else
			driverWithUnitFalse.click();
	}

	@FindBy(xpath = "//*[@id=\"refrigerated\"]/div/div/div/label[1]")
	private WebElement refrigeratedTrue;
	@FindBy(xpath = "//*[@id=\"refrigerated\"]/div/div/div/label[2]")
	private WebElement refrigeratedFalse;

	public void selectRefrigeratedRadioButton(Boolean isRefrigerated) {

		if (isRefrigerated)
			refrigeratedTrue.click();
		else
			refrigeratedFalse.click();
	}

	@FindBy(id = "event_address")
	private WebElement eventAddress;

	public void enterAddress(String eventAddressString) {
		wait.forElementToBeDisplayed(eventAddress);
		eventAddress.sendKeys(eventAddressString);
	}

	@FindBy(id = "s2id_event_terminal_id")
	private WebElement terminalElement;
	@FindBy(xpath = "//div[@id='select2-drop']//input[@role='combobox']")
	private WebElement searchTerminal;
	@FindBy(xpath = "//*[@class='select2-results']/li[1]/div")
	private WebElement clickTerminal;

	public void selectTerminal(String terminal) {
		wait.forElementToBeDisplayed(terminalElement);
		terminalElement.click();
		searchTerminal.sendKeys(terminal);
		wait.forElementToBeDisplayed(clickTerminal);
		clickTerminal.click();
	}

	@FindBy(id = "incident_reference_work_order_number")
	private WebElement referenceNumElement;

	public void referenceNumber(String reference) {
		wait.forElementToBeDisplayed(referenceNumElement);
		referenceNumElement.sendKeys(reference);
	}

	@FindBy(id = "event_breakdown_notes")
	private WebElement breakdownNotes;

	public void breakdownNotes(String notes) {
		wait.forElementToBeDisplayed(breakdownNotes);
		breakdownNotes.sendKeys(notes);
	}

	@FindBy(id = "incident_event_comments_attributes_0_comment")
	private WebElement commentElement;

	public void comment(String comment) {
		wait.forElementToBeDisplayed(commentElement);
		commentElement.sendKeys(comment);
	}

	@FindBy(id = "event-add-service")
	private WebElement addServiceLine;

	public void addService() {
		addServiceLine.click();
	}

	@FindBy(xpath = "//*[@id=\"s2id_create_td_id\"]/a")
	private WebElement truckdispatchElement;
	@FindBy(xpath = "//div[@id='select2-drop']//input[@role='combobox']")
	private WebElement searchTruckDispatch;
	@FindBy(xpath = "//*[@class='select2-results']/li[1]/div")
	private WebElement clickTruckDispatch;

	public void selectTruckDispatch(String truckDispatch) {
		wait.forElementToBeDisplayed(truckdispatchElement);
		truckdispatchElement.click();
		wait.forElementToBeDisplayed(searchTruckDispatch);
		searchTruckDispatch.sendKeys(truckDispatch);
		wait.forElementToBeDisplayed(clickTruckDispatch);
		clickTruckDispatch.click();
	}

	@FindBy(xpath = "//*[@id='event_eta']")
	private WebElement eta;

	public void selectETA(String etaStr) {
		wait.forElementToBeDisplayed(eta);
		eta.sendKeys(etaStr);
	}

	@FindBy(id = "out_of_network")
	private WebElement outofNetwork;

	public void selectOutofNetwork() {
		outofNetwork.click();
	}

	@FindBy(xpath = "//*[@id=\"out_of_network_sc_form\"]//label[@for=\"recipient_name\"]//following::div/a/span[1]")
	private WebElement oonSCElement;
	@FindBy(xpath = "//div[@id='select2-drop']//input[@role='combobox']")
	private WebElement searchOONSC;
	@FindBy(xpath = "//*[@class='select2-results']/li[1]/div")
	private WebElement clickOONSC;

	public void selectOONSC(String oonsc) {
		wait.forElementToBeDisplayed(oonSCElement);
		oonSCElement.click();
		wait.forElementToBeDisplayed(searchOONSC);
		searchOONSC.sendKeys(oonsc);
		wait.forElementToBeDisplayed(clickOONSC);
		clickOONSC.click();
	}

	@FindBy(xpath = "//*[@id=\"out_of_network_sc_form\"]//label[@for=\"recipient_email\"]//following::input[1]")
	private WebElement oonScEmail;

	public void oonEmail(String oonEmail) {
		wait.forElementToBeDisplayed(oonScEmail);
		oonScEmail.sendKeys(oonEmail);
	}

	@FindBy(xpath = "//*[@id=\"out_of_network_sc_form\"]//label[@for=\"recipient_phone_\"]//following::input[1]")
	private WebElement oonScPH;

	public void oonPhone(String oonPhone) {
		wait.forElementToBeDisplayed(oonScPH);
		oonScPH.clear();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		oonScPH.sendKeys(oonPhone);
	}

	@FindBy(id = "address")
	private WebElement oonSCAddress;
	@FindBy(xpath = "//*[@class='select2-results']/li[1]/div")
	private WebElement clickoonSCAddress;

	public void oonAddress(String oonAddress) {
		wait.forElementToBeDisplayed(oonScPH);
		oonSCAddress.sendKeys(oonAddress);
	}

	@FindBy(xpath = "//*[@id='out_of_network_sc_form']/div[1]/div/div/div[5]/div/label/div/ins")
	private WebElement oonSCNotify;

	public void oonNotify() {
		wait.forElementToBeDisplayed(oonSCNotify);
		oonSCNotify.click();
	}

	@FindBy(id = "save_assign")
	private WebElement oonSCSave;

	public void oonSave() {
		wait.forElementToBeDisplayed(oonSCSave);
		oonSCSave.click();
	}

	@FindBy(id = "oon_next")
	private WebElement oonNext;

	public void oonNext() {
		wait.forElementToBeDisplayed(oonNext);
		oonNext.click();
	}

	@FindBy(xpath = "//*[@for='payment_method_id']//following::div//span[1]")
	private WebElement paymentMethod;
	@FindBy(xpath = "//div[@id='select2-drop']//input[@role='combobox']")
	private WebElement searchPaymentMethod;
	@FindBy(xpath = "//*[@class='select2-results']/li[1]//li/div")
	private WebElement clickPaymentMethod;

	public void selectoonPaymentMethod(String paymentMethodStr) {
		wait.forElementToBeDisplayed(paymentMethod);
		paymentMethod.click();
		searchPaymentMethod.sendKeys(paymentMethodStr);
		wait.forElementToBeDisplayed(clickPaymentMethod);
		clickPaymentMethod.click();
	}

	@FindBy(id = "advance_search_btn")
	private WebElement adSearch;

	public void clickAdSearchButton() {
		wait.forElementToBeDisplayed(adSearch);
		adSearch.click();
	}

	@FindBy(id = "add-walkin-ep")
	private WebElement walkin;

	public void clickWalkinButton() {
		wait.forElementToBeDisplayed(walkin);
		walkin.click();
	}
	
	@FindBy(id = "incident_walkin_iep_attributes_name")
	private WebElement walkinEPName;

	public void enterWalkinEPnames(String name) {
		wait.forElementToBeDisplayed(walkinEPName);
		walkinEPName.sendKeys(name);
	}
	
	@FindBy(id = "incident_walkin_iep_attributes_address")
	private WebElement walkinEPAdd;

	public void enterWalkinEPadd(String walkinaddress) {
		wait.forElementToBeDisplayed(walkinEPAdd);
		walkinEPAdd.sendKeys(walkinaddress);
	}
	
	@FindBy(id = "incident_walkin_iep_attributes_phone")
	private WebElement walkinEPPH;

	public void enterWalkinEPPH(String walkinPH) {
		wait.forElementToBeDisplayed(walkinEPPH);
		walkinEPPH.clear();
		walkinEPPH.sendKeys(walkinPH);
	}
	
	@FindBy(id = "fleet_name")
	private WebElement fleetName;

	public void enterFleetName(String fleetNameStr) {
		wait.forElementToBeDisplayed(fleetName);
		fleetName.sendKeys(fleetNameStr);
	}
	
	@FindBy(id = "email_address")
	private WebElement fleetEmail;

	public void enterFleetEmail(String fleetEmailStr) {
		wait.forElementToBeDisplayed(fleetEmail);
		fleetEmail.sendKeys(fleetEmailStr);
	}
	
	@FindBy(id = "tenant_phones_attributes_1_phone_number")
	private WebElement fleetPh;

	public void enterFleetPh(String fleetPhStr) {
		wait.forElementToBeDisplayed(fleetPh);
		fleetPh.clear();
		fleetPh.sendKeys(fleetPhStr);
	}
	
	@FindBy(id = "tenant_addresses_attributes_1_address")
	private WebElement fleetAddress;

	public void enterFleetAdd(String fleetPAddStr) {
		wait.forElementToBeDisplayed(fleetAddress);
		fleetAddress.sendKeys(fleetPAddStr);
	}
	
	@FindBy(id = "dot_number")
	private WebElement fleetDoT;

	public void enterFleetDOT(String fleetDOTStr) {
		wait.forElementToBeDisplayed(fleetDoT);
		fleetDoT.sendKeys(fleetDOTStr);
	}
	
	@FindBy(xpath = "//*[@for='timezone']//following::div//span[1]")
	private WebElement timeZone;
	@FindBy(xpath = "//div[@id='select2-drop']//input[@role='combobox']")
	private WebElement searchTimezone;
	@FindBy(xpath = "//*[@class='select2-results']/li[1]/div")
	private WebElement clickTimezone;

	public void selectTimeZone(String timezone) {
		wait.forElementToBeDisplayed(timeZone);
		timeZone.click();
		searchTimezone.sendKeys(timezone);
		wait.forElementToBeDisplayed(clickTimezone);
		clickTimezone.click();
	}
	
	
	@FindBy(xpath = "//*[@class='ep_srch_btn btn btn-green']")
	private WebElement search;

	public void clickSearchButton() {
		wait.forElementToBeDisplayed(search);
		search.click();
	}
	
	@FindBy(xpath = "//*[@class='create_fleet_btn btn btn-blue']")
	private WebElement create;

	public void clickcreateButton() {
		wait.forElementToBeDisplayed(create);
		create.click();
	}
	
	@FindBy(xpath = "//*[@type='submit' and text()='Create Fleet']")
	private WebElement create2;

	public void clickcreateButton2() {
		wait.forElementToBeDisplayed(create2);
		create2.click();
	}
	
	@FindBy(xpath = "//tbody/tr[@role='row'][1]//button[@name='button']")
	private WebElement select;

	public void selecteEP() {
		wait.forElementToBeDisplayed(select);
		select.click();
	}
	
	@FindBy(xpath = "//a[@href='#draft' and @data-toggle='tab']")
	private WebElement drafttab;
	
	public void selectdrafttab() {
		wait.forElementToBeDisplayed(drafttab);
		drafttab.click();
	}
	
	@FindBy(xpath = ("(//a[contains(text( ), 'AA')])[1]"))
	private WebElement Fetcheventid;
	
	
	public String extracteventid() {
		wait.forElementToBeDisplayed(Fetcheventid);
		String Drafteventid = Fetcheventid.getText();
		System.out.println(Drafteventid);
		return Drafteventid;
	}
	

	@FindBy(xpath = "//input[@class='form-control input-sm' and @type='search']")
	private WebElement searchbox;
	
	public void searchdraft(String Drafteventid) throws InterruptedException {
		wait.forElementToBeDisplayed(searchbox);
		searchbox.click();
		Thread.sleep(2000);
		searchbox.sendKeys(Drafteventid);
		wait.forLoading(); 
	}
	
	@FindBy(xpath = "(//a[contains(text( ), 'AA')])[2]")
	public WebElement eventnumber;
	
	public WebElement openevent() {
		wait.forElementToBeDisplayed(eventnumber);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", eventnumber);
	//	eventnumber.click();
		return eventnumber;
	}
	
	@FindBy(xpath = "(//a[@class='btn btn-green btn-xs'])[1]")
	public WebElement Edit;

	public void action() {
		wait.forLoading();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", Edit);

	}
	
	
	@FindBy(xpath = "//a[@class='btn btn-danger' and @data-method='delete']")
	private WebElement btndelete;
	
	public void deleteevent() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", btndelete);
		js.executeScript("arguments[0].click();", btndelete);
	//	wait.forElementToBeDisplayed(btndelete);

	}
		
	@FindBy(xpath = "//p[contains(text( ), 'You are about')]")
	private WebElement Warningmsg;

	@FindBy(xpath = "//button[@class='confirm']")
	private WebElement okbtn;

	public void klickokwarningpopup() throws InterruptedException {

		Set<String> windowHandles = driver.getWindowHandles();
		int c = 0;
		for (String x : windowHandles) {
			if (c==1) {
				System.out.println(x);
				driver.switchTo().window(x);
			}					
		}
		wait.forElementToBeDisplayed(Warningmsg);
		String m = Warningmsg.getText();
		System.out.println(m);
		Thread.sleep(2000);
		wait.forElementToBeDisplayed(okbtn);
		okbtn.click();	
		wait.forLoading();

	}
	
	@FindBy(xpath = "//input[@class='form-control input-sm' and @type='search']")
	private WebElement searchbox2;

	public void remove() throws InterruptedException, AWTException {
		wait.forElementToBeDisplayed(searchbox2);
		searchbox2.click();
		Thread.sleep(2000);
		searchbox2.clear();
		Thread.sleep(2000);				
		Robot r = new Robot();		
		searchbox2.click();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	@FindBy(xpath = "//div[@class='page-title' and contains(text( ), Edit)]")
	private WebElement edit;
	
	public String EditTitle() {
		wait.forElementToBeDisplayed(edit);
		String text = edit.getText();
		System.out.println(text);
		return text;
	}

}
