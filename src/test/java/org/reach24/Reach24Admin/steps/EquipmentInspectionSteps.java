package org.reach24.Reach24Admin.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.reach24.Reach24Admin.dtos.EventDetailsDTO;
import org.reach24.Reach24Admin.dtos.Services;
import org.reach24.Reach24Admin.helper.EventDtoHelper;
import org.reach24.Reach24Admin.models.CommonVariables;
import org.reach24.Reach24Admin.pages.DVIR_ReviewPage;
import org.reach24.Reach24Admin.pages.DashboardPage;
import org.reach24.Reach24Admin.pages.EI_EventCreationPage;
import org.reach24.Reach24Admin.pages.EventCreationPage;
import org.reach24.Reach24Admin.pages.EventInfoPage;
import org.reach24.Reach24Admin.pages.EventServicesPage;
import org.reach24.Reach24Admin.util.BasePage;
import org.reach24.Reach24Admin.util.PropsReader;
import org.reach24.Reach24Admin.util.Reach24AutomationCustomException;
import org.reach24.Reach24Admin.util.ReusableMethods;

import io.cucumber.datatable.DataTable;

public class EquipmentInspectionSteps extends BasePage {

	EI_EventCreationPage eiEventCreation = new EI_EventCreationPage(driver);

	EventDtoHelper eventHelper = new EventDtoHelper();
	EventCreationPage eventCreationPage = new EventCreationPage(driver);
	EventServicesPage eventServicePage = new EventServicesPage(driver);
	EventInfoPage eventInfoPage = new EventInfoPage(driver);
	DashboardPage dashboardPage = new DashboardPage(driver);
	DVIR_ReviewPage reviewPage = new DVIR_ReviewPage(driver);

	ReusableMethods reuseCode = new ReusableMethods();
	Services services = new Services();
	static int serviesCount;
	static String eventId;

	static EventDetailsDTO eventInfoFromCreation = new EventDetailsDTO();
	static EventDetailsDTO eventInfoFromTenant = new EventDetailsDTO();
	static EventDetailsDTO eventInfoFromDashboard = new EventDetailsDTO();

	String chassisNumber = reuseCode.randomAlphaNumericName(4, 6).toUpperCase();
	String containerNumber = reuseCode.randomAlphaNumericName(4, 6).toUpperCase();
	String tractorNumber = reuseCode.randomAlphaNumericName(4, 6).toUpperCase();
	String trailerNumber = reuseCode.randomAlphaNumericName(4, 6).toUpperCase();

	String associatedChassisNumber = reuseCode.randomAlphaNumericName(4, 6).toUpperCase();
	String associatedTrailerNumber = reuseCode.randomAlphaNumericName(4, 6).toUpperCase();
	String associatedTractorNumber = reuseCode.randomAlphaNumericName(4, 6).toUpperCase();
	String associatedContainerNumber = reuseCode.randomAlphaNumericName(4, 6).toUpperCase();
	String referenceNumber = reuseCode.randomAlphaNumericName(0, 7);

	String dvirNumber = null;

	boolean isDefectExist = false;

