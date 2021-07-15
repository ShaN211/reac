package org.reach24.Reach24Admin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.reach24.Reach24Admin.util.PropsReader;

public class SuperAdminLoginPage {

	WebDriver driver;
	PropsReader propsReader = new PropsReader();
	
	public SuperAdminLoginPage(WebDriver driver) {
		this.driver = driver;
		 PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="admin_user_email")
	private WebElement userName;
	public void enterUserName() {
		userName.clear();
		userName.sendKeys(PropsReader.superAdminUserName);
	}
	
	@FindBy(id="admin_user_password")
	private WebElement password;
	public void enterPassword() {
		password.clear();
		password.sendKeys(PropsReader.superAdminPassword);
	}
	
	@FindBy(xpath="//*[@id=\'new_admin_user\']/div[3]/div/div/ins")
	private WebElement rememberMe;
	public void clickRememberMeCheckBox() {
		rememberMe.click();
	}
	
	@FindBy(xpath="//*[@id=\'new_admin_user\']/div[4]/button")
	private WebElement login;
	public void clickLoginButton() {
		login.click();
	}
	
}
