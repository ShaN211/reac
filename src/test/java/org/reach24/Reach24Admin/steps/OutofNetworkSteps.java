package org.reach24.Reach24Admin.steps;

import org.reach24.Reach24Admin.models.CommonVariables;
import org.reach24.Reach24Admin.pages.EventCreationPage;
import org.reach24.Reach24Admin.pages.EventInfoPage;
import org.reach24.Reach24Admin.pages.EventServicesPage;
import org.reach24.Reach24Admin.util.BasePage;
import org.reach24.Reach24Admin.util.ReusableMethods;

public class OutofNetworkSteps extends BasePage {
	EventInfoPage eventInfoPage = new EventInfoPage(driver);
	EventCreationPage eventCreationPage = new EventCreationPage(driver);
	EventServicesPage eventServicePage = new EventServicesPage(driver);
	ReusableMethods reuseCode = new ReusableMethods();
	String oonsc = reuseCode.randomServiceCenterName(3).toUpperCase();
	String oonPh = reuseCode.randomAlphaNumericName(0, 10);
	String oonscEmail = reuseCode.randomServiceCenterEmail(2);
	public void assignEventToOutofNetwork(String tenent, String payment) {
		eventInfoPage.clickFSC();
		eventCreationPage.selectOutofNetwork();
		eventCreationPage.selectOONSC(oonsc);
		eventCreationPage.oonEmail(oonscEmail);
		eventCreationPage.oonPhone(oonPh);
		eventCreationPage.oonAddress(CommonVariables.address);
		//eventCreationPage.oonNotify();
		eventCreationPage.oonPhone(oonPh);
		eventCreationPage.oonNext();
		if(payment.equalsIgnoreCase("yes")) {
			eventCreationPage.selectoonPaymentMethod("Cash");
			eventCreationPage.oonSave();
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