	public void createEIevent(String tenantType, DataTable eventData) {

		List<Map<String, String>> list = eventData.asMaps(String.class, String.class);
		String equipmentType = list.get(0).get("EquipmentType");
		String truckDispatch = list.get(0).get("TruckDispatch");
		String equipmentProvider = list.get(0).get("EquipmentProvider");
		String inspectionType = list.get(0).get("EquipmentInspection");

		try {
			switch (tenantType) {
			case "TD":
				driver.get(PropsReader.tdIECreateEventPage);
				break;
			case "SP":
				// driver.get(PropsReader.speventCreatePage);
				break;

			case "CC":
				// driver.get(PropsReader.cceventCreatePage);
				break;
			default:
				throw new Reach24AutomationCustomException("Invalid TD selected");

			}
		} catch (Reach24AutomationCustomException e) {
			e.printStackTrace();
		}
		eventCreationPage.selectEquipmentType(equipmentType);
		eventInfoFromCreation.setEquipmentType(equipmentType);

		try {
			switch (equipmentType.toLowerCase()) {
			case "chassis":
				if (list.get(0).get("chassisNumber") != null) {
					eventCreationPage.enterChassisNumber(list.get(0).get("chassisNumber"));
					eventInfoFromCreation.setChassisNumber(list.get(0).get("chassisNumber"));
				} else {
					eventCreationPage.enterChassisNumber(chassisNumber);
					eventInfoFromCreation.setChassisNumber(chassisNumber);
				}
				break;
			case "container":
				if (list.get(0).get("containerNumber") != null) {
					eventCreationPage.enterContainerNumber(list.get(0).get("containerNumber"));
					eventInfoFromCreation.setContainerNumber(list.get(0).get("containerNumber"));
				} else {
					eventCreationPage.enterContainerNumber(containerNumber);
					eventInfoFromCreation.setContainerNumber(containerNumber);
				}
				if (list.get(0).get("associatedTractorNumber") != null) {
					eventCreationPage.associatedTractorNumber(list.get(0).get("associatedTractorNumber"));
					eventInfoFromCreation.setAssociatedTractorNumber(list.get(0).get("associatedTractorNumber"));
				} else {
					eventCreationPage.associatedTractorNumber(associatedTractorNumber);
					eventInfoFromCreation.setAssociatedTractorNumber(associatedTractorNumber);
				}
				if (list.get(0).get("associatedChassisNumber") != null) {
					eventCreationPage.associatedChassisNumber(list.get(0).get("associatedChassisNumber"));
					eventInfoFromCreation.setAssociatedChassisNumber(list.get(0).get("associatedChassisNumber"));
				} else {
					eventCreationPage.associatedChassisNumber(associatedChassisNumber);
					eventInfoFromCreation.setAssociatedChassisNumber(associatedChassisNumber);
				}
				break;

			case "power unit":
				if (list.get(0).get("tractorNumber") != null) {
					eventCreationPage.enterTractorNumber(list.get(0).get("tractorNumber"));
					eventInfoFromCreation.setTractorNumber(list.get(0).get("tractorNumber"));
				} else {
					eventCreationPage.enterTractorNumber(tractorNumber);
					eventInfoFromCreation.setTractorNumber(tractorNumber);
				}
				if (list.get(0).get("associatedTrailerNumber") != null) {
					eventCreationPage.associatedTrailerNumber(list.get(0).get("associatedTrailerNumber"));
					eventInfoFromCreation.setAssociatedTrailerNumber(list.get(0).get("associatedTrailerNumber"));
				} else {
					eventCreationPage.associatedTrailerNumber(associatedTrailerNumber);
					eventInfoFromCreation.setAssociatedTrailerNumber(associatedTrailerNumber);
				}
				if (list.get(0).get("associatedChassisNumber") != null) {
					eventCreationPage.associatedChassisNumber(list.get(0).get("associatedChassisNumber"));
					eventInfoFromCreation.setAssociatedChassisNumber(list.get(0).get("associatedChassisNumber"));
				} else {
					eventCreationPage.associatedChassisNumber(associatedChassisNumber);
					eventInfoFromCreation.setAssociatedChassisNumber(associatedChassisNumber);
				}
				if (list.get(0).get("associatedContainerNumber") != null) {
					eventCreationPage.associatedContainerNumber(list.get(0).get("associatedContainerNumber"));
					eventInfoFromCreation.setAssociatedContainerNumber(list.get(0).get("associatedContainerNumber"));
				} else {
					eventCreationPage.associatedContainerNumber(associatedContainerNumber);
					eventInfoFromCreation.setAssociatedContainerNumber(associatedContainerNumber);
				}
				break;

			case "trailer":
				if (list.get(0).get("trailerNumber") != null) {
					eventCreationPage.enterTrailerNumber(list.get(0).get("trailerNumber"));
					eventInfoFromCreation.setTrailerNumber(list.get(0).get("trailerNumber"));
				} else {
					eventCreationPage.enterTrailerNumber(trailerNumber);
					eventInfoFromCreation.setTrailerNumber(trailerNumber);
				}
				if (list.get(0).get("associatedTractorNumber") != null) {
					eventCreationPage.associatedTractorNumber(list.get(0).get("associatedTractorNumber"));
					eventInfoFromCreation.setAssociatedTractorNumber(list.get(0).get("associatedTractorNumber"));
				} else {
					eventCreationPage.associatedTractorNumber(associatedTractorNumber);
					eventInfoFromCreation.setAssociatedTractorNumber(associatedTractorNumber);
				}
			default:
				throw new Reach24AutomationCustomException("Options not selected");

			}
		} catch (Reach24AutomationCustomException e) {
			e.printStackTrace();
		}
		eventCreationPage.selectEquipmentProvider(equipmentProvider);
		eventInfoFromCreation.setEquipmentProvider(equipmentProvider);

		eventCreationPage.enterVehicleTypeColor(CommonVariables.vehicleType + " " + CommonVariables.vehicleColor);

		switch (tenantType) {
		case "SP":
			eventCreationPage.selectTruckDispatch(truckDispatch);
			break;

		case "CC":
			eventCreationPage.selectTruckDispatch(truckDispatch);
			break;
		default:
			break;
		}
		eiEventCreation.referenceNumber(referenceNumber);
		eventInfoFromCreation.setreferenceNumber(referenceNumber);
		eventCreationPage.enterDriverName(CommonVariables.driverName);
		eventInfoFromCreation.setDriverName(CommonVariables.driverName);
		eventCreationPage.enterDriverPhoneNumber(CommonVariables.driverPhoneNumber);
		eventInfoFromCreation.setDriverPhoneNumber(CommonVariables.driverPhoneNumber);
		eiEventCreation.selectInspectionType(inspectionType);
		eventCreationPage.enterAddress(CommonVariables.address);
		eventInfoFromCreation.setAddress(CommonVariables.address);

		/*eventCreationPage.enterDriverPhoneNumber(CommonVariables.driverPhoneNumber);
		eventInfoFromCreation.setDriverPhoneNumber(CommonVariables.driverPhoneNumber);*/
	}

