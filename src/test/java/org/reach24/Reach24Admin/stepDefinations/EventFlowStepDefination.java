package org.reach24.Reach24Admin.stepDefinations;

import java.awt.AWTException;

import org.reach24.Reach24Admin.steps.EventCreationStep;
import org.reach24.Reach24Admin.steps.EventFlowSteps;
import org.reach24.Reach24Admin.steps.OutofNetworkSteps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;

public class EventFlowStepDefination {
	EventFlowSteps eventFlow = new EventFlowSteps();
	OutofNetworkSteps eventOutOfNetwork =new OutofNetworkSteps();

	@Then("^(.*) (.*) event to -- (.*) -- Payment Method - (.*)$")
	public void assignEvent(String action,String eventTenantType, String tenantType, String payment ) {
		eventFlow.assignEventToTenant(action, eventTenantType, tenantType, payment);
	}
	
	@Then("^Assign event to outofNetwork -- (.*) -- Payment Method - (.*)$")
	public void assignoutOfNetwork(String tenantType, String payment ) {
		eventOutOfNetwork.assignEventToOutofNetwork(tenantType, payment);
	}
	
	@Then("Assign tech in CC")
	public void assigntoTech() {
		eventFlow.assignTotech();
	}
	
	@Then("^(.*) Event -- In (.*)$")
	public void acceptEvent(String action, String tenantType) {
		eventFlow.acceptEvent(action, tenantType);
	}
	
	@Then("^Prepare estimate$")
	public void prepareEstimate(DataTable estimates) {
		eventFlow.prepareEstimate(estimates);
	}
	
	@Then("Delete the DraftEvent")
	public void delete_the_DraftEvent() throws InterruptedException, AWTException {
		eventFlow.Deletedraftevent();		
	}
	

}