package org.reach24.Reach24Admin.stepDefinations;

import org.reach24.Reach24Admin.steps.EquipmentInspectionSteps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class EI_EventCreationStepDefination {

	EquipmentInspectionSteps eiSteps = new EquipmentInspectionSteps();

	@Given("Create a EI event-- (.*)")
	public void create_a_EI_Event(String tenantType, DataTable eventData) {
		eiSteps.createEIevent(tenantType, eventData);
	}

	@Given("Select Inspection status-- (.*) to Travel")
	public void select_Inspection_status(String inspectionStatus, DataTable inspectionCategoriesData) {
		eiSteps.selectInspectionStatus(inspectionStatus, inspectionCategoriesData);
	}

	@Given("New Event popup-- (.*)")
	public void createNewEventPopup(String createNewEvent) {
		eiSteps.createNewEventPopup(createNewEvent);
	}
	
	@Then("Verify EI eventinfo")
	public void verifyEventInfo() {
		eiSteps.verifyEventInfo();
	}
	
	@Then("Create a service event")
	public void createServiceEvent() {
		eiSteps.createServiceEvent();
	}
	
	@Then("Verify Service event data")
	public void verifyServiceEventData() {
		eiSteps.verifyServiceEventData();
	}
	
	@Then("Get DVIR dashboard info")
	public void getDVIRdashboardInfo() {
		eiSteps.getDVIRdashboardInfo();
	}
	
	@Then("Verify DVIR dashboard")
	public void verifyDVIRdashboardData(DataTable statusData) {
		eiSteps.verifyDVIRdashboard(statusData);
	}
	
	@Then("Change equipment status -- (.*)")
	public void changeEquipmentStatus(String statusData) {
		eiSteps.changeEquipmentStatus(statusData);
	}
}
