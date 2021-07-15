package org.reach24.Reach24Admin.helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.reach24.Reach24Admin.dtos.EventDetailsDTO;
import org.reach24.Reach24Admin.dtos.Services;
import org.reach24.Reach24Admin.pages.DVIR_DashboardPage;
import org.reach24.Reach24Admin.pages.DashboardPage;
import org.reach24.Reach24Admin.pages.EventInfoPage;
import org.reach24.Reach24Admin.util.BasePage;
import org.reach24.Reach24Admin.util.PropsReader;

public class EventDtoHelper extends BasePage {
	EventDetailsDTO eventDtoForInfoPage = new EventDetailsDTO();
	EventDetailsDTO eventDtoForDashboardPage = new EventDetailsDTO();
	EventInfoPage eventInfoPage = new EventInfoPage(driver);
	DVIR_DashboardPage dvirDashBoardPage = new DVIR_DashboardPage(driver);
	String eventLink;

	List<Services> servicesList = new ArrayList<Services>();
	Services services = new Services();
	DashboardPage dashboardPage = new DashboardPage(driver);

	public EventDetailsDTO setEventdataFromEventInfoPage(int servicesCount,boolean regularEvent) {
		
		if(regularEvent) {
		 eventDtoForInfoPage.setEventId(driver.getCurrentUrl().split("incidents/")[1]);
		}
		
		eventDtoForInfoPage.setAlphaNumEventId(eventInfoPage.getAlphaNumEventId());
		if (eventInfoPage.getEquipementType("Chassis") != null) {
			eventDtoForInfoPage.setChassisNumber(eventInfoPage.getEventInfo("Chassis"));
			eventDtoForInfoPage.setEquipmentType("Chassis");
			eventDtoForInfoPage.setAssociatedTractorNumber(eventInfoPage.getEventInfo("Associated Power Unit # :"));
			eventDtoForInfoPage.setAssociatedContainerNumber(eventInfoPage.getEventInfo("Associated Container # :"));

		} else if (eventInfoPage.getEquipementType("Container") != null) {
			eventDtoForInfoPage.setContainerNumber(eventInfoPage.getEventInfo("Container"));
			eventDtoForInfoPage.setEquipmentType("Container");
			eventDtoForInfoPage.setAssociatedTractorNumber(eventInfoPage.getEventInfo("Associated Power Unit # :"));
			eventDtoForInfoPage.setAssociatedChassisNumber(eventInfoPage.getEventInfo("Associated Chassis # :"));
		}

		else if (eventInfoPage.getEquipementType("Power Unit") != null) {
			eventDtoForInfoPage.setTractorNumber(eventInfoPage.getEventInfo("Power Unit"));
			eventDtoForInfoPage.setEquipmentType("Power Unit");
			eventDtoForInfoPage.setAssociatedTrailerNumber(eventInfoPage.getEventInfo("Associated Trailer # :"));
			eventDtoForInfoPage.setAssociatedChassisNumber(eventInfoPage.getEventInfo("Associated Chassis # :"));
			eventDtoForInfoPage.setAssociatedContainerNumber(eventInfoPage.getEventInfo("Associated Container # :"));
		} else if (eventInfoPage.getEquipementType("Trailer") != null) {
			eventDtoForInfoPage.setTrailerNumber(eventInfoPage.getEventInfo("Trailer"));
			eventDtoForInfoPage.setEquipmentType("Trailer");
			eventDtoForInfoPage.setAssociatedTractorNumber(eventInfoPage.getEventInfo("Associated Power Unit # :"));
		}
		eventDtoForInfoPage.setServiceCenter(eventInfoPage.getEventInfo("Service Center :"));
		eventDtoForInfoPage.setEquipmentProvider(eventInfoPage.getEventInfo("Equipment Provider :"));

		if (eventInfoPage.getEventInfo("Driver with Unit ? :").equalsIgnoreCase("yes")) {
			eventDtoForInfoPage.setDriverWithUnit(true);
		} else if (eventInfoPage.getEventInfo("Driver with Unit ? :").equalsIgnoreCase("no")) {
			eventDtoForInfoPage.setDriverWithUnit(false);
		}

		if (eventInfoPage.getEventInfo("Loaded ? :").equalsIgnoreCase("yes")) {
			eventDtoForInfoPage.setLoaded(true);
		} else if (eventInfoPage.getEventInfo("Loaded ? :").equalsIgnoreCase("no")) {
			eventDtoForInfoPage.setLoaded(false);
		}

		// Services

		for (int count = servicesCount - 1; count >= 0; count--) {
			services.setSystem(eventInfoPage.getServicesInfo("System", count));
			if (eventInfoPage.getEquipementType("Chassis") != null
					|| eventInfoPage.getEquipementType("Container") != null) {
				services.setSystem(eventInfoPage.getServicesInfo("System", count));
				services.setSubSystem(eventInfoPage.getServicesInfo("Subsystem", count));
				services.setService(eventInfoPage.getServicesInfo("Service", count));
				services.setJob(eventInfoPage.getServicesInfo("Job", count));
				services.setDefect(eventInfoPage.getServicesInfo("Defect", count));
				services.setLocation(eventInfoPage.getServicesInfo("Location", count));
			} else if (eventInfoPage.getEquipementType("Power Unit") != null
					|| eventInfoPage.getEquipementType("Trailer") != null) {
				services.setAssembly(eventInfoPage.getServicesInfo("Assembly", count));
				services.setComponent(eventInfoPage.getServicesInfo("Component", count));
				services.setPosition(eventInfoPage.getServicesInfo("Position", count));
				services.setWorkAccomplished(eventInfoPage.getServicesInfo("Work Accomplished", count));
				services.setReasonforRepair(eventInfoPage.getServicesInfo("Reason for Repair", count));
			}
			servicesList.add(services);
		}

		eventDtoForInfoPage.setServices(servicesList);
		return eventDtoForInfoPage;

	}

