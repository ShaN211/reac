package org.reach24.Reach24Admin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.reach24.Reach24Admin.util.PropsReader;
import org.reach24.Reach24Admin.util.Wait;

public class TenantLogoutPage {
	WebDriver driver;
	PropsReader propsReader = new PropsReader();
	Wait wait;
	
	public TenantLogoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new Wait(driver);
	}
	
	@FindBy(xpath="//*[@id='topbar']/div[2]/ul/li[2]/a/span[2]")
	private WebElement logoutDropdown;
	@FindBy(xpath="//*[@id='topbar']/div[2]/ul/li[2]/ul/li[9]/a")  
	private WebElement clickLogout;
	
	public void sclogout() {
		wait.forElementToBeDisplayed(logoutDropdown);
		logoutDropdown.click();
		wait.forElementToBeDisplayed(clickLogout);
		clickLogout.click();
	}
	
	@FindBy(xpath="//*[@id='topbar']/div[2]/ul/li[2]/a/span[2]")
	private WebElement logoutdrop;
	@FindBy(xpath="//*[@id='topbar']/div[2]/ul/li[2]/ul/li[6]/a")
	private WebElement logoutbutton;
	
	public void techlogout() {
		wait.forElementToBeDisplayed(logoutdrop);
		logoutdrop.click();
		wait.forElementToBeDisplayed(logoutbutton);
		logoutbutton.click();
	}
	
	
	
}
