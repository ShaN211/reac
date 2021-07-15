package org.reach24.Reach24Admin.stepDefinations;

import org.reach24.Reach24Admin.steps.TenantCreationSteps;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class TenantStepDefination {
	
	TenantCreationSteps tenantCreateStep  = new TenantCreationSteps();
	
	@Given("Create a tenant")
	public void create_a_tenant(DataTable tenantData) {
		tenantCreateStep.createTenant(tenantData);
	}
	
	@Then("Verify if tenant is created")
	public void Verify_if_tenant_is_created() {
	    System.out.println("Step 2 completed");
	    
	}
	
}