	public EventDetailsDTO setEventdataFromDashboardPage(String tabname) {
		
		HashMap<String, String> dashboardMap = new HashMap<String, String>();
		String eventId = null;
		eventId = eventDtoForInfoPage.getAlphaNumEventId();
		System.out.println(eventId);
		dashboardPage.switchTabTo(tabname);
		if(tabname.equalsIgnoreCase("All")) {
		dashboardPage.searchEvent(eventId);
		}else {
			dashboardPage.searchotherEvent(eventId);
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		dashboardMap = dashboardPage.getInfoFromDashboardPage(tabname);
		System.out.println(dashboardMap);
		eventDtoForDashboardPage.setEventId(dashboardMap.get("Event#"));
		eventDtoForDashboardPage.setStatus(dashboardMap.get("Status"));
		eventDtoForDashboardPage.setTechStatus(dashboardMap.get("Technician Status"));
		eventDtoForDashboardPage.setEquipmentType(dashboardMap.get("Equipment Type"));
		eventDtoForDashboardPage.setEquipmentNumber(dashboardMap.get("Equipment#"));
		eventDtoForDashboardPage.setAssociatedContainerNumber(dashboardMap.get("Asso. Container#"));
		eventDtoForDashboardPage.setEquipmentProvider(dashboardMap.get("EP"));
		System.out.println(dashboardMap.get("Asso. Power Unit#"));
		eventDtoForDashboardPage.setAssociatedTractorNumber(dashboardMap.get("Asso. Power Unit#"));
		eventDtoForDashboardPage.setAssociatedChassisNumber(dashboardMap.get("Asso. Chassis#"));
		eventDtoForDashboardPage.setAssociatedTrailerNumber(dashboardMap.get("Asso. Trailer#"));
		eventDtoForDashboardPage.setreferenceNumber(dashboardMap.get("Reference#"));
		return eventDtoForDashboardPage;

	}

	public EventDetailsDTO setEventdataFromDVIRDashboardPage(String chassisNumber) {
		HashMap<String, String> dashboardMap = new HashMap<String, String>();
		dvirDashBoardPage.dvirSwitchTabTo("All");
		dvirDashBoardPage.searchEvent(chassisNumber);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		dashboardMap = dvirDashBoardPage.getInfoFromDashboardPage();
		System.out.println(dashboardMap);
		eventDtoForDashboardPage.setDVIRnumber(dashboardMap.get("DVIR #"));
		eventDtoForDashboardPage.setdvirStatus(dashboardMap.get("DVIR Status"));
		eventDtoForDashboardPage.setEquipmentNumber(dashboardMap.get("Equipment #"));
		eventDtoForDashboardPage.setEquipmentStatus(dashboardMap.get("Equipment Status"));
		return eventDtoForDashboardPage;
	}

	public EventDetailsDTO setEI_EventData() {
		String eventid = driver.getCurrentUrl().split("equipment_inspections/")[1];
		if (eventid.contains("clone")) {
			eventid = eventid.split("/clon")[0];
		}
		eventDtoForInfoPage.setEventId(eventid);
		driver.get(PropsReader.tdIECreateEventPage.replace("new", eventid));

		eventDtoForInfoPage.setAlphaNumEventId(eventInfoPage.getAlphaNumEI_EventId());
		eventDtoForInfoPage.setChassisNumber(eventInfoPage.getEI_EventInfo("Chassis"));
		eventDtoForInfoPage.setEquipmentProvider(eventInfoPage.getEI_EventInfo("Equipment Provider :"));

		return eventDtoForInfoPage;
	}
}
