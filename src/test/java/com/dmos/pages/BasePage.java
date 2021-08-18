package com.dmos.pages;

import net.serenitybdd.core.pages.PageObject;

public class BasePage extends PageObject {
	private static final String USER_NAME_INPUT = "//*[@id=\"mat-input-0\"]";

	private static final String PASSWORD_INPUT = "//*[@id=\"mat-input-1\"]";

	private static final String LOGIN_BUTTON = "/html/body/app-root/div/div[2]/app-login/div/form/div[4]/div[1]/button";

	private static final String REGISTER_NOW_LINK = "/html/body/app-root/div/div[2]/app-login/div/form/div[4]/div[2]/button";

	private static final String INVALID_LOGIN_LABEL = "/html/body/app-root/div/div[2]/app-login/div/form/div[2]";
	
	
	

	public void navigateToSignOnPage() {

		open();

		waitForTextToAppear("Financial Analysis and Intelligence System-Elite (FAIS-E)");

	}

	public DashBoardPage signOut() {

//		waitFor(SIGN_OUT_LINK).$(SIGN_OUT_LINK).click();
//
//		waitForAbsenceOf(SIGN_OUT_LINK).shouldNotBeVisible(By.xpath(SIGN_OUT_LINK));

		return this.switchToPage(DashBoardPage.class);
	}

	public DashBoardPage navigateToDashBoard() {

//		waitFor(LOGO_LINK).$(LOGO_LINK).click();

		return this.switchToPage(DashBoardPage.class);
	}

	public AccountsPage navigateToAccountPage() {

//		waitFor(MY_ACCT_LINK).$(MY_ACCT_LINK).click();

		return this.switchToPage(AccountsPage.class);

	}

	public LoginPage clickSignOnLink() {
//		waitFor(SIGN_IN_LINK).$(SIGN_IN_LINK).click();
		return this.switchToPage(LoginPage.class);
	}
	
	public DashBoardPage doLogin(String userName, String password) {

		waitForTextToAppear("Login");

//		waitForTextToAppear("Need a user name and password?");

		waitFor(USER_NAME_INPUT).$(USER_NAME_INPUT).type(userName);

		waitFor(PASSWORD_INPUT).$(PASSWORD_INPUT).type(password);

		waitFor(LOGIN_BUTTON).$(LOGIN_BUTTON).click();

		return this.switchToPage(DashBoardPage.class);

	}

	public AccountsPage navigateToRegistrationPage() {

		waitForTextToAppear("Please enter your username and password.");

		waitForTextToAppear("Need a user name and password?");

		waitFor(REGISTER_NOW_LINK).$(REGISTER_NOW_LINK).click();

		return this.switchToPage(AccountsPage.class);

	}

	public String getMessageOnInvalidLogin() {

		return waitFor(INVALID_LOGIN_LABEL).$(INVALID_LOGIN_LABEL).getText().trim();
	}

}
