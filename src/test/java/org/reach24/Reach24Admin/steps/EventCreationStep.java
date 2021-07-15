
package org.reach24.Reach24Admin.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.reach24.Reach24Admin.dtos.EventDetailsDTO;
import org.reach24.Reach24Admin.dtos.Services;
import org.reach24.Reach24Admin.helper.EventDtoHelper;
import org.reach24.Reach24Admin.models.CommonVariables;
import org.reach24.Reach24Admin.pages.DashboardPage;
import org.reach24.Reach24Admin.pages.EventCreationPage;
import org.reach24.Reach24Admin.pages.EventInfoPage;
import org.reach24.Reach24Admin.pages.EventServicesPage;
import org.reach24.Reach24Admin.util.BasePage;
import org.reach24.Reach24Admin.util.PropsReader;
import org.reach24.Reach24Admin.util.Reach24AutomationCustomException;
import org.reach24.Reach24Admin.util.ReusableMethods;

import io.cucumber.datatable.DataTable;

public class EventCreationStep extends BasePage {
	static EventDetailsDTO eventInfoFromCreation = new EventDetailsDTO();
	static EventDetailsDTO eventInfoFromTenant = new EventDetailsDTO();
	static EventDetailsDTO eventInfoFromDashboard = new EventDetailsDTO();
	static EventDetailsDTO eventInfoFromEditDraft = new EventDetailsDTO();

	EventDtoHelper eventHelper = new EventDtoHelper();
	EventCreationPage eventCreationPage = new EventCreationPage(driver);
	EventServicesPage eventServicePage = new EventServicesPage(driver);
	EventInfoPage eventInfoPage = new EventInfoPage(driver);
	ReusableMethods reuseCode = new ReusableMethods();
	Services services = new Services();
	static int serviesCount;
	static String eventId;
	static String eventlink;
	static boolean regularevent;
	static String otherevent;
	static String EditTitle;

	String chassisNumber = reuseCode.randomAlphaNumericName(4, 6).toUpperCase();
	String containerNumber = reuseCode.randomAlphaNumericName(4, 6).toUpperCase();
	String tractorNumber = reuseCode.randomAlphaNumericName(4, 6).toUpperCase();
	String trailerNumber = reuseCode.randomAlphaNumericName(4, 6).toUpperCase();

	String associatedChassisNumber = reuseCode.randomAlphaNumericName(4, 6).toUpperCase();
	String associatedTrailerNumber = reuseCode.randomAlphaNumericName(4, 6).toUpperCase();
	String associatedTractorNumber = reuseCode.randomAlphaNumericName(4, 6).toUpperCase();
	String associatedContainerNumber = reuseCode.randomAlphaNumericName(4, 6).toUpperCase();
	String referenceNumber = reuseCode.randomAlphaNumericName(0, 7);

	String fleetName = reuseCode.randomAlphaNumericName(5, 0);
	String dotNum = reuseCode.randomAlphaNumericName(0, 9);

