package com.dmos.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.dmos.steps.ActionSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
public class LoginWithinValidUserName {
	@Managed
	WebDriver driver;

	@Steps
	ActionSteps user;

	@Test
	@Title("Sign in to application with invalid user name")
	public void signinWithInvalidUserName() throws InterruptedException {

		user.navigateToLoginPage();

		user.doLogin("hello", "test");

		String greetingMessage = user.getMessageOnInvalidLogin();

		assertEquals("Login failed due to incorrect username or password.", greetingMessage);

	}
}
