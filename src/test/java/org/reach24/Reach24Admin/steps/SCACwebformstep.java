package org.reach24.Reach24Admin.steps;

import java.awt.AWTException;
import java.util.List;
import java.util.Map;

import org.reach24.Reach24Admin.pages.WebformPage;
import org.reach24.Reach24Admin.util.BasePage;
import org.reach24.Reach24Admin.util.ReusableMethods;

import io.cucumber.datatable.DataTable;

public class SCACwebformstep extends BasePage {
	
	String bsWebFormUrl = "https://bscallcenter.testing.service-request.reach24.net/";
	String dcliWebFormUrl = "https://dcli-cc.testing.service-request.reach24.net/";
	WebformPage webForm = new WebformPage(driver);
	String fleetName;
	String equipmentType;
	String SCcode;
	ReusableMethods reuseCode = new ReusableMethods();

	public void createEvent(String company, DataTable eventData) throws AWTException, InterruptedException {
		List<Map<String, String>> list = eventData.asMaps(String.class, String.class);
		
		SCcode = list.get(0).get("SCACcode");
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
			webForm.enterNewdcliFleetSAC(SCcode);
			webForm.enterNewFleetName(reuseCode.randomAlphaNumericName(5, 0));
			webForm.enterNewFleetAdd("San Francisco");			
			webForm.enterNewFleetPH("4586325662");
			webForm.clickNext();
		} else if (company.equalsIgnoreCase("BS")) {
			driver.get(bsWebFormUrl);
			webForm.selectEnvironment();
			Thread.sleep(2000);
			webForm.selectCusAccOption();
			webForm.enternewbsfleetsac(SCcode);
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

}