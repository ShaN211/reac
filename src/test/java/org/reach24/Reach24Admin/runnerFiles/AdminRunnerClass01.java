package org.reach24.Reach24Admin.runnerFiles;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.reach24.Reach24Admin.util.BeforeAndAfterScenarios;
import org.reach24.Reach24Admin.util.BrowserConfig;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/", 
strict = true, glue = "org/reach24/Reach24Admin/stepDefinations")

//  plugin = {"pretty", "com.epam.reportportal.cucumber.StepReporter" })
 
public class AdminRunnerClass01 {

	
	static BrowserConfig browserConfig = new BrowserConfig();
	static BeforeAndAfterScenarios beforeScenarios = new BeforeAndAfterScenarios();

	@BeforeClass
	public static void setup() {
		beforeScenarios.loginTenant("TD");
		beforeScenarios.loginTenant("CC");
		beforeScenarios.loginTenant("SP");	
	}

    @AfterClass
	public static void tearDown() {
	//	browserConfig.closeDriver();
	}
}
