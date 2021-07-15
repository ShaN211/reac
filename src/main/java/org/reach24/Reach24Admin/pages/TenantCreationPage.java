package org.reach24.Reach24Admin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.reach24.Reach24Admin.util.PropsReader;

public class TenantCreationPage {

	WebDriver driver;
	PropsReader propsReader = new PropsReader();
	
	public TenantCreationPage(WebDriver driver) {
		this.driver = driver;
		 PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="tenant_name")
	private WebElement tenantNameInput;
	public void enterTenantName(String tenantName) {
		tenantNameInput.clear();
		tenantNameInput.sendKeys(tenantName);
	}
	
	@FindBy(id="tenant_alias_name")
	private WebElement tenantAliasNameInput;
	public void enterTenantAliseName(String tenantAliseName) {
		tenantAliasNameInput.clear();
		tenantAliasNameInput.sendKeys(tenantAliseName);
	}
	
	@FindBy(id="tenant_subdomain")
	private WebElement tenanturlInput;
	public void enterTenanturl(String tenanturl) {
		tenanturlInput.clear();
		tenanturlInput.sendKeys(tenanturl);
	}
	
	@FindBy(id="tenant_description")
	private WebElement tenantDescriptionInput;
	public void enterTenantDescription(String tenantDescription) {
		tenantDescriptionInput.clear();
		tenantDescriptionInput.sendKeys(tenantDescription);
	}
	
	@FindBy(xpath="//*[@id='checkboxes']/div[1]/ins")
	private WebElement tenantType_TD;
	public void checkTD() {
		tenantType_TD.click();
	}
	
	@FindBy(xpath="//*[@id='checkboxes']/div[2]/ins")
	private WebElement tenantType_EP;
	public void checkEP() {
		tenantType_EP.click();
	}
	
	@FindBy(xpath="//*[@id='checkboxes']/div[3]/ins")
	private WebElement tenantType_SC;
	public void checkSC() {
		tenantType_SC.click();
	}
	
	@FindBy(xpath="//*[@id='sc_attributes_span']/div/ins")
	private WebElement tenantType_CC;
	public void checkCC() {
		tenantType_CC.click();
	}
	
	@FindBy(xpath="//*[@id='checkboxes']/div[4]/ins")
	private WebElement tenantType_Shipper;
	public void checkShipper() {
		tenantType_Shipper.click();
	}
	
	@FindBy(xpath="//*[@id='checkboxes']/div[5]/ins")
	private WebElement tenantType_tireManufacturer;
	public void checkTireManufacturer() {
		tenantType_tireManufacturer.click();
	}
	
	@FindBy(xpath="//*[@id='tab1-wizard-custom-circle']/div[7]/div/div/div/ins")
	private WebElement tenantType_Non_Participating;
	public void checkNonParticipating() {
		tenantType_Non_Participating.click();
	}
	
	//*[@id='s2id_tenant_timezone']/a
	@FindBy(xpath="//*[@id='select2-chosen-1']")
	private WebElement timeZone;
	public void enterTimeZone() {
		timeZone.click();
		//timeZone.sendKeys("(GMT-09:00) Alaska");
	}
	
}
