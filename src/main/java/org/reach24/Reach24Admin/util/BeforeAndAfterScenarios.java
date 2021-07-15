package org.reach24.Reach24Admin.util;

import org.openqa.selenium.WebDriver;
import org.reach24.Reach24Admin.pages.SuperAdminLoginPage;
import org.reach24.Reach24Admin.pages.TenantLoginPage;
import org.reach24.Reach24Admin.pages.TenantLogoutPage;

public class BeforeAndAfterScenarios  extends BasePage{

	
	PropsReader propsReader = new PropsReader();
	TenantLoginPage tenantLoginPage = new TenantLoginPage(driver);
    TenantLogoutPage tenantLogoutPage = new TenantLogoutPage(driver);
	
	public void loginTenant(String tenantType) {
		
		
		
		
		try {
			switch (tenantType) {
  
			case "TD":
				driver.get(PropsReader.tdURL);
				tenantLoginPage.enterUserName(PropsReader.tdUserName);
				tenantLoginPage.enterPassword(PropsReader.tdPassword);
				tenantLoginPage.checkRememberMe();
				tenantLoginPage.clickLoginButton();
				break;
				
			case "TD1":
				driver.get(PropsReader.td1URL);
				tenantLoginPage.enterUserName(PropsReader.td1UserName);
				tenantLoginPage.enterPassword(PropsReader.td1Password);
				tenantLoginPage.checkRememberMe();
				tenantLoginPage.clickLoginButton();
				break;
				
			case "TD2":
				driver.get(PropsReader.td2URL);
				tenantLoginPage.enterUserName(PropsReader.td2UserName);
				tenantLoginPage.enterPassword(PropsReader.td2Password);
				tenantLoginPage.checkRememberMe();
				tenantLoginPage.clickLoginButton();
				break;
				
			case "TD3":
				driver.get(PropsReader.td3URL);
				tenantLoginPage.enterUserName(PropsReader.td3UserName);
				tenantLoginPage.enterPassword(PropsReader.td3Password);
				tenantLoginPage.checkRememberMe();
				tenantLoginPage.clickLoginButton();
				break;
				
			case "Amazon":
				driver.get(PropsReader.amazonURL);
				tenantLoginPage.enterUserName(PropsReader.amazonUserName);
				tenantLoginPage.enterPassword(PropsReader.amazonPassword);
				tenantLoginPage.checkRememberMe();
				tenantLoginPage.clickLoginButton();
				break;

			case "SP":
				driver.get(PropsReader.spURL);
				
				tenantLoginPage.enterUserName(PropsReader.spUserName);
				tenantLoginPage.enterPassword(PropsReader.spPassword);
				tenantLoginPage.checkRememberMe();
				tenantLoginPage.clickLoginButton();
				break;
				
			case "SP2":
			    driver.get(PropsReader.sp2URL);
			   tenantLoginPage.enterUserName(PropsReader.sp2UserName);
			   tenantLoginPage.enterPassword(PropsReader.sp2Password);
			   tenantLoginPage.checkRememberMe();
			   tenantLoginPage.clickLoginButton();
			   break;
			   
			case "CC":
				driver.get(PropsReader.ccURL);
				tenantLoginPage.enterUserName(PropsReader.ccUserName);
				tenantLoginPage.enterPassword(PropsReader.ccPassword);
				tenantLoginPage.checkRememberMe();
				tenantLoginPage.clickLoginButton();
				break;

							
			case "SCTech":
				driver.get(PropsReader.sctechURL);
				tenantLoginPage.enterUserName(PropsReader.sctechUserName);
				tenantLoginPage.enterPassword(PropsReader.sctechPassword);
				tenantLoginPage.checkRememberMe();
				tenantLoginPage.clickLoginButton();
				break;

			default:
				throw new Reach24AutomationCustomException("Invalid tenant login");
			
				
			}
		} catch (Reach24AutomationCustomException e) {
			e.printStackTrace();
		}
		
	}

   
    public void logoutTenant(String tenantType) {
    	
    	try {
    		switch(tenantType) {
    		case "SP":
    			driver.get(PropsReader.spURL);
			    tenantLogoutPage.sclogout();
			    break;
			/*case "CC":
				driver.get(PropsReader.ccURL);
				tenantLogoutPage.clickLogoutButton();
				break;*/
				
			case "SCTech" :
				driver.get(PropsReader.sctechURL);
				tenantLogoutPage.techlogout();
				break;
				
			default:
				throw new Reach24AutomationCustomException("Invalid tenant logout");
    		}
    		
    	}catch (Reach24AutomationCustomException e) {
			e.printStackTrace();
		}
    	
    	
    }
    
	public void loginSuperAdmin(WebDriver driver) {

		SuperAdminLoginPage superAdminloginPage = new SuperAdminLoginPage(driver);
		
		driver.get(PropsReader.adminUrl);

		superAdminloginPage.enterUserName();
		superAdminloginPage.enterPassword();
		superAdminloginPage.clickRememberMeCheckBox();
		superAdminloginPage.clickLoginButton();

	}
}
