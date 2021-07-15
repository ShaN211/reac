package org.reach24.Reach24Admin.stepDefinations;

import org.reach24.Reach24Admin.steps.EventCreationStep;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class EventCreationStepDefination {

	EventCreationStep eventCreationStep = new EventCreationStep();

	@Given("^Create a (.*)Event-- (.*)$")
	public void create_a_Event(String eventType, String tenantType, DataTable eventData){
		eventCreationStep.createEvent(eventType, tenantType,eventData, false);
	}
	
	@Given("^Create an Event using AdvanceSearch-- (.*)$")
	public void create_an_Event_AdvanceSearch(String tenantType, DataTable eventData){
		eventCreationStep.createEvent("No", tenantType,eventData, true);
	}

	@When("Enter Service details")
	public void enterServiceDetails(DataTable serviceLineData) {
		eventCreationStep.enterServiceDetails(serviceLineData);
	}

	@Then("^Get (.*)Event information from -- (.*)$")
	public void getEventInfo(String event,String tenantType) {
		eventCreationStep.getEventInfo(event,tenantType);
	}		

	@Then("Verify (.*)Event Status")
	public void VerifyEventStatus(String action,DataTable verificationData) {
		eventCreationStep.verifyStatus(action,verificationData);
	}
	
	@Then("Verify Tech Status")
	public void VerifyTechStatus(DataTable verificationData) {
		eventCreationStep.verifyTechStatus(verificationData);

	}
	
}
