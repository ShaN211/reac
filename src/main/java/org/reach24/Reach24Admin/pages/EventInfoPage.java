package org.reach24.Reach24Admin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.reach24.Reach24Admin.util.PropsReader;
import org.reach24.Reach24Admin.util.Wait;

public class EventInfoPage {

	WebDriver driver;
	PropsReader propsReader = new PropsReader();
	Wait wait;

	public EventInfoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new Wait(driver);
	}

	public String getEventInfo(String eventData) {
		String eventInfo = "//*[@id='header_info_tab']//label[contains(text(),'" + eventData
				+ "')]//following-sibling::p";
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return driver.findElement(By.xpath(eventInfo)).getText();
	}

	public String getEI_EventInfo(String eventData) {
		String eventInfo = "//*[@id='event-info-panel']//label[contains(text(),'" + eventData
				+ "')]//following-sibling::p";
		return driver.findElement(By.xpath(eventInfo)).getText();
	}

	public String getAlphaNumEventId() {
		String eventInfo = "//*[@id=\"event-info-tab\"]/ul/li[1]/a/div";
		System.out.println(driver.findElement(By.xpath(eventInfo)).getText().replace("  ", ""));
		return driver.findElement(By.xpath(eventInfo)).getText().replace("  ", "");
	}

	public String getAlphaNumEI_EventId() {
		String eventInfo = "//*[@id='title-breadcrumb-option-demo']/ol/a[2]";
		return driver.findElement(By.xpath(eventInfo)).getText();
	}

	public String getEquipementType(String equipmentType) {
		String equipementInfo = "//*[@id=\"header_info_tab\"]//label[contains(text(),'" + equipmentType
				+ "') and not(contains(text(),'Associated'))]//following-sibling::p";
		try {
			return driver.findElement(By.xpath(equipementInfo)).getText();
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	public String getServicesInfo(String servicesData, int position) {
		String servicesInfo = "//div[(@class='panel')]//label[contains( text(), '" + servicesData
				+ "')]//following-sibling::p";
		return driver.findElements(By.xpath(servicesInfo)).get(position).getText();
	}

	public String getInspectionCategoriesInfo(String inspectionData) {
		String servicesInfo = "//label[contains(text(), '" + inspectionData + "')]//following::label[1]";
		return driver.findElement(By.xpath(servicesInfo)).getText();
	}

	@FindBy(xpath = "//*[@id='event-status-action-section']/div[1]/h3/a")
	private WebElement statusElement;

	public String getStatus() {
		wait.forElementToBeDisplayed(statusElement);
		return statusElement.getText();

	}

	@FindBy(xpath = "//*[@id='event-status-action-section']/div[1]/h3/a[2]")
	private WebElement statusElement2;

	public String getStatus2() {
		wait.forElementToBeDisplayed(statusElement2);
		return statusElement2.getText();

	}


	@FindBy(xpath = "//*[@id=\"event-status-action-section\"]/div[1]/div[3]/a")
	

	//*[text()='Test Tech']//following::div[@style='display: inline-block;padding-left:10px;vertical-align:top;']/a
	private WebElement techStatusElement;

	public String getTechStatus() {
		wait.forElementToBeDisplayed(techStatusElement);
		return techStatusElement.getText();
		
	}

	@FindBy(xpath = "//*[@class='find_service_center btn btn-green btn-sm']")
	private WebElement findServiceCenter;

	public void clickFSC() {
		wait.forElementToBeDisplayed(findServiceCenter);
		findServiceCenter.click();

	}

	@FindBy(xpath = "//div[@id='matching_service_centers']//input[@type='search']")
	private WebElement searchFSCElement;

	public void searchFSC(String sc) {
		wait.forElementToBeDisplayed(searchFSCElement);
		searchFSCElement.sendKeys(sc);
	}

	@FindBy(xpath = ".//*[contains(@id, 'fsc_sc_id')]")
	private WebElement assignSP;

	public void clickAssignSP() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assignSP.click();
	}

	public void statustabSwitch(String tabName) {
		String statusTab = "//*[@id='incidents-tab']//*[contains(@href,'" + tabName + "')]";
		driver.findElement(By.xpath(statusTab)).click();

	}

	@FindBy(xpath = "//*[@id='event-snapshot-datatable_filter']/label/div/input")
	private WebElement searchEventbox;
	@FindBy(xpath = "//*[@id='event-snapshot-datatable_wrapper']/div[2]/div[2]/div[2]/div/table/tbody/tr/td[1]/a")
	private WebElement clickonEventID;

	public void openEventInfoPage(String eventId) {
		wait.forElementToBeDisplayed(searchEventbox);
		searchEventbox.clear();
		searchEventbox.sendKeys(eventId);
		wait.forElementToBeDisplayed(clickonEventID);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clickonEventID.click();
	}

	@FindBy(xpath = "//*[@for='payment_method_id']//following::div//span[1]")
	private WebElement paymentMethod;
	@FindBy(xpath = "//div[@id='select2-drop']//input[@role='combobox']")
	private WebElement searchPaymentMethod;
	@FindBy(xpath = "//*[@class='select2-results']/li[1]//li/div")
	private WebElement clickPaymentMethod;

	public void selectPaymentMethod(String paymentMethodStr) {
		wait.forElementToBeDisplayed(paymentMethod);
		paymentMethod.click();
		searchPaymentMethod.sendKeys(paymentMethodStr);
		wait.forElementToBeDisplayed(clickPaymentMethod);
		clickPaymentMethod.click();
	}

	@FindBy(xpath = "//*[@for='payment_method']//following::div//span[1]")
	private WebElement amazonpaymentMethod;
	@FindBy(xpath = "//div[@id='select2-drop']//input[@role='combobox']")
	private WebElement amazonSearchPaymentMethod;
	@FindBy(xpath = "//*[@role=\"listbox\"]/li/div[@role='option']")
	private WebElement clickAmazonPaymentMethod;

	public void selectAmazonPaymentMethod(String paymentMethodStr) {
		wait.forElementToBeDisplayed(amazonpaymentMethod);
		amazonpaymentMethod.click();
		amazonSearchPaymentMethod.sendKeys(paymentMethodStr);
		wait.forElementToBeDisplayed(clickAmazonPaymentMethod);
		clickAmazonPaymentMethod.click();
	}

	@FindBy(xpath = "//*[@for='tire_manufacturer_id']//following::div//span[1]")
	private WebElement tireManufacturer;
	@FindBy(xpath = "//div[@id='select2-drop']//input[@role='combobox']")
	private WebElement searchiTreManufacturer;
	@FindBy(xpath = "//*[@class='select2-results']//div")
	private WebElement clickTireManufacturer;

	public void selectTireManufacturer(String paymentMethodStr) {
		wait.forElementToBeDisplayed(tireManufacturer);
		tireManufacturer.click();
		searchiTreManufacturer.sendKeys(paymentMethodStr);
		wait.forElementToBeDisplayed(clickTireManufacturer);
		clickTireManufacturer.click();
	}

	@FindBy(xpath = "//*[@id='save_assign']")
	private WebElement assign;

	public void saveAndAssign() {
		assign.click();
	}

	@FindBy(xpath = "//*[@id='pre_assign_modal']//span[text()='Select Reason' and starts-with(@id,select)]")
	private WebElement reassignpopup;
	@FindBy(xpath = "//div[@id='select2-drop']//input[@role='combobox']")
	private WebElement searchReassignReason;
	@FindBy(xpath = "//*[@class='select2-results']//div")
	private WebElement clickReassignReason;
	@FindBy(id = "accept_warning")
	private WebElement confirmReassign;

	public void reassignevent(String reassignreason) {
		wait.forElementToBeDisplayed(reassignpopup);
		reassignpopup.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		wait.forElementToBeDisplayed(searchReassignReason);
		searchReassignReason.sendKeys(reassignreason);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wait.forElementToBeDisplayed(clickReassignReason);
		clickReassignReason.click();
		wait.forElementToBeDisplayed(confirmReassign);
		confirmReassign.click();
	}

	@FindBy(xpath = "//h4[text()='Equipment Info']//following::label[@for='make']//following::div/a/span[1]")
	private WebElement eqInfoMake;
	@FindBy(xpath = "//div[@id='select2-drop']//input[@role='combobox']")
	private WebElement searchEqInfoMake;
	@FindBy(xpath = "//*[@class='select2-results']//div")
	private WebElement clickEqInfoMake;

	public void selectEquipmentInfoMake(String make) {
		wait.forElementToBeDisplayed(eqInfoMake);
		eqInfoMake.click();
		searchEqInfoMake.sendKeys(make);
		wait.forElementToBeDisplayed(clickEqInfoMake);
		clickEqInfoMake.click();
	}

	@FindBy(xpath = "//h4[text()='Associated Tractor Info']//following::label[@for='asc_make']//following::div/a/span[1]")
	private WebElement assoTractorInfoMake;
	@FindBy(xpath = "//div[@id='select2-drop']//input[@role='combobox']")
	private WebElement searchAssoTractorInfoMake;
	@FindBy(xpath = "//*[@class='select2-results']//div")
	private WebElement clickAssoTractorInfoMake;

	public void selectAssoTractorInfoMake(String make) {
		wait.forElementToBeDisplayed(assoTractorInfoMake);
		assoTractorInfoMake.click();
		searchAssoTractorInfoMake.sendKeys(make);
		wait.forElementToBeDisplayed(clickAssoTractorInfoMake);
		clickAssoTractorInfoMake.click();
	}

	@FindBy(xpath = "//h4[text()='Associated Tractor Info']//following::label[@for='asc_engine_make']//following::div/a/span[1]")
	private WebElement assoTractorInfoEngineMake;
	@FindBy(xpath = "//div[@id='select2-drop']//input[@role='combobox']")
	private WebElement searchAssoTractorInfoEngineMake;
	@FindBy(xpath = "//*[@class='select2-results']//div")
	private WebElement clickAssoTractorInfoEngineMake;

	public void selectAssoTractorInfoEngineMake(String make) {
		wait.forElementToBeDisplayed(assoTractorInfoEngineMake);
		assoTractorInfoEngineMake.click();
		searchAssoTractorInfoEngineMake.sendKeys(make);
		wait.forElementToBeDisplayed(clickAssoTractorInfoEngineMake);
		clickAssoTractorInfoEngineMake.click();
	}

	@FindBy(xpath = "//h4[text()='Equipment Info']//following::input[@id='equipment_model']")
	private WebElement eqInfoModel;

	public void enterEquipmentInfoModel(String model) {
		eqInfoModel.clear();
		eqInfoModel.sendKeys(model);
	}

	@FindBy(xpath = "//h4[text()='Associated Tractor Info']//following::input[@id='asc_equipment_model']")
	private WebElement assoTractorInfoModel;

	public void enterAssoTractorInfoModel(String model) {
		assoTractorInfoModel.clear();
		assoTractorInfoModel.sendKeys(model);
	}

	@FindBy(xpath = "//h4[text()='Equipment Info']//following::input[@id='equipment_year']")
	private WebElement eqInfoYear;

	public void enterEquipmentInfoYear(String year) {
		eqInfoYear.clear();
		eqInfoYear.sendKeys(year);
	}

	@FindBy(xpath = "//h4[text()='Associated Tractor Info']//following::input[@id='asc_equipment_year']")
	private WebElement assoTractorInfoYear;

	public void enterAssoTractorInfoYear(String year) {
		assoTractorInfoYear.clear();
		assoTractorInfoYear.sendKeys(year);
	}

	@FindBy(id = "eta")
	private WebElement etaDate;

	public void enterETA(String date) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wait.forElementToBeDisplayed(etaDate);
		etaDate.sendKeys(date);
	}

	@FindBy(id = "check-eta")
	private WebElement acceptButton;

	public void clickAcceptButton() {
		wait.forElementToBeDisplayed(acceptButton);
		acceptButton.click();
	}

	@FindBy(xpath = "//*[@id='complete-with-tire-man']/a")
	private WebElement completeButton;

	@FindBy(xpath = "//*[@id='fleet-profile-modal-body']/div[2]/div[2]/div/button[2]")
	private WebElement completePopup;

	public void clickCompleteButton() {
		wait.forElementToBeDisplayed(completeButton);
		completeButton.click();

		wait.forElementToBeDisplayed(completePopup);
		completePopup.click();
	}

	@FindBy(xpath = "//*[@id='complete-with-tire-man']/button")
	private WebElement completeAmazonButton;

	public void clickAmazonCompleteButton() {
		wait.forElementToBeDisplayed(completeAmazonButton);
		completeAmazonButton.click();

	}

	@FindBy(xpath = "//*[@id='event-approval-form']/button")
	private WebElement approveButton;

	public void clickApproveButton() {
		wait.forElementToBeDisplayed(approveButton);
		approveButton.click();
	}

	@FindBy(xpath = "//*[@id='event-status-action-section']/div[2]/button")
	private WebElement repairedButton;

	public void clickRepairedButton() {
		wait.forElementToBeDisplayed(repairedButton);
		repairedButton.click();
	}

	@FindBy(xpath = "//*[@id=\"reprocess-event-form\"]/button")
	private WebElement reprocessButton;

	public void clickReprocessButton() {
		wait.forElementToBeDisplayed(reprocessButton);
		reprocessButton.click();
	}

	@FindBy(xpath = "//*[@id='event-status-action-section']/div[2]/form[1]/div/button[1]")
	private WebElement estimateButton;

	public void clickEstimateButton() {
		wait.forElementToBeDisplayed(estimateButton);
		estimateButton.click();
	}
	
	@FindBy(xpath = "//*[@id='approve-estimate-button']/a[1]")
	private WebElement approveEstimateButton;

	@FindBy(xpath = "//*[@value='Approve Estimate']")
	private WebElement approveEstimate;
	
	public void approveEstimate() {
		wait.forElementToBeDisplayed(approveEstimateButton);
		approveEstimateButton.click();
		
		wait.forElementToBeDisplayed(approveEstimate);
		approveEstimate.click();
		
		
	}

	@FindBy(xpath = "//*[@id='event-status-action-section']/div[2]/a/button")
	private WebElement findEstimateButton;

	public void clickFindEstimateButton() {
		wait.forElementToBeDisplayed(findEstimateButton);
		findEstimateButton.click();
	}

	@FindBy(xpath = "//*[@name='event_estimate[total_discount_amt]']")
	private WebElement discount;
	@FindBy(xpath = "//*[@name='event_estimate[total_taxable_amt]']")
	private WebElement taxable;
	@FindBy(xpath = "//*[@name='event_estimate[total_non_taxable_amt]']")
	private WebElement nonTaxable;
	@FindBy(xpath = "//*[@name='event_estimate[total_tax_amt]']")
	private WebElement tax;
	@FindBy(xpath = "//*[@name='event_estimate[total_parts_amt]']")
	private WebElement parts;
	@FindBy(xpath = "//*[@name='event_estimate[total_labor_amt]']")
	private WebElement labour;
	@FindBy(xpath = "//*[@name='event_estimate[total_oil_amt]']")
	private WebElement oil;
	@FindBy(xpath = "//*[@name='event_estimate[new_tires_total_amt]']")
	private WebElement newTire;
	@FindBy(xpath = "//*[@name='event_estimate[used_tires_total_amt]']")
	private WebElement usedTire;
	@FindBy(xpath = "//*[@name='event_estimate[trade_in_amt]']")
	private WebElement tradeIn;
	@FindBy(xpath = "//*[@name='event_estimate[sublet_amt]']")
	private WebElement sublet;
	@FindBy(xpath = "//*[@name='event_estimate[road_call_amt]']")
	private WebElement roadCall;
	@FindBy(xpath = "//*[@name='event_estimate[env_waste_tax_amt]']")
	private WebElement envWasteTax;

	public void enterValueForEstimates(String field, String value) {
		if (field.equalsIgnoreCase("Discount")) {
			wait.forElementToBeDisplayed(discount);
			discount.clear();
			discount.sendKeys(value);
		} else if (field.equalsIgnoreCase("Taxable")) {
			wait.forElementToBeDisplayed(taxable);
			taxable.clear();
			taxable.sendKeys(value);
		} else if (field.equalsIgnoreCase("NonTaxable")) {
			wait.forElementToBeDisplayed(nonTaxable);
			nonTaxable.clear();
			nonTaxable.sendKeys(value);
		} else if (field.equalsIgnoreCase("Tax")) {
			wait.forElementToBeDisplayed(tax);
			tax.clear();
			tax.sendKeys(value);
		} else if (field.equalsIgnoreCase("Parts")) {
			wait.forElementToBeDisplayed(parts);
			parts.clear();
			parts.sendKeys(value);
		} else if (field.equalsIgnoreCase("Labor")) {
			wait.forElementToBeDisplayed(labour);
			labour.clear();
			labour.sendKeys(value);
		} else if (field.equalsIgnoreCase("Oil")) {
			wait.forElementToBeDisplayed(oil);
			oil.clear();
			oil.sendKeys(value);
		} else if (field.equalsIgnoreCase("NewTires")) {
			wait.forElementToBeDisplayed(newTire);
			newTire.clear();
			newTire.sendKeys(value);
		} else if (field.equalsIgnoreCase("UsedTires")) {
			wait.forElementToBeDisplayed(usedTire);
			usedTire.clear();
			usedTire.sendKeys(value);
		} else if (field.equalsIgnoreCase("TradeIn")) {
			wait.forElementToBeDisplayed(tradeIn);
			tradeIn.clear();
			tradeIn.sendKeys(value);
		} else if (field.equalsIgnoreCase("Sublet")) {
			wait.forElementToBeDisplayed(sublet);
			sublet.clear();
			sublet.sendKeys(value);
		} else if (field.equalsIgnoreCase("RoadCall")) {
			wait.forElementToBeDisplayed(roadCall);
			roadCall.clear();
			roadCall.sendKeys(value);
		} else if (field.equalsIgnoreCase("EnvWasteTax")) {
			wait.forElementToBeDisplayed(envWasteTax);
			envWasteTax.clear();
			envWasteTax.sendKeys(value);
		}
	}

	@FindBy(xpath = "//*[@name='event_estimate[total_gross_amt]']")
	private WebElement totalGross;

	@FindBy(xpath = "//*[@name='event_estimate[total_net_amt]']")
	private WebElement totalNet;

	@FindBy(xpath = "//*[@name='event_estimate[est_total_amt]']")
	private WebElement estimated;

	public String getEstimates(String field) {
		String estimates = null;
		if (field.equalsIgnoreCase("totalGross")) {
			wait.forElementToBeDisplayed(totalGross);
			estimates = totalGross.getAttribute("value");
		} else if (field.equalsIgnoreCase("totalNet")) {
			wait.forElementToBeDisplayed(totalNet);
			estimates = totalNet.getAttribute("value");
		} else if (field.equalsIgnoreCase("estimated")) {
			wait.forElementToBeDisplayed(estimated);
			estimates = estimated.getAttribute("value");
		}
		return estimates;
	}
	
	@FindBy(xpath = "//*[@value='Submit Estimate']")
	private WebElement submitEstimates;

	public void clickSubmitEstimatesButton() {
		wait.forElementToBeDisplayed(submitEstimates);
		submitEstimates.click();
	}
	
	@FindBy(xpath = "//div[@class='modal-footer']/button[text()='Close']")
	private WebElement closeEstimates;

	public void clickCloseEstimatesButton() {
		wait.forElementToBeDisplayed(closeEstimates);
		closeEstimates.click();
	}
	
	@FindBy(xpath = "//*[@id='event-status-action-section']/div[2]/a/button")
	private WebElement reviewEstimates;

	public void clickReviewEstimatesButton() {
		wait.forElementToBeDisplayed(reviewEstimates);
		reviewEstimates.click();
	}
	
	@FindBy(xpath = "//a[@id = 'reject-estimate-button']")
	private WebElement rejectEstimates;
	
	@FindBy(xpath = "//div[@id='reject-estimate-button']/button")
	private WebElement rejectEstimatesPopup;
	
	@FindBy(xpath = "//div[@id='reject-estimate-button']/ul/li[1]/a")
	private WebElement selectReason;
	
	public void clickRejectEstimatesButton() {
		wait.forElementToBeDisplayed(rejectEstimates);
		rejectEstimates.click();
		
		wait.forElementToBeDisplayed(rejectEstimatesPopup);
		rejectEstimatesPopup.click();
		
		wait.forElementToBeDisplayed(selectReason);
		selectReason.click();
	}

	@FindBy(xpath = "//*[@id=\"event-status-action-section\"]/div[2]/form[2]/button")
	private WebElement rejectButton;

	public void clickRejectButton() {
		wait.forElementToBeDisplayed(rejectButton);
		rejectButton.click();
	}

	@FindBy(xpath = "//div[@id = 'rejectComfirmationPopUpModal']//span[text()='Please Select' and starts-with(@id,'select')]")
	private WebElement reasonToReject;
	@FindBy(xpath = "//div[@id='select2-drop']//input[@role='combobox']")
	private WebElement searchReason;
	@FindBy(xpath = "//*[@class='select2-results']/li[1]/div")
	private WebElement clickReason;

	@FindBy(id = "rejectCofirmationOk")
	private WebElement confirmation;

	public void selectReasonToReject(String reasonStr) {

		wait.forElementToBeDisplayed(reasonToReject);
		reasonToReject.click();
		wait.forElementToBeDisplayed(searchReason);
		searchReason.sendKeys(reasonStr);
		wait.forElementToBeDisplayed(clickReason);
		clickReason.click();
		wait.forElementToBeDisplayed(confirmation);
		confirmation.click();

	}

	@FindBy(id = "assign_tech_user")
	private WebElement assignUser;

	public void clickAssignUserButton() {
		wait.forElementToBeDisplayed(assignUser);
		assignUser.click();
	}

	@FindBy(xpath = "//*[@id='reassign-event-techy-modal']//span[text()='Please Select User' and starts-with(@id,'select')]")
	private WebElement assignToTech;
	@FindBy(xpath = "//div[@id='select2-drop']//input[@class='select2-input']")
	private WebElement searchTech;
	@FindBy(xpath = "//*[@class='select2-results']/li[1]/div")
	private WebElement selectTech;
	@FindBy(xpath = "//*[@id='reassign-event-form']/div/div/div[3]/button[2]")
	private WebElement assignTechConfirmation;

	public void selectTechnician(String technician) {

		wait.forElementToBeDisplayed(assignToTech);
		assignToTech.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// wait.forElementToBeDisplayed(searchTech);
		// searchTech.sendKeys(technician);
		wait.forElementToBeDisplayed(selectTech);
		selectTech.click();
		wait.forElementToBeDisplayed(assignTechConfirmation);
		assignTechConfirmation.click();
	}

	@FindBy(xpath = "//div[@class='sa-confirm-button-container']/button")
	private WebElement alertButton;

	public void acceptAlertButton() {
		wait.forElementToBeDisplayed(alertButton);
		alertButton.click();

	}

	@FindBy(xpath = "//h4[@id='reassign-event-techy-modal']//following::div[@class='modal-body']//span[text()='Please Select User' ]")
	private WebElement clickSelectTech;

	@FindBy(className = "dsp-tech-details")
	private WebElement techDetails;

	public void selectTechDropbox() {
		wait.forElementToBeDisplayed(clickSelectTech);
		clickSelectTech.click();
		wait.forElementToBeDisplayed(techDetails);
		techDetails.click();

	}

	@FindBy(xpath = "//button[text()='Assign Technician']")
	private WebElement assigntechButton;

	public void clickAssigntechButton() {
		wait.forElementToBeDisplayed(assigntechButton);
		assigntechButton.click();

	}

	@FindBy(xpath = "//*[@id='event-status-action-section']/div[2]/button[1]")
	private WebElement techAcceptButton;

	public void techAccept() {
		wait.forElementToBeDisplayed(techAcceptButton);
		techAcceptButton.click();
	}

	@FindBy(xpath = "//*[@id='event-status-action-section']/div[2]/div/i")
	private WebElement secondaryoption;
	@FindBy(xpath = "//*[@id='event-status-action-section']/div[2]/div/ul/li[1]")
	private WebElement techEnrouteButton;

	public void techEnroute() {
		wait.forElementToBeDisplayed(secondaryoption);
		secondaryoption.click();
		wait.forElementToBeDisplayed(techEnrouteButton);
		techEnrouteButton.click();
	}

	@FindBy(xpath = "//*[@id='event-status-action-section']/div[2]/button[1]")
	private WebElement techRepairButton;

	public void techRepair() {
		wait.forElementToBeDisplayed(techRepairButton);
		techRepairButton.click();
	}

	@FindBy(xpath = "//*[@id='event-status-action-section']/div[2]/div/i")
	private WebElement secondaryoptions;
	@FindBy(xpath = "//*[@id='event-status-action-section']/div[2]/div/ul/li")
	private WebElement techArrivedButton;
	@FindBy(id = "tech_arrived")
	private WebElement saveETC;

	public void techArrived() {
		wait.forElementToBeDisplayed(secondaryoptions);
		secondaryoptions.click();
		wait.forElementToBeDisplayed(techArrivedButton);
		techArrivedButton.click();
	}

	@FindBy(xpath = "//button[@class='btn btn-green tech-arrived' and text()= 'Proceed without ETC']")
	private WebElement etcPopUP;

	public void etcPOPUP() {
		wait.forElementToBeDisplayed(etcPopUP);
		etcPopUP.click();

	}

	@FindBy(xpath = "//*[@id='event-status-action-section']/div[2]/button[2]")
	private WebElement declineEvent;

	public void clickDeclineButton() {
		wait.forElementToBeDisplayed(declineEvent);
		declineEvent.click();
	}

	@FindBy(xpath = "//*[@id='techDeclineModal']//span[text()='Please Select'and starts-with(@id,'select')]")
	private WebElement declineReason;
	@FindBy(xpath = "//div[@id='select2-drop']//input[@role='combobox']")
	private WebElement searchDeclineReason;
	@FindBy(xpath = "//*[@class='select2-results']/li[1]/div")
	private WebElement selectDeclineReason;
	@FindBy(id = "validate_decline_reason")
	private WebElement confirmDeclineReason;

	public void declineReason(String declinereason) {
		wait.forElementToBeDisplayed(declineReason);
		declineReason.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		searchDeclineReason.sendKeys(declinereason);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		wait.forElementToBeDisplayed(selectDeclineReason);
		selectDeclineReason.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		wait.forElementToBeDisplayed(confirmDeclineReason);
		confirmDeclineReason.click();
	}

	@FindBy(xpath = "//*[@id='event-info-panel']//div[@class='pull-right']/a[1]")
	private WebElement editEvent;

	public void clickEditEvent() {

		wait.forElementToBeDisplayed(editEvent);
		editEvent.click();
	}

	@FindBy(id = "accept_warning")
	private WebElement confirmNPSP;
	@FindBy(id = "save_assign")
	private WebElement save;

	public void clickConfirmNPSP() {

		wait.forElementToBeDisplayed(confirmNPSP);
		confirmNPSP.click();
		wait.forElementToBeDisplayed(save);
		save.click();
	}

	@FindBy(xpath = "//div[@class='sa-confirm-button-container']/button")
	private WebElement npspAlertOk;

	public void clickAcceptNpspAlert() {

		wait.forElementToBeDisplayed(npspAlertOk);
		npspAlertOk.click();
	}

}
