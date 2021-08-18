package com.dmos.tests;

import static org.junit.Assert.assertEquals;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.dmos.steps.ActionSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
public class AccountsPageTest {

	@Managed
	WebDriver driver;

	@Steps
	ActionSteps user;

	@Test
	@Title("Sign in to application")
	public void addNewUserToStoreAndVerify() throws InterruptedException {

		user.navigateToLoginPage();

		user.doLogin("test", "test");

		String greetingMessage = user.getGreetingMessage();

		assertEquals("Total Revenue by Rental To-Date", greetingMessage);

	}

}
