package org.reach24.Reach24Admin.steps;

import java.util.List;
import java.util.Map;

import org.reach24.Reach24Admin.actions.JSactions;
import org.reach24.Reach24Admin.models.CommonVariables;
import org.reach24.Reach24Admin.pages.TenantCreationPage;
import org.reach24.Reach24Admin.util.BasePage;
import org.reach24.Reach24Admin.util.PropsReader;

import io.cucumber.datatable.DataTable;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class TenantCreationSteps extends BasePage {

	PropsReader propsReader = new PropsReader();
	JSactions jsAction = new JSactions();
	TenantCreationPage tenantPage = new TenantCreationPage(driver);

	public void createTenant(DataTable tenantData) {
		List<Map<String, String>> list = tenantData.asMaps(String.class, String.class);

		driver.get(PropsReader.tenantCreatePage);

		tenantPage.enterTenantName(CommonVariables.tenandName);
		tenantPage.enterTenantAliseName(CommonVariables.tenandAliceName);
		tenantPage.enterTenanturl(CommonVariables.tenandName.toLowerCase());
		tenantPage.enterTenantDescription(CommonVariables.description);

		String tenantType = list.get(0).get("TenantType");
		switch (tenantType) {
		case "TD":
			tenantPage.checkTD();
			break;

		case "SC":
			tenantPage.checkSC();
			break;

		case "CC":
			tenantPage.checkSC();
			tenantPage.checkCC();
			break;

		case "TM":
			tenantPage.checkTireManufacturer();
			break;

		case "TD~IEP":
			tenantPage.checkTD();
			tenantPage.checkEP();
			break;

		case "SC~TM":
			tenantPage.checkSC();
			tenantPage.checkTireManufacturer();
			break;

		default:
			Assert.fail("Invalid Tanent type");
			break;

		}
		// jsAction.enterTextInTextBox("//*[@id='select2-chosen-1']", "(GMT-09:00)
		// Alaska");
		tenantPage.enterTimeZone();
	}

}
