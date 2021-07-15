 package org.reach24.Reach24Admin.stepDefinations;

import java.awt.AWTException;

import org.reach24.Reach24Admin.steps.SCACwebformstep;
import org.reach24.Reach24Admin.steps.WebformStep;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WebformStepDefination {

	WebformStep webformStep = new WebformStep();
	SCACwebformstep scacwebformstep = new SCACwebformstep();

	@Given("^Create an Event in (.*) webform$")
	public void create_an_event(String company, DataTable eventData) throws AWTException, InterruptedException {
		webformStep.createEvent(company, eventData);		
	}
	
	@Given("^Create an Event in (.*) webform scac$")
	public void create_an_event_scac(String company, DataTable eventData) throws AWTException, InterruptedException {
		scacwebformstep.createEvent(company, eventData);
	}
	
	@When("Enter service data in Webform")
	public void enterServiceData(DataTable eventData) {
		webformStep.enterServiceData(eventData);
	}
	
	
	@When("^Enter payment Details -- (.*)$")
	public void enterPaymentMethod(String paymentMethod) {
		webformStep.enterPaymantDetails(paymentMethod);
	}
	
	@When("^Enter Driver's Info$")
	public void enterDriverInfo() {
		webformStep.enterDriverInfo();
	}
	
	@Then("verify event created")
	public void VerifyEventCreated() {
		webformStep.verification();
	}
}