	public void createEvent(String eventType, String tenantType, DataTable eventData, boolean advanceSearch) {
		List<Map<String, String>> list = eventData.asMaps(String.class, String.class);
		String equipmentType = list.get(0).get("EquipmentType");
		String truckDispatch = list.get(0).get("TruckDispatch");
		String equipmentProvider = list.get(0).get("EquipmentProvider");
		String equipmentProviderType = list.get(0).get("EquipmentProviderType");

		tenantType = tenantType.toUpperCase();
		try {
			switch (tenantType) {
			case "TD":
				driver.get(PropsReader.tdeventCreatePage);
				break;
				
			case "TD1":
				driver.get(PropsReader.td1eventCreatePage);
				break;
				
			case "TD2":
				driver.get(PropsReader.td2eventCreatePage);
				break;
				
			case "TD3":
				driver.get(PropsReader.td3eventCreatePage);
				break;
				
			case "SP":
				driver.get(PropsReader.speventCreatePage);
				break;

			case "CC":
				driver.get(PropsReader.cceventCreatePage);
				break;

			case "AMAZON":
				driver.get(PropsReader.amazoneventCreatePage);
				break;
			default:
				throw new Reach24AutomationCustomException("Invalid Tenant selected");

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

				if (advanceSearch) {
					advanceSearch(equipmentProviderType, equipmentProvider);
				} else {
					eventCreationPage.selectEquipmentProvider(equipmentProvider);
					eventInfoFromCreation.setEquipmentProvider(equipmentProvider);
				}

				if (list.get(0).get("associatedTractorNumber") != null) {
					eventCreationPage.associatedTractorNumber(list.get(0).get("associatedTractorNumber"));
					eventInfoFromCreation.setAssociatedTractorNumber(list.get(0).get("associatedTractorNumber"));
				} else {
					eventCreationPage.associatedTractorNumber(associatedTractorNumber);
					eventInfoFromCreation.setAssociatedTractorNumber(associatedTractorNumber);
				}
				if (list.get(0).get("associatedContainerNumber") != null) {
					eventCreationPage.associatedContainerNumber(list.get(0).get("associatedContainerNumber"));
					eventInfoFromCreation.setAssociatedContainerNumber(list.get(0).get("associatedContainerNumber"));
				} else {
					eventCreationPage.associatedContainerNumber(associatedContainerNumber);
					eventInfoFromCreation.setAssociatedContainerNumber(associatedContainerNumber);
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

				if (advanceSearch) {
					advanceSearch(equipmentProviderType, equipmentProvider);
				} else {
					eventCreationPage.selectEquipmentProvider(equipmentProvider);
					eventInfoFromCreation.setEquipmentProvider(equipmentProvider);
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

				if (advanceSearch) {
					advanceSearch(equipmentProviderType, equipmentProvider);
				} else {
					eventCreationPage.selectEquipmentProvider(equipmentProvider);
					eventInfoFromCreation.setEquipmentProvider(equipmentProvider);
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

				if (advanceSearch) {
					advanceSearch(equipmentProviderType, equipmentProvider);
				} else {
					eventCreationPage.selectEquipmentProvider(equipmentProvider);
					eventInfoFromCreation.setEquipmentProvider(equipmentProvider);
				}

				if (list.get(0).get("associatedTractorNumber") != null) {
					eventCreationPage.associatedTractorNumber(list.get(0).get("associatedTractorNumber"));
					eventInfoFromCreation.setAssociatedTractorNumber(list.get(0).get("associatedTractorNumber"));
				} else {
					eventCreationPage.associatedTractorNumber(associatedTractorNumber);
					eventInfoFromCreation.setAssociatedTractorNumber(associatedTractorNumber);
				}
				break;

			default:
				throw new Reach24AutomationCustomException("Options not selected");

			}
		} catch (Reach24AutomationCustomException e) {
			e.printStackTrace();
		}

		// eventCreationPage.selectEquipmentProvider(equipmentProvider);
		// eventInfoFromCreation.setEquipmentProvider(equipmentProvider);

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
		// eventCreationPage.comment(CommonVariables.comment);
		eventCreationPage.selectDriver(CommonVariables.driverName + " - " + CommonVariables.driverPhoneNumber);
		eventInfoFromCreation.setDriverName(CommonVariables.driverName);
		eventInfoFromCreation.setDriverPhoneNumber(CommonVariables.driverPhoneNumber);
		if (equipmentType.equalsIgnoreCase("trailer")) {
			eventCreationPage.selectRefrigeratedRadioButton(true);
			eventInfoFromCreation.setRefrigerated(true);
		}
		eventCreationPage.selectDriverWithUnitRadioButton(false);
		eventInfoFromCreation.setDriverWithUnit(false);
		eventCreationPage.selectLoadedRadioButton(true);
		eventInfoFromCreation.setLoaded(true);
		eventCreationPage.enterAddress(CommonVariables.address);
		eventInfoFromCreation.setAddress(CommonVariables.address);
		eventCreationPage.breakdownNotes(CommonVariables.breakDownNotes);
		eventCreationPage.referenceNumber(referenceNumber);
		eventInfoFromCreation.setreferenceNumber(referenceNumber);

		if (eventType.contains("Draft")) {
			eventCreationPage.clickSaveDraftButton();
		}
	}

	public void advanceSearch(String equipmentProviderType, String equipmentProvider) {
		try {
			switch (equipmentProviderType.toLowerCase()) {
			case "create":
				eventCreationPage.clickAdSearchButton();
				eventCreationPage.enterFleetName(fleetName);
				eventCreationPage.clickSearchButton();
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				eventCreationPage.enterFleetEmail("test@reach24.net");
				// eventCreationPage.enterFleetPh("0000000000");
				eventCreationPage.enterFleetDOT(dotNum);
				eventCreationPage.clickcreateButton();
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				eventCreationPage.selectTimeZone("Eastern time");
				eventCreationPage.enterFleetAdd("San francisco");

				eventCreationPage.enterFleetPh("0000000000");
				eventCreationPage.clickcreateButton2();

				eventCreationPage.selectEquipmentProvider(fleetName);
				eventInfoFromCreation.setEquipmentProvider(fleetName);
				break;

			case "walkin":
				eventCreationPage.selectEquipmentProvider("unknown");

				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				eventCreationPage.clickWalkinButton();
				eventCreationPage.enterWalkinEPnames(fleetName);
				eventInfoFromCreation.setEquipmentProvider(fleetName);
				eventCreationPage.enterWalkinEPadd("San francisco");
				eventCreationPage.enterWalkinEPPH("0000000000");		
				break;

			case "search":
				eventCreationPage.clickAdSearchButton();
				eventCreationPage.enterFleetName(equipmentProvider);
				eventCreationPage.clickSearchButton();

				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				eventCreationPage.selecteEP();

				eventInfoFromCreation.setEquipmentProvider(equipmentProvider);
				break;

			default:
				throw new Reach24AutomationCustomException("Invalid selected");

			}
		} catch (Reach24AutomationCustomException e) {
			e.printStackTrace();
		}
	}

	public void enterServiceDetails(DataTable serviceLineData) {
		List<Map<String, String>> list = serviceLineData.asMaps(String.class, String.class);
		String equipmentType = list.get(0).get("EquipmentType");
		List<Services> servicesList = new ArrayList<Services>();
		serviesCount = list.size();

		for (int count = 0; count <= list.size() - 1; count++) {
			eventCreationPage.addService();

			if (equipmentType.equalsIgnoreCase("chassis") || equipmentType.equalsIgnoreCase("container")) {
				eventServicePage.selectSystem(list.get(count).get("System"), count);
				services.setSystem(list.get(count).get("System"));

				eventServicePage.selectSubSystem(list.get(count).get("SubSystem"), count);
				services.setSubSystem(list.get(count).get("SubSystem"));

				eventServicePage.selectService(list.get(count).get("Service"), count);
				services.setService(list.get(count).get("Service"));

				eventServicePage.selectDefect(list.get(count).get("Defect"), count);
				services.setDefect(list.get(count).get("Defect"));

				eventServicePage.selectLocation(list.get(count).get("Location"), count);
				services.setLocation(list.get(count).get("Location"));

			} else if (equipmentType.equalsIgnoreCase("power unit") || equipmentType.equalsIgnoreCase("trailer")) {

				eventServicePage.selectTractorSystem(list.get(count).get("System"), count);
				services.setSystem(list.get(count).get("System"));

				eventServicePage.selectAssembly(list.get(count).get("Assembly"), count);
				services.setAssembly(list.get(count).get("Assembly"));

				eventServicePage.selectComponent(list.get(count).get("Component"), count);
				services.setComponent(list.get(count).get("Component"));

				eventServicePage.selectPosition(list.get(count).get("Position"), count);
				services.setPosition(list.get(count).get("Position"));

				eventServicePage.selectWorkAccomplished(list.get(count).get("WorkAccomplished"), count);
				services.setWorkAccomplished(list.get(count).get("WorkAccomplished"));

				eventServicePage.selectReasonforRepair(list.get(count).get("Reason"), count);
				services.setReasonforRepair(list.get(count).get("Reason"));

			}
			servicesList.add(services);
		}
		eventInfoFromCreation.setServices(servicesList);
		eventServicePage.clickSubmitButton();

		assertFalse(driver.getCurrentUrl().contains("/event/incidents/new"));
		eventId = driver.getCurrentUrl().split("incidents/")[1];

	}

	public void getEventInfo(String event, String tenantType) {
		tenantType = tenantType.toUpperCase();
		try {
			switch (tenantType) {

			case "TD" :
				driver.get(PropsReader.tdEventInfoPage + eventId);
				System.out.println(PropsReader.tdEventInfoPage + eventId);
				eventInfoFromTenant = eventHelper.setEventdataFromEventInfoPage(serviesCount, true);
				driver.get(PropsReader.tdURL);
				eventInfoFromDashboard = eventHelper.setEventdataFromDashboardPage("All");
				break;
				
			case "TD1" :
				driver.get(PropsReader.td1EventInfoPage + eventId);
				System.out.println(PropsReader.td1EventInfoPage + eventId);
				eventInfoFromTenant = eventHelper.setEventdataFromEventInfoPage(serviesCount, true);
				driver.get(PropsReader.td1URL);
				eventInfoFromDashboard = eventHelper.setEventdataFromDashboardPage("All");
				break;
				
			case "TD2" :
				driver.get(PropsReader.td2EventInfoPage + eventId);
				System.out.println(PropsReader.td2EventInfoPage + eventId);
				eventInfoFromTenant = eventHelper.setEventdataFromEventInfoPage(serviesCount, true);
				driver.get(PropsReader.td2URL);
				eventInfoFromDashboard = eventHelper.setEventdataFromDashboardPage("All");
				break;
				
			case "TD3" :
				driver.get(PropsReader.td3EventInfoPage + eventId);
				System.out.println(PropsReader.td3EventInfoPage + eventId);
				eventInfoFromTenant = eventHelper.setEventdataFromEventInfoPage(serviesCount, true);
				driver.get(PropsReader.td3URL);
				eventInfoFromDashboard = eventHelper.setEventdataFromDashboardPage("All");
				break;

			case "AMAZON":
				driver.get(PropsReader.amazonEventInfoPage + eventId);
				System.out.println(PropsReader.amazonEventInfoPage + eventId);
				eventInfoFromTenant = eventHelper.setEventdataFromEventInfoPage(serviesCount, true);
				driver.get(PropsReader.amazonURL);
				eventInfoFromDashboard = eventHelper.setEventdataFromDashboardPage("All");
				break;

			case "SP":
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				System.out.println(PropsReader.spEventInfoPage + eventId);
				driver.get(PropsReader.spEventInfoPage + eventId);
				System.out.println(PropsReader.spEventInfoPage + eventId);

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				eventInfoFromTenant = eventHelper.setEventdataFromEventInfoPage(serviesCount, true);
				driver.get(PropsReader.spURL);
				eventInfoFromDashboard = eventHelper.setEventdataFromDashboardPage("All");
				break;

			case "SP2":
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				driver.get(PropsReader.sp2URL);
				if (event.equalsIgnoreCase("Reassigned")) {
					eventInfoPage.statustabSwitch("reassigned");
					eventInfoPage.openEventInfoPage(eventId);
					System.out.println(eventlink = driver.getCurrentUrl());
					eventInfoFromTenant = eventHelper.setEventdataFromEventInfoPage(serviesCount, false);
				} else if (event.equalsIgnoreCase("Rejected")) {
					eventInfoPage.statustabSwitch("rejected");
					eventInfoPage.openEventInfoPage(eventId);
					System.out.println(eventlink = driver.getCurrentUrl());
					eventInfoFromTenant = eventHelper.setEventdataFromEventInfoPage(serviesCount, false);
				} else {
					driver.get(PropsReader.sp2EventInfoPage + eventId);
					System.out.println(PropsReader.sp2EventInfoPage + eventId);
					eventInfoFromTenant = eventHelper.setEventdataFromEventInfoPage(serviesCount, true);
				}

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}

				// eventInfoFromTenant =
				// eventHelper.setEventdataFromEventInfoPage(serviesCount);

				driver.get(PropsReader.sp2URL);

				if (event.equalsIgnoreCase("Reassigned")) {
					eventInfoFromDashboard = eventHelper.setEventdataFromDashboardPage("reassigned");
				} else {
					if (event.equalsIgnoreCase("Rejected")) {
						eventInfoFromDashboard = eventHelper.setEventdataFromDashboardPage("rejected");
					} else {
						eventInfoFromDashboard = eventHelper.setEventdataFromDashboardPage("All");
					}
				}

				break;

			case "CC":
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}

				System.out.println(PropsReader.ccEventInfoPage + eventId);
				driver.get(PropsReader.ccEventInfoPage + eventId);
				System.out.println(PropsReader.ccEventInfoPage + eventId);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				eventInfoFromTenant = eventHelper.setEventdataFromEventInfoPage(serviesCount, true);
				driver.get(PropsReader.ccURL);
				eventInfoFromDashboard = eventHelper.setEventdataFromDashboardPage("All");
				break;

			case "SCTECH":
				System.out.println(PropsReader.sctechEventInfoPage + eventId);
				eventInfoFromTenant = eventHelper.setEventdataFromEventInfoPage(serviesCount, true);
				driver.get(PropsReader.sctechURL);
				eventInfoFromDashboard = eventHelper.setEventdataFromDashboardPage("All");
				break;

			default:
				throw new Reach24AutomationCustomException("Invalid Tenant selected");

			}
		} catch (Reach24AutomationCustomException e) {
			e.printStackTrace();
		}

	}

	public void verifyStatus(String action, DataTable verificationData) {
		List<Map<String, String>> list = verificationData.asMaps(String.class, String.class);

		// try {
		// Thread.sleep(1000);
		// } catch (InterruptedException e1) {
		// e1.printStackTrace();
		// }
		for (int count = 0; count <= list.size() - 1; count++) {
			String tenantType = list.get(count).get("TenandType");
			String status = list.get(count).get("Status");
			String page = list.get(count).get("Page");
			String statusType = list.get(count).get("StatusType");
			try {
				switch (tenantType) {

				case "TD":
					driver.get(PropsReader.tdEventInfoPage + eventId);
					if (page.equalsIgnoreCase("Dashboard")) {
						dashBoardValidation(eventInfoFromCreation, eventInfoFromDashboard);
						assertEquals(status, eventInfoFromDashboard.getStatus());
					} else if (page.equalsIgnoreCase("EventInfo")) {
						validateEventFields(eventInfoFromCreation, eventInfoFromTenant);
						assertEquals(status, eventInfoPage.getStatus());

					}

					break;
					
				case "TD1":
					driver.get(PropsReader.td1EventInfoPage + eventId);
					if (page.equalsIgnoreCase("Dashboard")) {
						dashBoardValidation(eventInfoFromCreation, eventInfoFromDashboard);
						assertEquals(status, eventInfoFromDashboard.getStatus());
					} else if (page.equalsIgnoreCase("EventInfo")) {
						validateEventFields(eventInfoFromCreation, eventInfoFromTenant);
						assertEquals(status, eventInfoPage.getStatus());

					}

					break;
					
				case "TD2":
					driver.get(PropsReader.td2EventInfoPage + eventId);
					if (page.equalsIgnoreCase("Dashboard")) {
						dashBoardValidation(eventInfoFromCreation, eventInfoFromDashboard);
						assertEquals(status, eventInfoFromDashboard.getStatus());
					} else if (page.equalsIgnoreCase("EventInfo")) {
						validateEventFields(eventInfoFromCreation, eventInfoFromTenant);
						assertEquals(status, eventInfoPage.getStatus());

					}

					break;
					
				case "TD3":
					driver.get(PropsReader.td3EventInfoPage + eventId);
					if (page.equalsIgnoreCase("Dashboard")) {
						dashBoardValidation(eventInfoFromCreation, eventInfoFromDashboard);
						assertEquals(status, eventInfoFromDashboard.getStatus());
					} else if (page.equalsIgnoreCase("EventInfo")) {
						validateEventFields(eventInfoFromCreation, eventInfoFromTenant);
						assertEquals(status, eventInfoPage.getStatus());

					}

					break;

				case "AMAZON":
					driver.get(PropsReader.amazonEventInfoPage + eventId);
					if (page.equalsIgnoreCase("Dashboard")) {
						dashBoardValidation(eventInfoFromCreation, eventInfoFromDashboard);
						assertEquals(status, eventInfoFromDashboard.getStatus());
					} else if (page.equalsIgnoreCase("EventInfo")) {
						validateEventFields(eventInfoFromCreation, eventInfoFromTenant);
						assertEquals(status, eventInfoPage.getStatus());
					}

					break;

				case "SP":
					driver.get(PropsReader.spEventInfoPage + eventId);

					if (page.equalsIgnoreCase("Dashboard")) {
						dashBoardValidation(eventInfoFromCreation, eventInfoFromDashboard);
						assertEquals(status, eventInfoFromDashboard.getStatus());
					} else if (page.equalsIgnoreCase("EventInfo")) {
						validateEventFields(eventInfoFromCreation, eventInfoFromTenant);
						if (statusType.equalsIgnoreCase("Single"))
							assertEquals(status, eventInfoPage.getStatus());
						else if (statusType.equalsIgnoreCase("Double"))
							assertEquals(status, eventInfoPage.getStatus() + " - " + eventInfoPage.getStatus2());
					}

					break;

				case "SP2":
					if (action.equalsIgnoreCase("Reassigned") || action.equalsIgnoreCase("Rejected")) {
						driver.get(eventlink);
					} else {
						driver.get(PropsReader.sp2EventInfoPage + eventId);
					}

					if (page.equalsIgnoreCase("Dashboard")) {
						dashBoardValidation(eventInfoFromCreation, eventInfoFromDashboard);
						assertEquals(status, eventInfoFromDashboard.getStatus());
					} else if (page.equalsIgnoreCase("EventInfo")) {
						validateEventFields(eventInfoFromCreation, eventInfoFromTenant);
						assertEquals(status, eventInfoPage.getStatus());
					}

					break;

				case "CC":
					driver.get(PropsReader.ccEventInfoPage + eventId);
					if (page.equalsIgnoreCase("Dashboard")) {
						dashBoardValidation(eventInfoFromCreation, eventInfoFromDashboard);
						assertEquals(status, eventInfoFromDashboard.getStatus());
					} else if (page.equalsIgnoreCase("EventInfo")) {
						validateEventFields(eventInfoFromCreation, eventInfoFromTenant);
						if (statusType.equalsIgnoreCase("Single"))
							assertEquals(status, eventInfoPage.getStatus());
						else if (statusType.equalsIgnoreCase("Double"))
							assertEquals(status, eventInfoPage.getStatus() + " - " + eventInfoPage.getStatus2());
					}

					break;

				case "SCTech":
					driver.get(PropsReader.sctechEventInfoPage + eventId);
					if (page.equalsIgnoreCase("Dashboard")) {
						dashBoardValidation(eventInfoFromCreation, eventInfoFromDashboard);
						assertEquals(status, eventInfoFromDashboard.getStatus());
					} else if (page.equalsIgnoreCase("EventInfo")) {
						validateEventFields(eventInfoFromCreation, eventInfoFromTenant);
						assertEquals(status, eventInfoPage.getStatus());
					}

					break;

				default:
					throw new Reach24AutomationCustomException("Invalid Tenant selected");

				}
			} catch (Reach24AutomationCustomException e) {
				e.printStackTrace();
			}
		}

	}

	public void verifyTechStatus(DataTable verificationData) {
		List<Map<String, String>> list = verificationData.asMaps(String.class, String.class);
		HashMap<String, String> dashboardMap = new HashMap<String, String>();
		DashboardPage dashboardPage = new DashboardPage(driver);
		EventInfoPage eventInfoPage = new EventInfoPage(driver);

		for (int count = 0; count <= list.size() - 1; count++) {
			String tenantType = list.get(count).get("TenandType");
			String status = list.get(count).get("Status");
			String page = list.get(count).get("Page");
			try {
				switch (tenantType) {

				case "TD":
					driver.get(PropsReader.tdEventInfoPage + eventId);
					if (page.equalsIgnoreCase("Dashboard")) {
						driver.get(PropsReader.tdURL);
						dashboardMap = dashboardPage.getInfoFromDashboardPage("All");
						System.out.println(dashboardMap);

						assertEquals(status, dashboardMap.get("Technician Status"));

					} else if (page.equalsIgnoreCase("EventInfo")) {
						String techstatus = eventInfoPage.getTechStatus();
						System.out.println(techstatus);

						assertEquals(status, techstatus);
					}
					break;

				case "SP":
					driver.get(PropsReader.spEventInfoPage + eventId);

					if (page.equalsIgnoreCase("Dashboard")) {
						driver.get(PropsReader.spURL);
						if (page.equalsIgnoreCase("Dashboard")) {
							dashboardMap = dashboardPage.getInfoFromDashboardPage("All");
							System.out.println(dashboardMap);

							assertEquals(status, dashboardMap.get("Technician Status"));

						} else if (page.equalsIgnoreCase("EventInfo")) {
							String techstatus = eventInfoPage.getTechStatus();
							System.out.println(techstatus);

							assertEquals(status, techstatus);
						}

					}

					break;

				case "SCTech":
					driver.get(PropsReader.sctechEventInfoPage + eventId);

					if (page.equalsIgnoreCase("Dashboard")) {
						driver.get(PropsReader.sctechURL);
						if (page.equalsIgnoreCase("Dashboard")) {
							dashboardMap = dashboardPage.getInfoFromDashboardPage("All");
							System.out.println(dashboardMap);
							assertEquals(status, dashboardMap.get("Technician Status"));

						} else if (page.equalsIgnoreCase("EventInfo")) {
							String techstatus = eventInfoPage.getTechStatus();
							System.out.println(techstatus);

							assertEquals(status, techstatus);

						}

					}

					break;
				default:
					throw new Reach24AutomationCustomException("Invalid Tenant selected");

				}
			}

			catch (Reach24AutomationCustomException e) {
				e.printStackTrace();
			}
		}

	}

	public void validateEventFields(EventDetailsDTO eventInfoFromCreation, EventDetailsDTO eventInfoTenant) {
		// Event Data
		assertTrue("Verify Equipment Provider", eventInfoTenant.getEquipmentProvider().toLowerCase()
				.contains(eventInfoFromCreation.getEquipmentProvider().toLowerCase()));
		assertEquals("Verify Equipment Type", eventInfoFromCreation.getEquipmentType().toLowerCase(),
				eventInfoTenant.getEquipmentType().toLowerCase());
		try {
			switch (eventInfoFromCreation.getEquipmentType().toLowerCase()) {
			case "chassis":
				assertEquals("Verify Chassis Number", eventInfoFromCreation.getChassisNumber(),
						eventInfoTenant.getChassisNumber());
				assertEquals("Verify Associated Tractor Number", eventInfoFromCreation.getAssociatedTractorNumber(),
						eventInfoTenant.getAssociatedTractorNumber());
				assertEquals("Verify Associated Container Number", eventInfoFromCreation.getAssociatedContainerNumber(),
						eventInfoTenant.getAssociatedContainerNumber());
				break;
			case "container":
				assertEquals("Verify Container Number", eventInfoFromCreation.getContainerNumber(),
						eventInfoTenant.getContainerNumber());
				assertEquals("Verify Associated Tractor Number", eventInfoFromCreation.getAssociatedTractorNumber(),
						eventInfoTenant.getAssociatedTractorNumber());
				assertEquals("Verify Associated Chassis Number", eventInfoFromCreation.getAssociatedChassisNumber(),
						eventInfoTenant.getAssociatedChassisNumber());
				break;
			case "power unit":
				assertEquals("Verify Tractor Number", eventInfoFromCreation.getTractorNumber(),
						eventInfoTenant.getTractorNumber());
				assertEquals("Verify Associated Trailer Number", eventInfoFromCreation.getAssociatedTrailerNumber(),
						eventInfoTenant.getAssociatedTrailerNumber());
				assertEquals("Verify Associated Chassis Number", eventInfoFromCreation.getAssociatedChassisNumber(),
						eventInfoTenant.getAssociatedChassisNumber());
				assertEquals("Verify Associated Container Number", eventInfoFromCreation.getAssociatedContainerNumber(),
						eventInfoTenant.getAssociatedContainerNumber());
				break;
			case "trailer":
				assertEquals("Verify Trailer Number", eventInfoFromCreation.getTrailerNumber(),
						eventInfoTenant.getTrailerNumber());
				assertEquals("Verify Associated Tractor Number", eventInfoFromCreation.getAssociatedTractorNumber(),
						eventInfoTenant.getAssociatedTractorNumber());
				break;
			default:
				throw new Reach24AutomationCustomException("Invalid Equipement Type");

			}
		} catch (Reach24AutomationCustomException e) {
			e.printStackTrace();
		}

		// ServiceLine Items
		for (int count = 0; count <= eventInfoFromCreation.getServices().size() - 1; count++) {

			assertTrue(eventInfoTenant.getServices().get(count).getSystem().toLowerCase()
					.contains(eventInfoFromCreation.getServices().get(count).getSystem().toLowerCase()));

			if (eventInfoFromCreation.getEquipmentType().toLowerCase().equals("chassis")
					|| eventInfoFromCreation.getEquipmentType().toLowerCase().equals("container")) {
				assertEquals(eventInfoFromCreation.getServices().get(count).getSubSystem(),
						eventInfoTenant.getServices().get(count).getSubSystem());

				assertEquals(eventInfoFromCreation.getServices().get(count).getService(),
						eventInfoTenant.getServices().get(count).getService());

				// assertEquals(eventInfoFromCreation.getServices().get(count).getService(),
				// eventInfoTenant.getServices().get(count).getJob().split("/")[1]+eventInfoTenant.getServices().get(count).getJob().split("/")[2]);

				assertEquals(eventInfoFromCreation.getServices().get(count).getDefect(),
						eventInfoTenant.getServices().get(count).getDefect());

				// assertEquals(eventInfoFromCreation.getServices().get(count).getLocation(),
				// eventInfoTenant.getServices().get(count).getLocation());

			} else if (eventInfoFromCreation.getEquipmentType().toLowerCase().equals("tractor")
					|| eventInfoFromCreation.getEquipmentType().toLowerCase().equals("trailer")) {
				assertTrue(eventInfoTenant.getServices().get(count).getAssembly().toLowerCase()
						.contains(eventInfoFromCreation.getServices().get(count).getAssembly().toLowerCase()));

				assertTrue(eventInfoTenant.getServices().get(count).getComponent().toLowerCase()
						.contains(eventInfoFromCreation.getServices().get(count).getComponent().toLowerCase()));

				assertTrue(eventInfoTenant.getServices().get(count).getPosition().toLowerCase()
						.contains(eventInfoFromCreation.getServices().get(count).getPosition().toLowerCase()));

				assertTrue(eventInfoTenant.getServices().get(count).getWorkAccomplished().toLowerCase()
						.contains(eventInfoFromCreation.getServices().get(count).getWorkAccomplished().toLowerCase()));

				assertTrue(eventInfoTenant.getServices().get(count).getReasonforRepair().toLowerCase()
						.contains(eventInfoFromCreation.getServices().get(count).getReasonforRepair().toLowerCase()));

			}
		}
	}

	public void dashBoardValidation(EventDetailsDTO eventInfoFromCreation, EventDetailsDTO eventInfoFromDashboard) {
		try {
			switch (eventInfoFromCreation.getEquipmentType().toLowerCase()) {
			case "chassis":
				assertEquals("Verify Chassis Number", eventInfoFromCreation.getChassisNumber(),
						eventInfoFromDashboard.getEquipmentNumber());
				assertEquals("Verify associated Tractor Number", eventInfoFromCreation.getAssociatedTractorNumber(),
						eventInfoFromDashboard.getAssociatedTractorNumber());
				assertEquals("Verify associated Container Number", eventInfoFromCreation.getAssociatedContainerNumber(),
						eventInfoFromDashboard.getAssociatedContainerNumber());
				break;
			case "container":
				assertEquals("Verify Container Number", eventInfoFromCreation.getContainerNumber(),
						eventInfoFromDashboard.getEquipmentNumber());
				assertEquals("Verify associated Tractor Number", eventInfoFromCreation.getAssociatedTractorNumber(),
						eventInfoFromDashboard.getAssociatedTractorNumber());
				assertEquals("Verify associated Chassis Number", eventInfoFromCreation.getAssociatedChassisNumber(),
						eventInfoFromDashboard.getAssociatedChassisNumber());
				break;

			case "power unit":
				assertEquals("Verify Tractor Number", eventInfoFromCreation.getTractorNumber(),
						eventInfoFromDashboard.getEquipmentNumber());
				assertEquals("Verify associated Trailer Number", eventInfoFromCreation.getAssociatedTrailerNumber(),
						eventInfoFromDashboard.getAssociatedTrailerNumber());
				assertEquals("Verify associated Chassis Number", eventInfoFromCreation.getAssociatedChassisNumber(),
						eventInfoFromDashboard.getAssociatedChassisNumber());
				assertEquals("Verify associated Container Number", eventInfoFromCreation.getAssociatedContainerNumber(),
						eventInfoFromDashboard.getAssociatedContainerNumber());
				break;

			case "trailer":
				assertEquals("Verify Trailer Number", eventInfoFromCreation.getTrailerNumber(),
						eventInfoFromDashboard.getEquipmentNumber());
				assertEquals("Verify associated Tractor Number", eventInfoFromCreation.getAssociatedTractorNumber(),
						eventInfoFromDashboard.getAssociatedTractorNumber());
				break;
			default:
				throw new Reach24AutomationCustomException("Options not selected");

			}
		} catch (Reach24AutomationCustomException e) {
			e.printStackTrace();
		}
		System.out.println(eventInfoFromCreation.getEquipmentProvider().toUpperCase());
		// System.out.println(eventInfoFromDashboard.getEquipmentProvider().toUpperCase().replace("
		// ", ""));
		// assertEquals("Verify Equipment Provider",
		// eventInfoFromCreation.getEquipmentProvider().toUpperCase(),
		// eventInfoFromDashboard.getEquipmentProvider().toUpperCase().replace(" ",
		// ""));
		// assertEquals("Verify EventId", eventInfoFromCreation.getreferenceNumber(),
		// eventInfoFromDashboard.getreferenceNumber());
	}
	

}
