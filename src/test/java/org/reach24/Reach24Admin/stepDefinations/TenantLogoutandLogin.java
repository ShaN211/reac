package org.reach24.Reach24Admin.stepDefinations;

import org.reach24.Reach24Admin.util.BeforeAndAfterScenarios;

import io.cucumber.java.en.Given;

public class TenantLogoutandLogin {
	
	BeforeAndAfterScenarios beforescenario= new BeforeAndAfterScenarios();

	@Given("^Logout as -- (.*)$")
	public void logoutTenant(String tenantType){
		 beforescenario.logoutTenant(tenantType);
		
	}

	@Given("^Login as -- (.*)$")
	public void loginTenant(String tenantType){
		beforescenario.loginTenant(tenantType);
	}
}