	public void selectInspectionStatus(String inspectionStatus, DataTable inspectionCategoriesData) {

		List<Map<String, String>> list = inspectionCategoriesData.asMaps(String.class, String.class);

		for (int i = 0; i <= list.size() - 1; i++) {
			eiEventCreation.selectInspectionCategoriesStatus(list.get(i).get("Inspection Categories"),
					list.get(i).get("Status"));
			if (list.get(i).get("Status").equalsIgnoreCase("defect")) {
				isDefectExist = true;
			}
		}

		eventServicePage.clickSubmitButton();

		if (isDefectExist) {
			if (inspectionStatus.equalsIgnoreCase("good")) {
				eiEventCreation.popupHandle("yes");
			} else if (inspectionStatus.equalsIgnoreCase("notgood")) {
				eiEventCreation.popupHandle("no");
			}
		}

	}

	public void createNewEventPopup(String createNewEvent) {

		eiEventCreation.popupHandle(createNewEvent);
		if (createNewEvent.equalsIgnoreCase("yes")) {
			assertTrue(driver.getCurrentUrl().contains("clone"));
		} else if (createNewEvent.equalsIgnoreCase("no")) {
			assertTrue(driver.getCurrentUrl().contains(PropsReader.tdURL + "event/equipment_inspections"));
		}
	}

	public void verifyEventInfo() {
		eventInfoFromTenant = eventHelper.setEI_EventData();

		assertEquals(eventInfoFromCreation.getChassisNumber(), eventInfoFromTenant.getChassisNumber());
		assertEquals(eventInfoFromCreation.getEquipmentProvider().toLowerCase(),
				eventInfoFromTenant.getEquipmentProvider().toLowerCase());

		if (isDefectExist) {
			assertTrue(eventInfoPage.getEI_EventInfo("Inspection Status").equalsIgnoreCase("Defect"));
		} else {
			assertTrue(eventInfoPage.getEI_EventInfo("Inspection Status").equalsIgnoreCase("Good"));
		}
	}

	ArrayList<String> tabs;

	public void createServiceEvent() {
		eiEventCreation.clickCreateServiceEventButton();
		tabs = new ArrayList<String>(driver.getWindowHandles());
		System.out.println(tabs.size());
		System.out.println(driver.getCurrentUrl());
		driver.switchTo().window(tabs.get(1));

		assertTrue(driver.getCurrentUrl().contains("/incidents/clone"));
	}

	public void verifyServiceEventData() {
		tabs = new ArrayList<String>(driver.getWindowHandles());

		assertEquals(eventInfoFromCreation.getChassisNumber(), eiEventCreation.getEquipmentNumber());
		assertEquals(eventInfoFromCreation.getEquipmentType().toLowerCase(),
				eiEventCreation.getEquipmentType().toLowerCase());
		assertEquals(eventInfoFromCreation.getEquipmentProvider().toLowerCase(),
				eiEventCreation.getEquipmentProvider().toLowerCase());
		assertEquals(eventInfoFromCreation.getreferenceNumber(), eiEventCreation.getReferenceNumber());

		driver.close();
		driver.switchTo().window(tabs.get(0));
	}

	public void getDVIRdashboardInfo() {
		driver.get(PropsReader.dvirDashboardPage);
		eventInfoFromDashboard = eventHelper.setEventdataFromDVIRDashboardPage(chassisNumber);
		dvirNumber = eventInfoFromDashboard.getDVIRnumber();
	}

	public void verifyDVIRdashboard(DataTable statusData) {
		driver.get(PropsReader.dvirDashboardPage);

		List<Map<String, String>> list = statusData.asMaps(String.class, String.class);
		assertEquals(list.get(0).get("DVIR status"), eventInfoFromDashboard.getdvirStatus());
		assertEquals(list.get(0).get("Equipment Status"), eventInfoFromDashboard.getEquipmentStatus());
		assertEquals(chassisNumber, eventInfoFromDashboard.getEquipmentNumber());
	}

	public void changeEquipmentStatus(String statusData) {
		System.out.println(PropsReader.dvirDashboardPage+"/"+dvirNumber.substring(4));
		driver.get(PropsReader.dvirDashboardPage+"/"+dvirNumber.substring(4));
		reviewPage.changeStatusTo(statusData);
		
		if(statusData.equals("Defect") || statusData.equals("Defer")) {
			eventInfoPage.acceptAlertButton();
		}
		
	}

}
