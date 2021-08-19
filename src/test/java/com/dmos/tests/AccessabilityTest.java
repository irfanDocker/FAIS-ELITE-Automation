package com.dmos.tests;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.dmos.steps.AccessabilitySteps;
import com.dmos.steps.ActionSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
public class AccessabilityTest {
	
	@Managed
	WebDriver driver;

	@Steps
	ActionSteps user;
	
	@Steps
	AccessabilitySteps accessabilitySteps;

	@Test
	@Title("508 test")
	public void checking508Issue() throws Throwable {

		user.navigateToLoginPage();

		accessabilitySteps.test_accessability_for_with_Pally("https://www.faise.app/");
		

	}

}
