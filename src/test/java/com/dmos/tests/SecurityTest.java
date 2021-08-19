package com.dmos.tests;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.dmos.steps.ActionSteps;
import com.dmos.steps.ZapSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
public class SecurityTest {
	@Managed
	WebDriver driver;

	@Steps
	ActionSteps user;
	
	@Steps
	ZapSteps zapSteps;

	@Test
	@Title("Security Test")
	public void verifySecurityIssue() throws Throwable  {

		user.navigateToLoginPage();

		user.doLogin("test", "test");

		zapSteps.Zap_is_launched();
		
		zapSteps.Extract_ZAP_Alerts();
		
		zapSteps.Exit_ZAP();

	}

}
