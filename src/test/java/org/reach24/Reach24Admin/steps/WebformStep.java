package org.reach24.Reach24Admin.steps;

import java.awt.AWTException;
import java.util.List;
import java.util.Map;

import org.reach24.Reach24Admin.pages.WebformPage;
import org.reach24.Reach24Admin.util.BasePage;
import org.reach24.Reach24Admin.util.ReusableMethods;

import io.cucumber.datatable.DataTable;

public class WebformStep extends BasePage {
	String bsWebFormUrl = "https://bscallcenter.testing.service-request.reach24.net/";
	String dcliWebFormUrl = "https://dcli-cc.testing.service-request.reach24.net/";
	WebformPage webForm = new WebformPage(driver);
	String fleetName;
	String equipmentType;
	ReusableMethods reuseCode = new ReusableMethods();

	public void createEvent(String company, DataTable eventData) throws AWTException {
		List<Map<String, String>> list = eventData.asMaps(String.class, String.class);

		fleetName = list.get(0).get("EquipmentProvider");
		equipmentType = list.get(0).get("EquipmentType");
		String equNumber = reuseCode.randomAlphaNumericName(4, 6).toUpperCase();
		String chassisNumber = reuseCode.randomAlphaNumericName(4, 6).toUpperCase();
		String containerNumber = reuseCode.randomAlphaNumericName(4, 6).toUpperCase();
		String tractorNumber = reuseCode.randomAlphaNumericName(4, 6).toUpperCase();
		String trailerNumber = reuseCode.randomAlphaNumericName(4, 6).toUpperCase();

		if (company.equalsIgnoreCase("DCLI")) {
			driver.get(dcliWebFormUrl);
			webForm.selectEnvironment();
			webForm.selectStart();
			webForm.enterNewFleetName(reuseCode.randomAlphaNumericName(5, 0));
			webForm.enterNewFleetAdd("San Francisco");
			webForm.enterNewdcliFleetSAC(reuseCode.randomAlphaNumericName(0, 4));
			webForm.enterNewFleetPH("4586325662");
			webForm.clickNext();
			
		} else if (company.equalsIgnoreCase("BS")) {
			driver.get(bsWebFormUrl);
			webForm.selectEnvironment();
			webForm.selectCusAccOption();
			webForm.enterFleetName(fleetName);
			webForm.enterNewFleetName();
			wait.forLoading();
			webForm.confirmfleet();
			webForm.selectEquipmentType(equipmentType);
		}
		
		webForm.selectEquipmentNum(equNumber);

		switch (equipmentType.toLowerCase()) {

		case "chassis":
			webForm.selectAssociatedContainer(containerNumber);
			if (company.equalsIgnoreCase("BS")) {
				webForm.selectAssociatedPowerUnit(tractorNumber);
			}

			break;
		case "container":
			webForm.selectAssociatedChassis(chassisNumber);
			if (company.equalsIgnoreCase("BS")) {
				webForm.selectAssociatedPowerUnit(tractorNumber);
			}
			break;

		case "power unit":
			webForm.selectAssociatedChassis(chassisNumber);
			webForm.selectAssociatedContainer(containerNumber);
			webForm.selectAssociatedTrailer(trailerNumber);
			break;

		case "trailer":
			webForm.selectAssociatedPowerUnit(tractorNumber);
			break;
		}

		webForm.selectLocation();
		webForm.clickNext();

	}

	public void enterServiceData(DataTable serviceData) {
		List<Map<String, String>> list = serviceData.asMaps(String.class, String.class);
		equipmentType = list.get(0).get("EquipmentType");
		String system = list.get(0).get("System");
		String subSystem = list.get(0).get("SubSystem");
		String assembly = list.get(0).get("Assembly");
		String service = list.get(0).get("Service");

		switch (equipmentType.toLowerCase()) {

		case "chassis":
			webForm.selectSystem(system);
			webForm.selectSubSystem(subSystem);
			webForm.selectService(service);
			break;
		case "container":
			webForm.selectSystem(system);
			webForm.selectSubSystem(subSystem);
			webForm.selectService(service);
			break;

		case "power unit":
			webForm.selectSystem(system);
			webForm.selectAssembly(assembly);
			break;

		case "trailer":

			webForm.selectSystem(system);
			webForm.selectAssembly(assembly);
			break;
		}

		webForm.clickNext();
	}

	public void enterPaymantDetails(String paymentMethod) {
		webForm.enterPayment(paymentMethod);
		webForm.clickNext();
	}

	public void enterDriverInfo() {
		webForm.selectEnterDriverName("Test");
		webForm.selectEnterDriverPhone("12365489632");
		webForm.enterNotification();

		webForm.clickSubmit();
	}

	public void verification() {
		webForm.verifyMsg();
	}
	
	public void Done() {
		webForm.Done();
	
	}

}
